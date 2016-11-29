package cps.uom.edu;

/**
 * Created by jonathan on 29/11/2016.
 */
public interface AdProvider {
    //should be private
    public String name = "";

    public Advert serveAdvert(AdDescription adDescription);


}
