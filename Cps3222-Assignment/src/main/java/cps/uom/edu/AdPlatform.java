package cps.uom.edu;

import java.util.*;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdPlatform {
    private Collection<Affiliate> affiliates;
    private Collection<AdProvider> adProviders;

    public AdPlatform() {
        this.affiliates = new ArrayList<Affiliate>();
        this.adProviders = new ArrayList<AdProvider>();
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
    public boolean validator(Affiliate a){
        for (Affiliate aff : affiliates){
            if(aff.getId() == a.getId()){
                System.out.println(a.getPassword());
                System.out.println(aff.getPassword());
                if(aff.getPassword().equals(a.getPassword())){
                    return true;
                }
            }
        }
        return false;
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


    public boolean registerAffiliate(Affiliate affiliate){
        // contains uses the default method equals(obj), which we override
        for (Affiliate aff : affiliates){
            if(aff.getId() == affiliate.getId()){
                return false;
            }
        }
        affiliates.add(affiliate);
        return true;
    }

    public boolean settleAffiliateBalance(Affiliate affiliate){
        //check balance is greater than 5
        if(affiliate.getBalance() >= 5){
            //ask for payment provider
            //check type of affiliate and set commission accordingly
            double comm =0;
            if(affiliate.getType() == AffiliateType.GOLD){
                comm = affiliate.getBalance() * 0.05;
            }else if(affiliate.getType() == AffiliateType.SILVER) {
                comm = affiliate.getBalance() * 0.075;
            }else{//type is bronze
                comm = affiliate.getBalance() * 0.1;
            }
            affiliate.setCommissionGenerated(affiliate.getCommissionGenerated() + comm);
            System.out.println("Balance withdrawn: "+ (affiliate.getBalance() - comm));
            System.out.println("Commission on withdrawal: "+ comm);
            affiliate.setBalance(0);
            //type was unchanged
            //assumption that a user cannot downscale for previous state
            updateAffiliate(affiliate);
            return true;
        }
        return false;
    }

    public boolean serveAdvert(AdDescription adDescription){
        //checking adProviders to see any similar adDescriptions
        for (AdProvider adprov: adProviders) {     //iterating through the list of adProviders
            Advert a = adprov.serveAdvert(adDescription); //advert found by provider
            if (a != null) { //advert from provider found
                System.out.print("Same format");
                return true;
            }
        }
        return false;
    }

    public void adClicked(int affliateID){
        Affiliate aff = getAffiliate(affliateID);
        if(aff != null){
            //aff.setBalance(aff.getBalance()+ 25);//incrementing the affiliate balance by 50c

            aff.setBalance(aff.getBalance()+ 0.5);//incrementing the affiliate balance by 50c
            if(aff.getType()!= AffiliateType.GOLD){//if aff is gold cannot get promoted further
                if(aff.getBalance() >= 500){
                    aff.setType(AffiliateType.GOLD);
                } else if(aff.getBalance() >= 50){//setting the aff type according to his balance
                    aff.setType(AffiliateType.SILVER);
                }
            }
        }
        updateAffiliate(aff);
        return;
    }

    public boolean addProviderToList(AdProvider adProvider){
        for (AdProvider aprov : adProviders){
            if(aprov.name == adProvider.name){
                return false;
            }
        }
        adProviders.add(adProvider);
        return true;
    }
}
