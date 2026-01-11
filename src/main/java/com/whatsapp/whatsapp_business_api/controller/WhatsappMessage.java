package com.whatsapp.whatsapp_business_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Map;

@RestController
public class WhatsappMessage {

@GetMapping("/")
    public ResponseEntity<String> verifyWebhook(@RequestParam(value = "hub.mode", required = false) String mode,
                                                @RequestParam(value = "hub.challenge", required = false) String challenge,
                                                @RequestParam(value = "hub.verify_token", required = false) String token){
        System.out.println("mode: " + mode + " challenge: " + challenge + " token: " + token);

        return ResponseEntity.ok("connected");
    }

    @PostMapping("/")
    public ResponseEntity<String> handleWebhook(@RequestBody() Map<String, Object> body){
        System.out.println(body);

        return  ResponseEntity.ok("Webhook recieved");
    }
}
