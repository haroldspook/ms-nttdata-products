package com.presentacion.products.model.entity;

import lombok.Data;

/**
 * Modelo con tipos de cuentas Actios (créditos): personal, empresarial, tarjeta de credito.
 */
@Data
public class Active {
    private Boolean personal;
    private Boolean entreprise;
    private Boolean tc;
}
