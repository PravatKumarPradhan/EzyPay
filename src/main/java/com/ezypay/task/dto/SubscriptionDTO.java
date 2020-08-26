package com.ezypay.task.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
public class SubscriptionDTO {
 public Double subAmount;
 public String subscriptionType;
 public Date subStartDate;
 public Date subEndDate;
 public String createdBy;




}
