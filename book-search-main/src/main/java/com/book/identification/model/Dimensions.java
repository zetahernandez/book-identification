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