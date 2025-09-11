package com.leco.api_crud.controller;

import com.leco.api_crud.DataTransferObject.ApiResponse;
import com.leco.api_crud.model.Product;
import com.leco.api_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    //insert a product into table
    @PostMapping("/product")
    public ResponseEntity<ApiResponse<Product>> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        ApiResponse<Product> response = new ApiResponse<>(
            HttpStatus.CREATED.value(),
            "Product successfully created",
            savedProduct

        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    //get product by id
    @GetMapping("/product")
    public ResponseEntity<ApiResponse<Product>>getProduct(@RequestParam(name = "productId") long productId){
        Product product = productService.getProduct(productId);
        ApiResponse<Product> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Get Product has success",
                product
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //get all products
    @GetMapping("/products")
    public ResponseEntity<ApiResponse<List<Product>>> getProducts(){
    List<Product> products = productService.getProducts();
    ApiResponse<List<Product>> response = new ApiResponse<>(
      HttpStatus.OK.value(),
      products.isEmpty() ? "No products found" : "Success get all products",
      products
    );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //update an existing product in the table
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId")long productId, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    //delete product in the table
    @DeleteMapping("/product")
    public ResponseEntity<Product>deleteProduct(@RequestParam(name = "productId") long productId){
        Product deleteProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

    //get product by name using raw SQL statement
    @GetMapping("/products-by-name")
    public List<Product>getProductsByName(@RequestParam(name = "productName") String productName){
        return productService.getProductsByName(productName);
    }
}
