package com.co.alianza.alianzaservices.service.implement;

import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;
import com.co.alianza.alianzaservices.entities.Customer;
import com.co.alianza.alianzaservices.repository.CustomerRepository;
import com.co.alianza.alianzaservices.service.ICustomerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManagerService implements ICustomerManagerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerDetailDto> getCustomerList() {
        List<CustomerDetailDto> customerDetailList = new ArrayList<>();
        Iterable<Customer> customerList = this.customerRepository.findAll();
        customerList.forEach(customer -> {
                CustomerDetailDto customerDetail = CustomerDetailDto.builder()
                                                        .sharedKey(customer.getSharedKey())
                                                        .name(customer.getName())
                                                        .phone(customer.getPhone())
                                                        .email(customer.getEmail())
                                                        .dataAdded(customer.getStartDate()).build();

                customerDetailList.add(customerDetail);
            });

        return customerDetailList;
    }

    @Override
    public List<CustomerDetailDto> searchCustomer(SearchCustomerDTO searchCustomer) {
        List<CustomerDetailDto> customerDetailList = new ArrayList<>();
        CustomerDetailDto customer1 = new CustomerDetailDto();
        customer1.setSharedKey("pgonzalez");
        customer1.setName("Pedro Gonzalez");
        customer1.setPhone("31245896");
        customer1.setEmail("pedro@gmail.com");
        if(customer1.getSharedKey().equals(searchCustomer.getSharedKey())){
            customerDetailList.add(customer1);
        }
        return customerDetailList;
    }
}
