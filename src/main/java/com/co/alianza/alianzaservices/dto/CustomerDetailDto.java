package com.co.alianza.alianzaservices.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDetailDto {

    private String sharedKey;
    private String name;
    private String email;
    private String phone;
    private Date dataAdded;
}
