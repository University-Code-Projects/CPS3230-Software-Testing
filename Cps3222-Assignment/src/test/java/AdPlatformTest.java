
import com.sun.xml.internal.bind.v2.TODO;
import cps.uom.edu.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
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

    @Test//adding an element for the second time to a collection - Test Double
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

    @Test//checking that the default type is bronze when type not given - Test Double
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

    @Test//checking that the affiliate does exist in the system with the same password and id
    public void validateAffiliateTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"pass1", "Client1");
        adPlatform.registerAffiliate(aff);
        Affiliate aff1 = new Affiliate(1,"pass1", "Client1");
        assertEquals(true,adPlatform.validator(aff1));
    }

    @Test//checking that the affiliate does not exist with same id and different password - Test Double
    public void validateAffiliateFalse() throws Exception {
        Affiliate aff = new Affiliate(1,"pass1", "Client1");
        adPlatform.registerAffiliate(aff);
        Affiliate aff1 = new Affiliate(1,"pass2", "Client1");
        assertEquals(false,adPlatform.validator(aff1));
    }

    @Test//checking that the affiliate returned exists in the collection
    public void getAffiliateTrue() throws Exception {
        Affiliate aff = new Affiliate(1,"Client", 5);
        adPlatform.registerAffiliate(aff);
        assertEquals(aff,adPlatform.getAffiliate(1));
    }

    @Test//checking that the affiliate returned does not exist in the collection - Test Double
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

    @Test//checking that the balance was unsuccessfully updated in the object - Test Double
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

    @Test//Checking affiliate is still bronze at 49.50 (bounds) - Test Double
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

    @Test//Checking affiliate is still bronze at 499.50 (bounds) - Test Double
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

    @Test//Setting Balance when affiliate has more than 5 credit, resulting true - Test Double
    public void affiliateSetBalanceBronze() throws Exception {
        Affiliate aff = new Affiliate(1, "Client", 5);
        adPlatform.registerAffiliate(aff);
        for (int i = 0; i <= 9; i++) {//aff should have 5
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        aff.isBronze();//should simply return true (to increase code coverage)
        //affiliate should get an updated balance, to 0
        assertEquals(true, adPlatform.settleAffiliateBalance(aff));
    }

    @Test//Setting Balance when affiliate has more than 50 credit, resulting true - Test Double
    public void affiliateSetBalanceSilver() throws Exception {
        Affiliate aff = new Affiliate(1, "Client", 5);
        adPlatform.registerAffiliate(aff);
        for (int i = 0; i <= 99; i++) {//aff should have 50
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        aff.isSilver();//should simply return true (to increase code coverage)
        //affiliate should get an updated balance, to 0
        assertEquals(true, adPlatform.settleAffiliateBalance(aff));
    }

    @Test//Setting Balance when affiliate has more than 500 credit, resulting true - Test Double
    public void affiliateSetBalanceGold() throws Exception {
        Affiliate aff = new Affiliate(1, "Client", 5);
        adPlatform.registerAffiliate(aff);
        for (int i = 0; i <= 999; i++) {//aff should have 500
            adPlatform.adClicked(1); //adding 50c to affiliate credit
        }
        aff.isGold();//should simply return true (to increase code coverage)
        //affiliate should get an updated balance, to 0
        assertEquals(true, adPlatform.settleAffiliateBalance(aff));
    }

    //going to test serveAdvert
    //going to use mock tests??
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

    @Test//testing serveAdvert - Test Double
    public void addProviderToListTrue() throws Exception {
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        AdFormat format = null;
        AdDescription desc = new AdDescription(format, keys);

        AdProvider adprov = mock(AdProvider.class);
        when(adprov.serveAdvert(desc)).thenReturn(new Advert(1));
        assertEquals(true, adPlatform.addProviderToList(adprov));
    }

    @Test//testing addProvider to List
    public void addProviderToListFalse() throws Exception {
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        AdFormat format = null;
        AdDescription desc = new AdDescription(format, keys);

        AdProvider adprov = mock(AdProvider.class);
        when(adprov.serveAdvert(desc)).thenReturn(new Advert(1));
        adPlatform.addProviderToList(adprov);//adding same item twice, resulting in false
        assertEquals(false, adPlatform.addProviderToList(adprov));
    }

    @Test//testing serveAdvert when there is no adverts/providers found
    public void affiliateServeAdvertFalse() throws Exception {
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        AdFormat format = null;
        AdDescription desc = new AdDescription(format, keys);
        assertEquals(false, adPlatform.serveAdvert(desc));
    }

    /*
    * Tests below created to reach highest code coverage possible
    */
    @Test //to test get, set name of an affiliate
    public void affiliateName() throws Exception{
        String name = "Client";
        Affiliate affiliate = new Affiliate(5);
        affiliate.setName(name);
        affiliate.setId(3);
        affiliate.setPassword("pass3");
        assertEquals(true, affiliate.getName().equals(name));
    }

    @Test //to test get the details of an advert
    public void advertUrl() throws Exception{
        Advert ad = new Advert(1);
        assertEquals(true, ad.getMediaURL().equals(""));
    }

    @Test //to test get the details of an advert
    public void advertFormat() throws Exception{
        Advert ad = new Advert(1);
        assertEquals(true, ad.getFormat()==null);
    }

    //adFormat tests
    @Test //to test get the details of an advert
    public void adFormatDim() throws Exception{
        MediaType mediaType = MediaType.IMAGE;
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        Dimension dim = new Dimension(3.5,3.5);//included to increase code coverage
        MediaType med = MediaType.IMAGE;//included to increase code coverage
        Keywords newKeys = new Keywords(keys.getList());//included to increase code coverage
        AdFormat adFormat = new AdFormat(mediaType,dim, keys);
        adFormat.setDimensions(dim);
        assertEquals(true, adFormat.getDimensions().equals(dim));
    }

    @Test //to test get the details of an advert
    public void adFormatKeys() throws Exception{
        MediaType mediaType = MediaType.IMAGE;
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        Dimension dim = new Dimension(3.5,3.5);//included to increase code coverage
        MediaType med = MediaType.IMAGE;//included to increase code coverage
        AdFormat adFormat = new AdFormat(mediaType,dim, keys);

        adFormat.setKeywords(keys);
        assertEquals(true, adFormat.getKeywords().equals(keys));
    }

    @Test //to test get the details of an advert
    public void adFormatMedia() throws Exception {
        MediaType mediaType = MediaType.IMAGE;
        Keywords keys = new Keywords();
        keys.addKeys("BLACK");
        Dimension dim = new Dimension(3.5,3.5);//included to increase code coverage
        MediaType med = MediaType.IMAGE;//included to increase code coverage
        AdFormat adFormat = new AdFormat(mediaType,dim, keys);
        adFormat.setMediaType(mediaType);
        assertEquals(true, adFormat.getMediaType().equals(mediaType));
    }

}