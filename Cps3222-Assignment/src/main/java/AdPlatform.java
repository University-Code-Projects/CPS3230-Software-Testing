import java.util.Collection;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdPlatform {
    private Collection<Affiliate> affiliates;
    private Collection<AdProvider> adProviders;

    public Collection<Affiliate> getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(Collection<Affiliate> affiliates) {
        this.affiliates = affiliates;
    }

    public Collection<AdProvider> getAdProviders() {
        return adProviders;
    }

    public void setAdProviders(Collection<AdProvider> adProviders) {
        this.adProviders = adProviders;
    }

    public boolean registerAffiliate(Affiliate affiliate){
        return false;
    }

    public boolean settleAffiliateBalance(Affiliate affiliate){
        return false;
    }

    public boolean serveAdvert(AdDescription adDescription){
        return false;
    }

    public void adClicked(int affliateID){
        return;
    }
}
