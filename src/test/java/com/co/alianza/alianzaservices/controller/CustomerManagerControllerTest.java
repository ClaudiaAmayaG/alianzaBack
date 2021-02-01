package com.co.alianza.alianzaservices.controller;

import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;
import com.co.alianza.alianzaservices.service.ICustomerManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerManagerControllerTest {

    @Mock
    private ICustomerManagerService customerManagerService;

    @InjectMocks
    private CustomerManagerController customerManagerController;

    @Test
    public void searchCustomersSuccessFull(){
        List<CustomerDetailDto> customerDetailList = new ArrayList<>();
        CustomerDetailDto customerDetail1 = CustomerDetailDto.builder()
                .sharedKey("ctorres")
                .name("Carlos Torres")
                .phone("3152698543")
                .email("ctorres@gmail.com")
                .dataAdded(new Date())
                .build();
        customerDetailList.add(customerDetail1);
        CustomerDetailDto customerDetail2 = CustomerDetailDto.builder()
                .sharedKey("jgonzalez")
                .name("Juan Gonzalez")
                .phone("3102589632")
                .email("juang@gmail.com")
                .dataAdded(new Date())
                .build();
        customerDetailList.add(customerDetail2);
        when(customerManagerService.searchCustomers(any())).thenReturn(customerDetailList);
        SearchCustomerDTO searchCustomer = SearchCustomerDTO.builder()
                .sharedKey(null)
                .name(null)
                .phone(null)
                .email(null)
                .startDate(null)
                .endDate(null)
                .build();
        List<CustomerDetailDto> response = customerManagerController.searchCustomers(searchCustomer);
        Assert.assertNotNull(response);
    }

    @Test
    public void createCustomerSuccessFull(){
        when(customerManagerService.createCustomer(any())).thenReturn(true);
        CreateCustomer createCustomer = CreateCustomer.builder()
                .name("Julian Rojas")
                .phone("3147895142")
                .email("jrojas@gmail.com")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        Boolean response = customerManagerController.createCustomer(createCustomer);
        Assert.assertTrue(response);
    }
}
