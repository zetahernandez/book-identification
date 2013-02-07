package com.book.identification.model;

import javax.persistence.Entity;


/**
 * Physical dimensions of this volume.
 */
@Entity
public final class Dimensions extends EntityBase {

  /**
   * Height or length of this volume (in cm).
   * The value may be {@code null}.
   */

  private String height;

  /**
   * Thickness of this volume (in cm).
   * The value may be {@code null}.
   */

  private String thickness;

  /**
   * Width of this volume (in cm).
   * The value may be {@code null}.
   */

  private String width;

  /**
   * Height or length of this volume (in cm).
   * The value returned may be {@code null}.
   */
  public String getHeight() {
    return height;
  }

  /**
   * Height or length of this volume (in cm).
   * The value set may be {@code null}.
   */
  public void setHeight(String height) {
    this.height = height;
    
  }

  /**
   * Thickness of this volume (in cm).
   * The value returned may be {@code null}.
   */
  public String getThickness() {
    return thickness;
  }

  /**
   * Thickness of this volume (in cm).
   * The value set may be {@code null}.
   */
  public void setThickness(String thickness) {
    this.thickness = thickness;
    
  }

  /**
   * Width of this volume (in cm).
   * The value returned may be {@code null}.
   */
  public String getWidth() {
    return width;
  }

  /**
   * Width of this volume (in cm).
   * The value set may be {@code null}.
   */
  public void setWidth(String width) {
    this.width = width;
    
  }

@Override
public String toString() {
	return "Dimensions [height=" + height + ", thickness=" + thickness
			+ ", width=" + width + "]";
}

}