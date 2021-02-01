package com.co.alianza.alianzaservices.service;

import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;
import com.co.alianza.alianzaservices.entities.Customer;
import com.co.alianza.alianzaservices.exception.FileException;
import com.co.alianza.alianzaservices.repository.CustomerRepository;
import com.co.alianza.alianzaservices.service.implement.CustomerManagerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerManagerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerManagerServiceImpl customerManagerServiceImpl;

    @Test
    public void searchCustomersSuccessFull(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = Customer.builder()
                .id("1")
                .sharedKey("ctorres")
                .name("Carlos Torres")
                .phone("3152698543")
                .email("ctorres@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        customerList.add(customer1);
        Customer customer2 = Customer.builder()
                .id("2")
                .sharedKey("jgonzalez")
                .name("Juan Gonzalez")
                .phone("3102589632")
                .email("juang@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        customerList.add(customer2);
        when(customerRepository.searchForFilters(null,null,null,null,null,null))
                .thenReturn(customerList);
        SearchCustomerDTO searchCustomer = SearchCustomerDTO.builder()
                .sharedKey(null)
                .name(null)
                .phone(null)
                .email(null)
                .startDate(null)
                .endDate(null)
                .build();
        List<CustomerDetailDto> response = customerManagerServiceImpl.searchCustomers(searchCustomer);
        Assert.assertTrue(response.size() != 0);
    }

    @Test
    public void searchCustomersSuccessFullData(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = Customer.builder()
                .id("1")
                .sharedKey("ctorres")
                .name("Carlos Torres")
                .phone("3152698543")
                .email("ctorres@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        customerList.add(customer1);
        when(customerRepository.searchForFilters("ctorres",null,null,null,null,null))
                .thenReturn(customerList);
        SearchCustomerDTO searchCustomer = SearchCustomerDTO.builder()
                .sharedKey("ctorres")
                .name(null)
                .phone(null)
                .email(null)
                .startDate(null)
                .endDate(null)
                .build();
        List<CustomerDetailDto> response = customerManagerServiceImpl.searchCustomers(searchCustomer);
        Assert.assertTrue(response.size()!= 0);
    }

    @Test
    public void searchCustomersSuccessFullNoData(){
        List<Customer> customerList = new ArrayList<>();
        when(customerRepository.searchForFilters(null,null,null,null,null,null))
                .thenReturn(customerList);
        SearchCustomerDTO searchCustomer = SearchCustomerDTO.builder()
                .sharedKey(null)
                .name(null)
                .phone(null)
                .email(null)
                .startDate(null)
                .endDate(null)
                .build();
        List<CustomerDetailDto> response = customerManagerServiceImpl.searchCustomers(searchCustomer);
        Assert.assertTrue(response.size() == 0);
    }

    @Test(expected = FileException.class)
    public void searchCustomersException(){
        when(customerRepository.searchForFilters("ctorres",null,null,null,null,null))
                .thenThrow(new FileException("Error", HttpStatus.INTERNAL_SERVER_ERROR));
        SearchCustomerDTO searchCustomer = SearchCustomerDTO.builder()
                .sharedKey("ctorres")
                .name(null)
                .phone(null)
                .email(null)
                .startDate(null)
                .endDate(null)
                .build();
        customerManagerServiceImpl.searchCustomers(searchCustomer);
    }

    @Test
    public void createCustomerSuccessFull(){
        Customer newCustomer = Customer.builder()
                .sharedKey("ctorres")
                .name("Carlos Torres")
                .phone("3152698543")
                .email("ctorres@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        when(customerRepository.save(any())).thenReturn(newCustomer);
        CreateCustomer createCustomer = CreateCustomer.builder()
                .name("Carlos Torres")
                .phone("3152698543")
                .email("ctorres@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        Boolean response = customerManagerServiceImpl.createCustomer(createCustomer);
        Assert.assertTrue(response);
    }

    @Test(expected = FileException.class)
    public void createCustomerDataException(){
        customerManagerServiceImpl.createCustomer(null);
    }

    @Test(expected = FileException.class)
    public void createCustomerException(){
        CreateCustomer createCustomer = CreateCustomer.builder()
                .name("")
                .phone("3152698543")
                .email("ctorres@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        customerManagerServiceImpl.createCustomer(createCustomer);
    }
}
