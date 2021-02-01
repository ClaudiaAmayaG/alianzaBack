package com.co.alianza.alianzaservices.controller;

import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;
import com.co.alianza.alianzaservices.endpoint.CustomerManagerEndpoint;
import com.co.alianza.alianzaservices.service.ICustomerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(CustomerManagerEndpoint.CUSTOMER_MANAGER)
@RestController
public class CustomerManagerController {

    @Autowired
    private ICustomerManagerService customerManagerService;

    /**
     * Method to search customers
     *
     * @return List<CustomerDTO>
     */
    @PostMapping(value = CustomerManagerEndpoint.SEARCH_CUSTOMER)
    public List<CustomerDetailDto> searchCustomers(@RequestBody SearchCustomerDTO searchCustomer){
        return customerManagerService.searchCustomers(searchCustomer);
    }

    /**
     * Method to create customer
     * @param CreateCustomer
     * @return Boolean
     */
    @PostMapping(value = CustomerManagerEndpoint.CREATE_CUSTOMER)
    public Boolean createCustomer(@RequestBody CreateCustomer createCustomer){
        return customerManagerService.createCustomer(createCustomer);
    }
}
