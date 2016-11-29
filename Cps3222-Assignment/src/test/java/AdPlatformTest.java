
import com.sun.xml.internal.bind.v2.TODO;
import cps.uom.edu.AdPlatform;
import cps.uom.edu.Affiliate;
import cps.uom.edu.AffiliateType;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

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

    //need to test that on creation of affiliation balance is 0

}