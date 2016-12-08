
import com.sun.xml.internal.bind.v2.TODO;
import cps.uom.edu.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdPlatformTest {
    AdPlatform adPlatform;


    @Before
    public void setUp() throws Exception {
       adPlatform = new AdPlatform();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test//adding an element for the 1st time
    public void registerAffiliateTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", AffiliateType.GOLD,5);
        assertEquals(true,adPlatform.registerAffiliate(aff));
    }

    @Test//adding an element for the second time to a collection
    public void registerAffiliateFalse() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", AffiliateType.GOLD,5);
        adPlatform.registerAffiliate(aff);
        //adding same element twice
        assertEquals(false,adPlatform.registerAffiliate(aff));
    }

    @Test//checking that the type returns bronze when given silver
    public void registerAffiliateType() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", AffiliateType.GOLD,5);
        adPlatform.registerAffiliate(aff);
        assertEquals(AffiliateType.BRONZE,adPlatform.getAffiliatesType(1));
    }

    @Test//checking that the default type is bronze when type not given
    public void registerAffiliateTypeDefault() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertEquals(AffiliateType.BRONZE,adPlatform.getAffiliatesType(1));
    }

    @Test//checking that the default type is null when the object is not entered
    public void registerAffiliateTypeNull() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        assertEquals(null,adPlatform.getAffiliatesType(1));
    }

    @Test//checking that the affiliate returned exists in the collection
    public void getAffiliateTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertEquals(aff,adPlatform.getAffiliate(1));
    }

    @Test//checking that the affiliate returned does not exist in the collection
    public void getAffiliateFalse() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertEquals(null,adPlatform.getAffiliate(2));
    }

    @Test//checking that the balance was successfully updated in the object
    public void updateAffiliateTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertEquals(true,adPlatform.updateAffiliate(new Affiliate(1,"Client", 5.5)));
    }

    @Test//checking that the balance was unsuccessfully updated in the object
    public void updateAffiliateFalse() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertEquals(false,adPlatform.updateAffiliate(new Affiliate(6,"Client", 5.5)));
    }

    @Test//Testing that on creation of affiliation balance is 0
    public void testBalanceOnCreation() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertTrue(aff.getBalance()==0);
    }

    //create for loop, adClicked for x times to generate illusion of silver or gold promotion
    @Test//Checking affiliate is promoted to silver once reaching credit of 50
    public void affiliateTypeSilverTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        for(int i =0; i<=99;i++){
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        assertEquals(AffiliateType.SILVER,adPlatform.getAffiliatesType(1));
    }

    @Test//Checking affiliate is still bronze at 49.50 (bounds)
    public void affiliateTypeSilverFalse() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        for(int i =0; i<=98;i++){//aff should have 49.50
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        assertEquals(AffiliateType.BRONZE,adPlatform.getAffiliatesType(1));
    }

    //create for loop, adClicked for x times to generate illusion of silver or gold promotion
    @Test//Checking affiliate is promoted to silver once reaching credit of 500
    public void affiliateTypeGoldTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        for(int i =0; i<=999;i++){
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        System.out.print(aff.getBalance());
        assertEquals(AffiliateType.GOLD,adPlatform.getAffiliatesType(1));
    }

    @Test//Checking affiliate is still bronze at 499.50 (bounds)
    public void affiliateTypeGoldFalse() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        for(int i =0; i<=998;i++){//aff should have 49.50
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        assertEquals(AffiliateType.SILVER,adPlatform.getAffiliatesType(1));
    }

    //TEST cases when less than 5 credit, bronze with more than 5, silver, gold
    @Test//Setting Balance when affiliate has less than 5 credit
    public void affiliateSetBalanceLessThanFive() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        for(int i =0; i<=8;i++) {//aff should have 4.5
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        assertEquals(false,adPlatform.settleAffiliateBalance(aff));
    }

    @Test//Setting Balance when affiliate has less than 5 credit, resulting true
    public void affiliateSetBalanceTrue() throws Exception {
        Affiliate aff = new Affiliate(1, "Client", 5);
        adPlatform.registerAffiliate(aff);
        for (int i = 0; i <= 9; i++) {//aff should have 5
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        //affiliate should get an updated balance, to 0
        assertEquals(true, adPlatform.settleAffiliateBalance(aff));
    }

    //going to test serveAdvert
    //going to use mock tests
    @Test//testing serveAdvert
    public void affiliateServeAdvertTrue() throws Exception {
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        AdFormat format = null;
        AdDescription desc = new AdDescription(format, keys);

        AdProvider adprov = mock(AdProvider.class);
        when(adprov.serveAdvert(desc)).thenReturn(new Advert(1));
        adPlatform.addProviderToList(adprov);
        assertEquals(true, adPlatform.serveAdvert(desc));
    }

    @Test//testing serveAdvert when there is no adverts/providers found
    public void affiliateServeAdvertFalse() throws Exception {
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        AdFormat format = null;
        AdDescription desc = new AdDescription(format, keys);

        assertEquals(false, adPlatform.serveAdvert(desc));
    }
}