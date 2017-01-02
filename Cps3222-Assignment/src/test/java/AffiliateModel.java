import cps.uom.edu.AdPlatform;
import cps.uom.edu.Affiliate;
import cps.uom.edu.AffiliateType;
import cucumber.api.java.en_old.Ac;
import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.examples.gsm.SimCard;
import org.junit.Assert;

import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.coverage.*;
import org.junit.Test;

import java.util.Random;

/**
 * Created by jonathan on 02/01/2017.
 */
public class AffiliateModel implements FsmModel{
    private AdPlatform plat = new AdPlatform();
    private Affiliate aff =  new Affiliate(1,"pass1","Client1");

    private AffiliateStates modelAffiliate = AffiliateStates.BRONZE;//start state
    private boolean bronze = false, silver = false, gold = false;
    public AffiliateStates getState (){ return modelAffiliate;  }

    public void reset(final boolean var1){
        if(var1){
            int newId = aff.getId()+1;
            aff = new Affiliate(newId,"pass1","Client1");
            plat.registerAffiliate(aff);
        }
        modelAffiliate = AffiliateStates.BRONZE;
    }

    public boolean onClick50Guard(){return getState().equals(AffiliateStates.BRONZE); }

    public @Action void onClick50(){
        System.out.println("Elise fag: "+aff.getBalance());
        bronze = true;
        modelAffiliate = AffiliateStates.ADBRONZE;
        Assert.assertEquals("The affiliate matches the correct type", bronze, aff.isBronze());
        plat.adClicked(aff.getId());
    }

    public boolean transition50Guard(){  return getState().equals(AffiliateStates.ADBRONZE);  }

    public @Action void transition50(){
        System.out.println("Affiliate Type: "+aff.getType());
        if(aff.getType()==(AffiliateType.BRONZE)){
            bronze = true;
            modelAffiliate = AffiliateStates.BRONZE;
            Assert.assertEquals("The affiliate matches the correct type", bronze, aff.isBronze());
        }else {
            silver = true;
            bronze = false;
            modelAffiliate = AffiliateStates.SILVER;
            Assert.assertEquals("The affiliate matches the correct type", silver, aff.isSilver());
        }
    }

    public boolean onClick500Guard(){return getState().equals(AffiliateStates.SILVER); }

    public @Action void onClick500(){
        bronze = false;
        silver = true;
        modelAffiliate = AffiliateStates.ADSILVER;
        Assert.assertEquals("The affiliate matches the correct type", silver, aff.isSilver());
        plat.adClicked(aff.getId());
    }

    public boolean transition500Guard(){  return getState().equals(AffiliateStates.ADSILVER);  }

    public @Action void transition500(){
        if(aff.getType().equals(AffiliateType.SILVER)){
            silver = true;
            modelAffiliate = AffiliateStates.SILVER;
            Assert.assertEquals("The affiliate matches the correct type", silver, aff.isSilver());
        }else {
            gold = true;
            silver = false;
            modelAffiliate = AffiliateStates.GOLD;
            Assert.assertEquals("The affiliate matches the correct type", gold, aff.isGold());
        }
    }

    public boolean onClickGreater500Guard(){return getState().equals(AffiliateStates.GOLD); }

    public @Action void onClickGreater500(){
        gold = true;
        modelAffiliate = AffiliateStates.ADGOLD;
        Assert.assertEquals("The affiliate matches the correct type", gold, aff.isGold());
        plat.adClicked(aff.getId());
    }




    //Test runner
    @Test
    public void main() {
        final GreedyTester tester = new GreedyTester(new AffiliateModel()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        Random rand = new Random(1000);
        tester.setRandom(rand);   //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transition
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }










}
