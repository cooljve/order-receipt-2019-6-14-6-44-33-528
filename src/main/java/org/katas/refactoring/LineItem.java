package org.katas.refactoring;

public class LineItem {
  private final double TAX_RATE = .10;
  private String description;
  private double price;
  private int quantity;

  public LineItem(String description, double price, int quantity) {
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  double totalAmount() {
    return price * quantity;
  }

  public double caculateSalesTax() {
    return totalAmount() * TAX_RATE;
  }
}