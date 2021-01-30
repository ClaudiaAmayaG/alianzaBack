package com.co.alianza.alianzaservices.service;

import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;

import java.util.List;

public interface ICustomerManagerService {

    /**
     * Method to get customer list
     *
     * @return List<CustomerDTO>
     */
    List<CustomerDetailDto> getCustomerList();

    /**
     * Method to search customer
     * @param SearchCustomerDTO
     * @return CustomerDetailDto
     */
    List<CustomerDetailDto> searchCustomer(SearchCustomerDTO searchCustomer);
}
