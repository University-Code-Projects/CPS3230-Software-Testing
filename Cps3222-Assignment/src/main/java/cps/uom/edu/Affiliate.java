package cps.uom.edu;

/**
 * Created by jonathan on 29/11/2016.
 */
public class Affiliate {
    private int id;
    private String name;
    private AffiliateType type;
    private double balance;

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

    public double getBalance() {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Affiliate(int id) {
        this.id = id;
    }

    public Affiliate(int id, String name, AffiliateType type, double balance) {
        this.id = id;
        this.name = name;
        this.type = AffiliateType.BRONZE;
        this.balance = 0;
    }

    public Affiliate(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.type = AffiliateType.BRONZE;
        this.balance = 0;
    }

    // override equals method to compare with ID
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Affiliate) {
            final Affiliate other = (Affiliate) object;
            return other.getId() == this.getId();//checking that only the id is unique
        }
        return false;
    }
}
