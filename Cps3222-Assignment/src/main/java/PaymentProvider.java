/**
 * Created by jonathan on 29/11/2016.
 */
public interface PaymentProvider {
    public boolean makePayment(int bankAccount, float amount);
}
