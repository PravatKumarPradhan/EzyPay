package com.ezypay.task;

import com.ezypay.task.dto.SubscriptionTypeEnum;
import com.ezypay.task.entity.Subscription;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Pravat Kumar Pradhan
 */
public class SubscriptionServiceControllerTest extends AbstractTest {
 @Override
 @Before
 public void setUp() {
  super.setUp();
 }
 @Test
 public void createSubscription() throws Exception {
  String uri = "/sub/create";
  Subscription subscription = new Subscription();

  subscription.setAmount(20.00);
  subscription.setActive(true);
  subscription.setCreatedBy("Pravat");
  subscription.setSubType(SubscriptionTypeEnum.WEEKLY);
  subscription.setEndDate(new Date(System.currentTimeMillis()));
  subscription.setStartDate(new Date(System.currentTimeMillis()));
  String inputJson = super.mapToJson(subscription);
  MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();

  int status = mvcResult.getResponse().getStatus();
  assertEquals(200, status);
  String content = mvcResult.getResponse().getContentAsString();
  assertEquals(content, content);
 }
}
