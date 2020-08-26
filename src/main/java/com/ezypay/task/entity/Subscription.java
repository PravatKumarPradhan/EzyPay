package com.ezypay.task.entity;

import com.ezypay.task.dto.SubscriptionTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

import static com.ezypay.task.util.ApplicationConstants.DOUBLE_PRECISION;
import static com.ezypay.task.util.ApplicationConstants.DOUBLE_SCALE;

@Entity
@Table(name="t_subscription")

public class Subscription extends BaseEntity<Long> {

 @Column(name = "sub_amount", precision = DOUBLE_PRECISION, scale = DOUBLE_SCALE)
 private Double amount;
 @Column(name="sub_start_date")
 private Date startDate;
 @Column(name="sub_end_date")
 private Date endDate;

 @Enumerated(EnumType.ORDINAL)
 private SubscriptionTypeEnum subType;



 public Double getAmount() {
  return amount;
 }

 public Subscription setAmount(Double amount) {
  this.amount = amount;
  return this;
 }

 public Date getStartDate() {
  return startDate;
 }

 public Subscription setStartDate(Date startDate) {
  this.startDate = startDate;
  return this;
 }

 public Date getEndDate() {
  return endDate;
 }

 public Subscription setEndDate(Date endDate) {
  this.endDate = endDate;
  return this;
 }

 public SubscriptionTypeEnum getSubType() {
  return subType;
 }

 public Subscription setSubType(SubscriptionTypeEnum subType) {
  this.subType = subType;
  return this;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  Subscription that = (Subscription) o;
  return Objects.equals(amount, that.amount) &&
         Objects.equals(startDate, that.startDate) &&
         Objects.equals(endDate, that.endDate) &&
         subType == that.subType;
 }

 @Override
 public int hashCode() {
  return Objects.hash(amount, startDate, endDate, subType);
 }

 @Override
 public String toString() {
  return "Subscription{" +
         "amount=" + amount +
         ", startDate=" + startDate +
         ", endDate=" + endDate +
         ", subType=" + subType +
         '}';
 }
}
