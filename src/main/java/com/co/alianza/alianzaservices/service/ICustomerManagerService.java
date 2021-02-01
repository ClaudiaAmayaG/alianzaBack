package com.co.alianza.alianzaservices.service;

import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;

import java.util.List;

public interface ICustomerManagerService {

    /**
     * Method to search customers
     * @param SearchCustomerDTO
     * @return CustomerDetailDto
     */
    List<CustomerDetailDto> searchCustomers(SearchCustomerDTO searchCustomer);

    /**
     * Method to create customer
     * @param CreateCustomer
     * @return Boolean
     */
    Boolean createCustomer(CreateCustomer createCustomer);
}
