package com.whatsapp.whatsapp_business_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class WhatsappMessage {

@GetMapping("/")
    public ResponseEntity<String> verifyWebhook(@RequestParam() Object param){
        System.out.println(param);

        return ResponseEntity.ok("connected");
    }

    @PostMapping("/")
    public ResponseEntity<String> handleWebhook(@RequestBody() Object body){
        System.out.println(body);

        return  ResponseEntity.ok("Webhook recieved");
    }
}
