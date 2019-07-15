package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private final char TAB = '\t';
    private final char NEWLINE = '\n';
    private final String PRINTING_ORDERS = "======Printing Orders======\n";
    private final String SALES_TAX = "Sales Tax";
    private final String TOTAL_AMOUNT = "Total Amount";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();
        appendReceiptHead(receipt);
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            appendLineItem(receipt, lineItem);
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        appendReceiptEnd(receipt, totalSalesTax, totalAmount);
        return receipt.toString();
    }

    private void appendReceiptEnd(StringBuilder receipt, double totalSalesTax, double totalAmount) {
        receipt.append(SALES_TAX);
        receipt.append(TAB);
        receipt.append(totalSalesTax);
        receipt.append(TOTAL_AMOUNT);
        receipt.append(TAB);
        receipt.append(totalAmount);
    }

    private void appendReceiptHead(StringBuilder receipt) {
        receipt.append(PRINTING_ORDERS);
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
    }

    private void appendLineItem(StringBuilder receipt, LineItem lineItem) {
        receipt.append(lineItem.getDescription());
        receipt.append(TAB);
        receipt.append(lineItem.getPrice());
        receipt.append(TAB);
        receipt.append(lineItem.getQuantity());
        receipt.append(TAB);
        receipt.append(lineItem.totalAmount());
        receipt.append(NEWLINE);
    }
}