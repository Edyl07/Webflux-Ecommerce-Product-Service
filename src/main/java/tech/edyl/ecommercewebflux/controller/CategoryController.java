package tech.edyl.ecommercewebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.edyl.ecommercewebflux.dto.CategoryDto;
import tech.edyl.ecommercewebflux.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("all")
    public Flux<CategoryDto> all(){
        return this.categoryService.all();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<CategoryDto>> getCategoryById(@PathVariable int id){
        return this.categoryService
                .getCategoryById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<CategoryDto> createCategory(@RequestBody Mono<CategoryDto> categoryDtoMono){
        return this.categoryService
                .createCategory(categoryDtoMono);
    }


    @PutMapping("{id}")
    public Mono<ResponseEntity<CategoryDto>> updateCategory(@PathVariable int id,
                                                            @RequestBody Mono<CategoryDto> categoryDtoMono){
        return this.categoryService
                .updateCategory(id, categoryDtoMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteCategory(@PathVariable int id){
        return this.categoryService.deleteCategory(id);
    }
}
