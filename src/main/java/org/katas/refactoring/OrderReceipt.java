package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("======Printing Orders======\n");
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription());
            receipt.append('\t');
            receipt.append(lineItem.getPrice());
            receipt.append('\t');
            receipt.append(lineItem.getQuantity());
            receipt.append('\t');
            receipt.append(lineItem.totalAmount());
            receipt.append('\n');

            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        receipt.append("Sales Tax").append('\t').append(totalSalesTax);
        receipt.append("Total Amount").append('\t').append(totalAmount);
        return receipt.toString();
    }
}