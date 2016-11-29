package cps.uom.edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdPlatform {
    private Collection<Affiliate> affiliates;
    private Collection<AdProvider> adProviders;

    public AdPlatform() {
        this.affiliates = new ArrayList<Affiliate>();
    }

    //get type from id of affiliate
    public AffiliateType getAffiliatesType(int id) {
        for (Affiliate aff : affiliates) {
            if (aff.getId() == id) {
                return aff.getType();
            }
        }
        return null;
    }

    //getting an instance needed
    public Affiliate getAffiliate(int affId){
        for (Affiliate aff : affiliates){
            if(aff.getId() == affId){
                return aff;
            }
        }
        return null;
    }

    //updating the instance worked on to the collection
    public boolean updateAffiliate(Affiliate affiliate){
        for (Affiliate aff : affiliates){
            if(aff.getId() == affiliate.getId()){
                aff = affiliate;
                return true;
            }
        }
        return false;
    }

    public void setAdProviders(Collection<AdProvider> adProviders) {
        this.adProviders = adProviders;
    }

    public boolean registerAffiliate(Affiliate affiliate){
        // contains uses the default method equals(obj), which we override
        for (Affiliate aff : affiliates){
            if(aff.getId() == affiliate.getId()){
                return false;
            }
        }
        affiliates.add(affiliate);
        return true;

/*
        if (!affiliates.contains(affiliate)) {//affiliate does not exist in collection
            // add to collection
            System.out.print("Test here");
        }
*/
    }

    public boolean settleAffiliateBalance(Affiliate affiliate){
        return false;
    }

    public boolean serveAdvert(AdDescription adDescription){
        return false;
    }

    public void adClicked(int affliateID){
        Affiliate aff = getAffiliate(affliateID);
        if(aff != null){
            aff.setBalance(aff.getBalance()+ 0.5);
        }
        updateAffiliate(aff);
        return;
    }
}
