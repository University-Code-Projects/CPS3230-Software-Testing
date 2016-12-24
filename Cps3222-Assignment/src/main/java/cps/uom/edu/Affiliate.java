package cps.uom.edu;

/**
 * Created by jonathan on 29/11/2016.
 */
public class Affiliate {
    public int id;
    public String name, password;
    public AffiliateType type;
    public double balance;



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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
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

    public Affiliate(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public Affiliate(int id) {
        this.id = id;
    }

    // override equals method to compare with ID
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Affiliate) {
            final Affiliate other = (Affiliate) object;
            return other.id == this.id;//checking that only the id is unique
        }
        return false;
    }
}
