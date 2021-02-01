package com.co.alianza.alianzaservices.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCustomer {

    private String name;
    private String phone;
    private String email;
    private Date startDate;
    private Date endDate;
}
