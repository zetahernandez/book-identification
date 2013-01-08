package com.book.identification.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
   * Any information about a volume related to the eBookstore and/or purchaseability. This information
   * can depend on the country where the request originates from (i.e. books may not be for sale in
   * certain countries).
   */
@Entity
  public final class SaleInfo extends EntityBase{

    /**
     * URL to purchase this volume on the Google Books site. (In LITE projection)
     * The value may be {@code null}.
     */
    
    private String buyLink;

    /**
     * The two-letter ISO_3166-1 country code for which this sale information is valid. (In LITE
     * projection.)
     * The value may be {@code null}.
     */
    
    private String country;

    /**
     * Whether or not this volume is an eBook (can be added to the My eBooks shelf).
     * The value may be {@code null}.
     */
    
    private Boolean isEbook;

    /**
     * Suggested retail price. (In LITE projection.)
     * The value may be {@code null}.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ListPrice listPrice;


    /**
     * The actual selling price of the book. This is the same as the suggested retail or list price
     * unless there are offers or discounts on this volume. (In LITE projection.)
     * The value may be {@code null}.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RetailPrice retailPrice;

    /**
     * Whether or not this book is available for sale or offered for free in the Google eBookstore for
     * the country listed above. Possible values are FOR_SALE, FREE, NOT_FOR_SALE, or FOR_PREORDER.
     * The value may be {@code null}.
     */
    
    private String saleability;

    /**
     * URL to purchase this volume on the Google Books site. (In LITE projection)
     * The value returned may be {@code null}.
     */
    public String getBuyLink() {
      return buyLink;
    }

    /**
     * URL to purchase this volume on the Google Books site. (In LITE projection)
     * The value set may be {@code null}.
     */
    public void setBuyLink(String buyLink) {
      this.buyLink = buyLink;
      
    }

    /**
     * The two-letter ISO_3166-1 country code for which this sale information is valid. (In LITE
     * projection.)
     * The value returned may be {@code null}.
     */
    public String getCountry() {
      return country;
    }

    /**
     * The two-letter ISO_3166-1 country code for which this sale information is valid. (In LITE
     * projection.)
     * The value set may be {@code null}.
     */
    public void setCountry(String country) {
      this.country = country;
      
    }

    /**
     * Whether or not this volume is an eBook (can be added to the My eBooks shelf).
     * The value returned may be {@code null}.
     */
    public Boolean getIsEbook() {
      return isEbook;
    }

    /**
     * Whether or not this volume is an eBook (can be added to the My eBooks shelf).
     * The value set may be {@code null}.
     */
    public void setIsEbook(Boolean isEbook) {
      this.isEbook = isEbook;
      
    }

    /**
     * Suggested retail price. (In LITE projection.)
     * The value returned may be {@code null}.
     */
    public ListPrice getListPrice() {
      return listPrice;
    }

    /**
     * Suggested retail price. (In LITE projection.)
     * The value set may be {@code null}.
     */
    public void setListPrice(ListPrice listPrice) {
      this.listPrice = listPrice;
      
    }

    /**
     * The actual selling price of the book. This is the same as the suggested retail or list price
     * unless there are offers or discounts on this volume. (In LITE projection.)
     * The value returned may be {@code null}.
     */
    public RetailPrice getRetailPrice() {
      return retailPrice;
    }

    /**
     * The actual selling price of the book. This is the same as the suggested retail or list price
     * unless there are offers or discounts on this volume. (In LITE projection.)
     * The value set may be {@code null}.
     */
    public void setRetailPrice(RetailPrice retailPrice) {
      this.retailPrice = retailPrice;
      
    }

    /**
     * Whether or not this book is available for sale or offered for free in the Google eBookstore for
     * the country listed above. Possible values are FOR_SALE, FREE, NOT_FOR_SALE, or FOR_PREORDER.
     * The value returned may be {@code null}.
     */
    public String getSaleability() {
      return saleability;
    }

    /**
     * Whether or not this book is available for sale or offered for free in the Google eBookstore for
     * the country listed above. Possible values are FOR_SALE, FREE, NOT_FOR_SALE, or FOR_PREORDER.
     * The value set may be {@code null}.
     */
    public void setSaleability(String saleability) {
      this.saleability = saleability;
    }

	@Override
	public String toString() {
		return "SaleInfo [buyLink=" + buyLink + ", country=" + country
				+ ", isEbook=" + isEbook + ", listPrice=" + listPrice
				+ ", retailPrice=" + retailPrice + ", saleability="
				+ saleability + "]";
	}
    
  }