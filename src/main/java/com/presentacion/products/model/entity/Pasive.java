package com.presentacion.products.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Modelo con tipos de cuentas pasivos: ahorros, cuentas corrientes, plazos fijos.
 */
@Data
public class Pasive {
    @ApiModelProperty(value = "saving" , position = 1, example = "1")
    private Boolean saving;
    @ApiModelProperty(value = "currentAccount" , position = 1, example = "1")
    private Boolean currentAccount;
    @ApiModelProperty(value = "fixedTerm" , position = 1, example = "1")
    private Boolean fixedTerm;
}
