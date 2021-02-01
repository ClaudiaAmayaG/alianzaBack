package com.co.alianza.alianzaservices.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Class to transfer data from CustomerManager service
 * @author camaya@asesoftware.com
 */
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
