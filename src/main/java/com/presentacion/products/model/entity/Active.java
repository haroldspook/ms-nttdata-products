package com.presentacion.products.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Modelo con tipos de cuentas Actios (créditos): personal, empresarial, tarjeta de credito.
 */
@Data
public class Active {
    @ApiModelProperty(value = "personal" , position = 1, example = "1")

    private Boolean personal;
    @ApiModelProperty(value = "entreprise" , position = 1, example = "1")

    private Boolean entreprise;
    @ApiModelProperty(value = "tc" , position = 1, example = "1")

    private Boolean tc;
}
