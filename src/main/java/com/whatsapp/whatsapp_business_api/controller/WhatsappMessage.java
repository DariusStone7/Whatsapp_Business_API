package com.whatsapp.whatsapp_business_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WhatsappMessage {

    @Value("${VERIFY_TOKEN}")
    private String verify_token;

@GetMapping("/")
    public ResponseEntity<String> verifyWebhook(@RequestParam(value = "hub.mode", required = false) String mode,
                                                @RequestParam(value = "hub.challenge", required = false) String challenge,
                                                @RequestParam(value = "hub.verify_token", required = false) String token){
    System.out.println("verify_token = " + this.verify_token);
    System.out.println("mode: " + mode + " challenge: " + challenge + " token: " + token);
    if(mode.equals("subscribe") && this.verify_token.equals(token)){
        System.out.println("WEBHOOK VERIFY");
        return ResponseEntity.ok(challenge);
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error");

    }

    @PostMapping("/")
    public ResponseEntity<Void> handleWebhook(@RequestBody() Map<String, Object> body){
        System.out.println(body);

        return  ResponseEntity.ok().build();
    }
}
