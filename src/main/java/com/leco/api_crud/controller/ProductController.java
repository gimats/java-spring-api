package com.leco.api_crud.controller;

import com.leco.api_crud.DataTransferObject.ApiResponse;
import com.leco.api_crud.model.Product;
import com.leco.api_crud.service.ProductService;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
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

    //update an existing product in the table
    @PatchMapping("/product")
    public ResponseEntity<ApiResponse> updateProduct(@RequestParam(name = "productId")long productId, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(productId, product);
        ApiResponse<Product> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Product successfully updated",
                updateProduct
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //get product by id
    @GetMapping("/product")
    public ResponseEntity<ApiResponse<Product>>getProduct(@RequestParam(name = "productId") long productId){
        Product product = productService.getProduct(productId);
        if (product == null){
            ApiResponse<Product> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Product not found",
                    product
            );
            return new ResponseEntity<>(response, HttpStatus.OK); //return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); ini yang membuat http response code menjadi 404
        }
            ApiResponse<Product> response = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Get Product Success",
                    product
            );
        return new ResponseEntity<>(response, HttpStatus.OK);
        //dibawah ini kalo mau http status 200 hasil json 200 dengan messages no product found ketika
        //tidak ditemukan
//        ApiResponse<Product> response = new ApiResponse<>(
//                HttpStatus.OK.value(),
//                (product == null) ? "No product found" : "Get Product has success",
//                product
//        );
//        return new ResponseEntity<>(response, HttpStatus.OK);
        //sampai sini

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

    //delete product in the table
    @DeleteMapping("/product")
    public ResponseEntity<Product>deleteProduct(@RequestParam(name = "productId") long productId){
        Product deleteProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

    //get product by name using raw SQL statement
    @GetMapping("/products-by-name")
    public ResponseEntity<ApiResponse<List<Product>>>getProductsByName(@RequestParam(name = "productName") String productName){
        List<Product> product = productService.getProductsByName(productName);
        ApiResponse<List<Product>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Get product has success",
                product
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
