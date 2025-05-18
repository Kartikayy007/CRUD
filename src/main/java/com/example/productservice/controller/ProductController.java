package com.example.productservice.controller;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "API endpoints for managing products in the system. Provides CRUD operations for creating, retrieving, updating, and deleting products.")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
        summary = "Create a new product",
        description = "Creates a new product with the provided details. The product must have a name, description, price, and stock quantity. All fields are required except for description which is optional.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Product created successfully", content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Possible reasons: missing required fields, invalid price format, negative stock quantity")
        }
    )
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @Operation(
        summary = "Get a product by ID",
        description = "Retrieves detailed information about a specific product using its unique identifier.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product", content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class)
            )),
            @ApiResponse(responseCode = "404", description = "Product not found. The specified ID does not exist in the system")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(
        summary = "Get all products",
        description = "Retrieves a list of all products in the system. The response includes active and inactive products.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of products", content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class)
            ))
        }
    )
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(
        summary = "Update a product",
        description = "Updates an existing product with new details. All fields are optional, only provide the fields you want to update.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class)
            )),
            @ApiResponse(responseCode = "404", description = "Product not found. The specified ID does not exist in the system"),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Possible reasons: invalid price format, negative stock quantity")
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @Operation(
        summary = "Delete a product",
        description = "Soft deletes a product by marking it as inactive. The product is not physically removed from the database.",
        responses = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully. The product is now marked as inactive."),
            @ApiResponse(responseCode = "404", description = "Product not found. The specified ID does not exist in the system")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Search products by name",
        description = "Searches for products whose name contains the specified search term. The search is case-insensitive and partial matches are allowed.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of matching products", content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProductDto.class)
            ))
        }
    )
    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProductsByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProductsByName(name));
    }

    @Operation(
        summary = "Get all active products",
        description = "Returns a list of all active products"
    )
    @GetMapping("/active")
    public ResponseEntity<List<ProductDto>> getActiveProducts() {
        return ResponseEntity.ok(productService.getActiveProducts());
    }
}
