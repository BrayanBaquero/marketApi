package com.devcode.marketplace.web.controller;

import com.devcode.marketplace.domain.Purchase;
import com.devcode.marketplace.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll(){
        return ResponseEntity.ok(purchaseService.getAll());
    }


    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "200", description = "Ok")
    })
    @Operation(summary = "Get purchases by client", description = "bar")
    @GetMapping("/client/{id}")
    private ResponseEntity<List<Purchase>> getByClient(@Parameter(description = "id of the client",example = "4546221") @PathVariable("id") String clientId){
        return purchaseService.getByClient(clientId)
                .map(purchases -> ResponseEntity.ok(purchases))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
