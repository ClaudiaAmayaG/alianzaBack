package com.co.alianza.alianzaservices.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Class to receive data from CustomerManager service
 * @author camaya@asesoftware.com
 */
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
