package tech.edyl.ecommercewebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.edyl.ecommercewebflux.dto.CategoryDto;
import tech.edyl.ecommercewebflux.dto.ProductRequestDto;
import tech.edyl.ecommercewebflux.dto.ProductResponseDto;
import tech.edyl.ecommercewebflux.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public Flux<ProductResponseDto> all(){
        return this.productService.all();
    }

    @PostMapping
    public Mono<ProductResponseDto> saveProduct(@RequestBody Mono<ProductRequestDto> requestDtoMono){
        return requestDtoMono.flatMap(this.productService::createProduct);
    }
}
