package com.ezypay.task.service;

import com.ezypay.task.dto.SubscriptionDTO;
import com.ezypay.task.dto.SubscriptionTypeEnum;
import com.ezypay.task.entity.Subscription;
import com.ezypay.task.repository.SubscriptionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravat Kumar Pradhan
 */
@Service
public class SubscriptionService {

 @Autowired
 SubscriptionRepository subscriptionRepository;

 /**
  *
  * @param subscriptionDTO
  * @return the subscription
  */
 public Subscription createSubscription(SubscriptionDTO subscriptionDTO){
  Subscription subscription=new Subscription();
  subscription.setActive(true);
  if(StringUtils.isNotBlank(subscriptionDTO.getSubscriptionType())){
   if(subscriptionDTO.getSubscriptionType().equalsIgnoreCase(SubscriptionTypeEnum.WEEKLY.toString())){
    subscription.setAmount(subscriptionDTO.getSubAmount());
    SubscriptionTypeEnum.WEEKLY.addSubscriptionType(subscriptionDTO,subscription);
   }
   if(subscriptionDTO.getSubscriptionType().equalsIgnoreCase(SubscriptionTypeEnum.MONTHLY.toString())){
    subscription.setAmount(subscriptionDTO.getSubAmount());
    SubscriptionTypeEnum.WEEKLY.addSubscriptionType(subscriptionDTO,subscription);
   }
  }
  return subscriptionRepository.save(subscription);
 }
}
