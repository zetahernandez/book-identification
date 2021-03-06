// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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