package com.co.alianza.alianzaservices.service;

import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;

import java.util.List;

/**
 * Interface to CustomerManagerService.
 *
 * @author camaya@asesoftware.com
 * @version 1.0.0
 */
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
