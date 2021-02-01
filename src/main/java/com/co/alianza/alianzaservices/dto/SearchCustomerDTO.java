package com.co.alianza.alianzaservices.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchCustomerDTO {

    private String sharedKey;
    private String name;
    private String phone;
    private String email;
    private Date startDate;
    private Date endDate;
}
