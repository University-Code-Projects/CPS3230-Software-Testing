package cps.uom.edu;

/**
 * PaymentProvider interface
 */
public interface PaymentProvider {
    public boolean makePayment(int bankAccount, float amount);
}
