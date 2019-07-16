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
        receipt.append(createReceiptHead());
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(createLineItemInformation(lineItem));
            double salesTax = lineItem.caculateSalesTax();
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        receipt.append(createReceiptEnd(totalSalesTax, totalAmount));
        return receipt.toString();
    }



    private String createReceiptEnd(double totalSalesTax, double totalAmount) {
        StringBuilder output = new StringBuilder();
        output.append(SALES_TAX);
        output.append(TAB);
        output.append(totalSalesTax);
        output.append(TOTAL_AMOUNT);
        output.append(TAB);
        output.append(totalAmount);
        return output.toString();
    }

    private String createReceiptHead() {
        StringBuilder output = new StringBuilder();
        output.append(PRINTING_ORDERS);
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        return output.toString();
    }

    private String createLineItemInformation(LineItem lineItem) {
        StringBuilder output = new StringBuilder();
        output.append(lineItem.getDescription());
        output.append(TAB);
        output.append(lineItem.getPrice());
        output.append(TAB);
        output.append(lineItem.getQuantity());
        output.append(TAB);
        output.append(lineItem.totalAmount());
        output.append(NEWLINE);
        return output.toString();
    }
}