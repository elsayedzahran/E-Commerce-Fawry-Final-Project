package com.fawryfinalproject.productapi.controller;

import com.fawryfinalproject.productapi.model.ProductModel;
import com.fawryfinalproject.productapi.model.ProductStoreModel;
import com.fawryfinalproject.productapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //-------------------------------------------------------------------------------------------//

    @GetMapping()
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    //-------------------------------------------------------------------------------------------//

    @GetMapping("/findAllForStore")
    public ResponseEntity<List<ProductStoreModel>> getAllProductsForStore() {
        return new ResponseEntity<>(productService.getAllProductsForStore(), HttpStatus.FOUND);
    }

    //-------------------------------------------------------------------------------------------//
    // use PathVariable
    @GetMapping("/{id}")
    public ResponseEntity<ProductStoreModel> getProductById(@PathVariable("id") Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.FOUND);
    }

    //-------------------------------------------------------------------------------------------//

    @GetMapping("/findByIds")
    public ResponseEntity<List<ProductStoreModel>> getAllProductsForStoreByIds(@RequestBody List<Long> productIds) {
        return new ResponseEntity<>(productService.getProductsForStoreByIds(productIds), HttpStatus.FOUND);
    }

    //-------------------------------------------------------------------------------------------//
    // remove attribute value
    @RequestMapping(value = "/search")
    public ResponseEntity<List<ProductModel>> getProductByIdOrNameOrCategory(@RequestParam(name = "keyword") String product) {
        return new ResponseEntity<>(productService.getProductByIdOrNameOrCategory(product), HttpStatus.FOUND);
    }

    //-------------------------------------------------------------------------------------------//

    @PostMapping(path = "/saveNewProduct")
    public ResponseEntity<String> createNewProduct(@RequestBody ProductModel productModel) {
        productService.createNewProduct(productModel);
        return new ResponseEntity<>("Entity Created", HttpStatus.CREATED);
    }

    //-------------------------------------------------------------------------------------------//

    @PutMapping(path = "/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductModel productModel, @PathVariable Long id) {
        productService.updateProduct(productModel, id);
        return new ResponseEntity<>("Entity Updated", HttpStatus.OK);
    }

    //-------------------------------------------------------------------------------------------//

    @DeleteMapping(value = "/deleteProduct")
    public ResponseEntity<String> deleteProductById(@RequestParam(value = "productId") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Entity Deleted", HttpStatus.OK);
    }


}
