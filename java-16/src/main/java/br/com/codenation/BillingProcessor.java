package br.com.codenation;

public class BillingProcessor {

    public Double calculate(Order order) {
        if (order.getPaymentMethod() == null){
            throw new RuntimeException("Payment method not implemented");
        }
        return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
    }
}