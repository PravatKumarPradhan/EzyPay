package com.ezypay.task.dto;

import com.ezypay.task.entity.Subscription;
import com.ezypay.task.util.DateTimeUtil;

import java.time.LocalDate;

/**
 * @author Pravat Kumar Pradhan
 */
public enum SubscriptionTypeEnum {

 WEEKLY {
  @Override
  public void addSubscriptionType(SubscriptionDTO subscriptionDTO, Subscription subscription) {
   subscription.setSubType(WEEKLY);
   subscription.setStartDate(subscriptionDTO.getSubStartDate());
   LocalDate localDate= DateTimeUtil.convertToLocalDateViaInstant(subscriptionDTO.getSubStartDate());
   LocalDate localDate1= localDate.plusDays(7);
   subscription.setEndDate(DateTimeUtil.convertToDateViaInstant(localDate1));
  }
 }, MONTHLY {
  @Override
  public void addSubscriptionType(SubscriptionDTO subscriptionDTO, Subscription subscription) {
   subscription.setSubType(WEEKLY);
   subscription.setStartDate(subscriptionDTO.getSubStartDate());
   LocalDate localDate= DateTimeUtil.convertToLocalDateViaInstant(subscriptionDTO.getSubStartDate());
   localDate.plusDays(30);
   subscription.setEndDate(DateTimeUtil.convertToDateViaInstant(localDate));

  }

 }, YEARLY {
  @Override
  public void addSubscriptionType(SubscriptionDTO subscriptionDTO, Subscription subscription) {

  }
 };

 public abstract void addSubscriptionType(SubscriptionDTO subscriptionDTO, Subscription subscription);
}

