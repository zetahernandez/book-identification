package com.book.identification.model;

import javax.persistence.Entity;


/**
 * The actual selling price of the book. This is the same as the suggested retail or list price
 * unless there are offers or discounts on this volume. (In LITE projection.)
 */
@Entity
public final class RetailPrice extends EntityBase{

  /**
   * Amount in the currency listed below. (In LITE projection.)
   * The value may be {@code null}.
   */

  private Double amount;

  /**
   * An ISO 4217, three-letter currency code. (In LITE projection.)
   * The value may be {@code null}.
   */

  private String currencyCode;

  /**
   * Amount in the currency listed below. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * Amount in the currency listed below. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setAmount(Double amount) {
    this.amount = amount;
    
  }

  /**
   * An ISO 4217, three-letter currency code. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * An ISO 4217, three-letter currency code. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    
  }

@Override
public String toString() {
	return "RetailPrice [amount=" + amount + ", currencyCode=" + currencyCode
			+ "]";
}

}