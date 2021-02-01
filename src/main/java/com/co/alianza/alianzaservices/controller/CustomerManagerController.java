package com.co.alianza.alianzaservices.controller;

import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;
import com.co.alianza.alianzaservices.endpoint.CustomerManagerEndpoint;
import com.co.alianza.alianzaservices.service.ICustomerManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(CustomerManagerEndpoint.CUSTOMER_MANAGER)
@RestController
public class CustomerManagerController {

    private static final Logger logger = LogManager.getLogger(CustomerManagerController.class);

    private ICustomerManagerService customerManagerService;

    @Autowired
    public CustomerManagerController(ICustomerManagerService customerManagerService){
        this.customerManagerService = customerManagerService;
    }

    /**
     * Method to search customers
     *
     * @return List<CustomerDTO>
     */
    @PostMapping(value = CustomerManagerEndpoint.SEARCH_CUSTOMER)
    public List<CustomerDetailDto> searchCustomers(@RequestBody SearchCustomerDTO searchCustomer){
        logger.info("Iniciar searchCustomers:".concat(searchCustomer.toString()));
        return customerManagerService.searchCustomers(searchCustomer);
    }

    /**
     * Method to create customer
     * @param CreateCustomer
     * @return Boolean
     */
    @PostMapping(value = CustomerManagerEndpoint.CREATE_CUSTOMER)
    public Boolean createCustomer(@RequestBody CreateCustomer createCustomer){
        logger.info("Iniciar createCustomer:".concat(createCustomer.toString()));
        return customerManagerService.createCustomer(createCustomer);
    }
}
