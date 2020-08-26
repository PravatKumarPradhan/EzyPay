package com.ezypay.task.controller;

import com.ezypay.task.dto.SubscriptionDTO;
import com.ezypay.task.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pravat Kumar Pradhan
 */
@RestController
@RequestMapping("/sub")
public class SubscriptionController {

 SubscriptionService subscriptionService;

 @Autowired

 public SubscriptionController setSubscriptionService(SubscriptionService subscriptionService) {
  this.subscriptionService = subscriptionService;
  return this;
 }

 @RequestMapping("/create")
 @PostMapping
 public ResponseEntity<?> create(@RequestBody SubscriptionDTO subscriptionDTO){
  return ResponseEntity.ok(subscriptionService.createSubscription(subscriptionDTO));
 }
}
