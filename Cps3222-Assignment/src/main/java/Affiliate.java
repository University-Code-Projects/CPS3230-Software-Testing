/**
 * Created by jonathan on 29/11/2016.
 */
public class Affiliate {
    private int id;
    private String name;
    private AffiliateType type;
    private long balance;

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AffiliateType getType() {
        return type;
    }

    public long getBalance() {
        return balance;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(AffiliateType type) {
        this.type = type;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
