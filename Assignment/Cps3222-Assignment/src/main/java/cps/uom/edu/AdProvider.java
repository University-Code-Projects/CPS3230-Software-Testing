package cps.uom.edu;

/**
 * AdProvider Interface
 */
public interface AdProvider {
    public String name = "";

    public Advert serveAdvert(AdDescription adDescription);
}
