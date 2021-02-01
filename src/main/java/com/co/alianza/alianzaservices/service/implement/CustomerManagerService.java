package com.co.alianza.alianzaservices.service.implement;

import com.co.alianza.alianzaservices.controller.CustomerManagerController;
import com.co.alianza.alianzaservices.dto.CreateCustomer;
import com.co.alianza.alianzaservices.dto.CustomerDetailDto;
import com.co.alianza.alianzaservices.dto.SearchCustomerDTO;
import com.co.alianza.alianzaservices.entities.Customer;
import com.co.alianza.alianzaservices.exception.FileException;
import com.co.alianza.alianzaservices.repository.CustomerRepository;
import com.co.alianza.alianzaservices.service.ICustomerManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerManagerService implements ICustomerManagerService {

    private static final Logger logger = LogManager.getLogger(CustomerManagerService.class);

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerManagerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDetailDto> searchCustomers(SearchCustomerDTO searchCustomer) {
        try {
            List<CustomerDetailDto> customerDetailList = new ArrayList<>();
            List<Customer> customerList = this.customerRepository.searchForFilters(
                    searchCustomer.getSharedKey(),
                    searchCustomer.getName(),
                    searchCustomer.getPhone(),
                    searchCustomer.getEmail(),
                    searchCustomer.getStartDate(),
                    searchCustomer.getEndDate());
            if (customerList.size() > 0) {
                customerList.forEach(customer -> {
                    CustomerDetailDto customerDetail = CustomerDetailDto.builder()
                            .sharedKey(customer.getSharedKey())
                            .name(customer.getName())
                            .phone(customer.getPhone())
                            .email(customer.getEmail())
                            .dataAdded(customer.getStartDate()).build();

                    customerDetailList.add(customerDetail);
                });
            }

            logger.info("Proceso finalizado satisfactorio:".concat(String.valueOf(customerDetailList.size())));
            return customerDetailList;
        }catch (Exception e){
            logger.error("searchCustomers:".concat(e.getMessage()));
            throw new FileException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean createCustomer(CreateCustomer createCustomer){
        if (Objects.isNull(createCustomer)) {
            logger.error("Objeto createCustomer es nulo");
            throw new FileException("Solicitud con datos no completos", HttpStatus.BAD_REQUEST);
        }
        try {
            String name = createCustomer.getName();
            String[] namepart = name.split(" ");
            String sharedKey = (namepart[0].charAt(0) + namepart[1]).toLowerCase();
            Customer newCustomer = Customer.builder()
                    .sharedKey(sharedKey)
                    .name(createCustomer.getName())
                    .phone(createCustomer.getPhone())
                    .email(createCustomer.getEmail())
                    .startDate(createCustomer.getStartDate())
                    .endDate(createCustomer.getEndDate()).build();
            this.customerRepository.save(newCustomer);
            logger.info("Cliente creado satisfactoriamente");
            return true;
        }catch (Exception e){
            logger.error("createCustomer:".concat(e.getMessage()));
            throw new FileException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
