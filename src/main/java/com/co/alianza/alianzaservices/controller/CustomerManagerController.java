package com.co.alianza.alianzaservices.controller;

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
     * Method to get customer list
     *
     * @return List<CustomerDTO>
     */
    @GetMapping(value = CustomerManagerEndpoint.LIST_CUSTOMER)
    public List<CustomerDetailDto> getCustomerList() {

        return customerManagerService.getCustomerList();
    }

    /**
     * Method to search customer
     *
     * @return List<CustomerDTO>
     */
    @PostMapping(value = CustomerManagerEndpoint.SEARCH_CUSTOMER)
    public List<CustomerDetailDto> searchCustomer(@RequestBody SearchCustomerDTO searchCustomer){
        return customerManagerService.searchCustomer(searchCustomer);
    }
}
