package com.co.alianza.alianzaservices.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class SearchCustomerDTO {

    private String sharedKey;
    private String name;
    private String phone;
    private String email;
    private Date startDate;
    private Date endDate;
}
