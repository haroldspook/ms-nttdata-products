package com.presentacion.products.model.dto.response;

import com.presentacion.products.model.entity.Active;
import com.presentacion.products.model.entity.Pasive;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * Modelo de la clase que representa a la colección de mongo DB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("Products Response")
public class ProductsResponse {

    @ApiModelProperty(value = "id" , position = 1, example = "1")
    private String id;
    @ApiModelProperty(value = "numberDocument", required = true , position = 2, example = "77777777")
    private Integer numberDocument;
    @ApiModelProperty(value = "active", required = true , position = 3)
    private Active active;
    @ApiModelProperty(value = "pasive", required = true , position = 4)
    private Pasive pasive;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "createAt", required = true , position = 5)
    private Date createAt;


}
