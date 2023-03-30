package com.presentacion.web.expose;

import com.presentacion.products.model.dto.request.ProductsRequest;
import com.presentacion.products.model.dto.response.ProductsResponse;
import com.presentacion.products.service.ProductsService;
import com.presentacion.products.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que representa al controllador
 */
@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "MICROSERVICIO PRODUCTS", description = "Microservicio desarrollado para Administrar los Productos")
@Slf4j
public class ProductsController {

    /**
     * Inyectamos la clase ProductServiceImpl
     */
    @Autowired
    private ProductsService productsService;

    /**
     * Método que listará los Product (Product)
     * @return Lista de Product Product
     */
    @GetMapping
    @ApiOperation(value = Constants.GET_ALL_VALUE, notes = Constants.GET_ALL_NOTE)
    public Observable<ProductsResponse> getAllProducts(){
        log.info("Obtencion de datos ");
        return productsService.findAllProducts();
    }

    /**
     * Metodo que eliminará todos los Product (Product)
     */
    @DeleteMapping
    @ApiOperation(value = Constants.DELETE_VALUE, notes = Constants.DELETE_NOTE)
    public Completable deleteListProducts(){
            log.info("Eliminar todos los datos");
        return productsService.delete();
    }

    /**
     * Método que registrará los Products
     * @param request
     * @return El mismo Product para ver su inserción
     */
    @PostMapping
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Single<ProductsResponse> saveProduct(@RequestBody ProductsRequest request){
        log.info("Envio de parametros");
        return productsService.saveProduct(request);

    }

}
