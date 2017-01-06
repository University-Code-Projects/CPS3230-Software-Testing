package cps.uom.edu;

/**
 * Created by jonathan on 29/11/2016.
 */
public class Affiliate {
    private int id;
    private String name, password;
    private AffiliateType type;
    private double balance, commissionGenerated;

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

    public double getCommissionGenerated() {
        return commissionGenerated;
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

    public void setCommissionGenerated(double commissionGenerated) {
        this.commissionGenerated = commissionGenerated;
    }

    public boolean isBronze(){
        return (this.getType() == (AffiliateType.BRONZE));
    }

    public boolean isSilver(){
        return (this.getType() == (AffiliateType.SILVER));
    }

    public boolean isGold(){
        return (this.getType() == (AffiliateType.GOLD));
    }

    public Affiliate(int id) {
        this.id = id;
    }

    public Affiliate(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.type = AffiliateType.BRONZE;
        this.balance = 0;
        this.commissionGenerated = 0;
    }

    public Affiliate(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.type = AffiliateType.BRONZE;
        this.commissionGenerated = 0;
    }

    public Affiliate(int id, String name, AffiliateType type, double balance) {
        this.id = id;
        this.name = name;
        this.type = AffiliateType.BRONZE;
        this.balance = 0;
        this.commissionGenerated = 0;
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
