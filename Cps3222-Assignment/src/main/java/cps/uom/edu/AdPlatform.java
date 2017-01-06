package cps.uom.edu;

import java.util.*;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdPlatform {
    private Collection<Affiliate> affiliates;
    private Collection<AdProvider> adProviders;

    public AdPlatform() {//constructor used to initialise the lists
        this.affiliates = new ArrayList<Affiliate>();
        this.adProviders = new ArrayList<AdProvider>();
    }

    //get type from id of affiliate
    public AffiliateType getAffiliatesType(int id) {
        for (Affiliate aff : affiliates) {
            if (aff.getId() == id) {//since the affiliate was found in the collection
                return aff.getType();//use the getter to return his type
            }
        }
        return null;
    }

    //getting an instance needed
    public Affiliate getAffiliate(int affId){
        for (Affiliate aff : affiliates){
            if(aff.getId() == affId){//return the affiliate information
                return aff;
            }
        }
        return null;
    }

    //Checking that the affiliate given has an id and password which is found withing the system
    public boolean validator(Affiliate a){
        for (Affiliate aff : affiliates){
            if(aff.getId() == a.getId()){
                if(aff.getPassword().equals(a.getPassword())){//an affiliate with the same password and id was found
                    return true;
                }
            }
        }
        return false;
    }

    //updating the instance worked on to the collection
    public boolean updateAffiliate(Affiliate affiliate){
        for (Affiliate aff : affiliates){
            if(aff.getId() == affiliate.getId()){//override the data within the colleciton with the data given
                aff = affiliate;
                return true;
            }
        }
        return false;
    }


    public boolean registerAffiliate(Affiliate affiliate){
        // contains uses the default method equals(obj), which we override
        for (Affiliate aff : affiliates){
            if(aff.getId() == affiliate.getId()){//if an affiliate with the same id exists do not add the affiliate
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
            //System.out.println("Balance withdrawn: "+ (affiliate.getBalance() - comm));
            //System.out.println("Commission on withdrawal: "+ comm);
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
            aff.setBalance(aff.getBalance()+ 0.5);//incrementing the affiliate balance by 50c
            if(aff.getType()!= AffiliateType.GOLD){//if aff is gold cannot get promoted further
                if(aff.getBalance() >= 500){
                    aff.setType(AffiliateType.GOLD);
                } else if(aff.getBalance() >= 50){//setting the aff type according to his balance
                    aff.setType(AffiliateType.SILVER);
                }
            }
        }
        updateAffiliate(aff);//updating the affiliate within the collection accordingly
        return;
    }

    //adding the provider to the list
    public boolean addProviderToList(AdProvider adProvider){
        for (AdProvider aprov : adProviders){
            if(aprov.name == adProvider.name){//if a provider with the same name exists skip and return false
                return false;
            }
        }
        adProviders.add(adProvider);//else add the provider to the collection
        return true;
    }
}
