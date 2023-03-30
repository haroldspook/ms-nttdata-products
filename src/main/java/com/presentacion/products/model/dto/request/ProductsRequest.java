package com.presentacion.products.model.dto.request;

import com.presentacion.products.model.entity.Active;
import com.presentacion.products.model.entity.Pasive;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * clase ProductsRequest
 */
@Data
@ApiModel("Model ProductRequest")
public class ProductsRequest {

    @ApiModelProperty(value = "id" , position = 1, example = "1")
    private Long id;
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
