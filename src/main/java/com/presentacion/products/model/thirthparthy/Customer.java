package com.presentacion.products.model.thirthparthy;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String last;
    private Integer age;
    private Boolean status;
    private String typeDocument;
    private Integer numberDocument;
    private Integer typeCustomer;
    private Date createAt;
}
