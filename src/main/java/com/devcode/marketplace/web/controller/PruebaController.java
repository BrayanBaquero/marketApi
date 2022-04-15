package com.devcode.marketplace.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PruebaController {

    @GetMapping
    public ResponseEntity<String> holaMundo(){
        return ResponseEntity.status(200).body("Hola mundo");
    }
}
