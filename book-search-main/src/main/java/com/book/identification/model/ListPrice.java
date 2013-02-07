package com.book.identification.model;

import javax.persistence.Entity;


/**
 * Suggested retail price. (In LITE projection.)
 */
@Entity
public final class ListPrice extends EntityBase {

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
	return "ListPrice [amount=" + amount + ", currencyCode=" + currencyCode
			+ "]";
}

}