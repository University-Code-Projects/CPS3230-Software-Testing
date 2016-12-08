package cps.uom.edu;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdDescription {
    public AdFormat format;
    public Keywords keywords;


    /*
    public AdFormat getFormat() {
        return format;
    }


    public void setFormat(AdFormat format) {
        this.format = format;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    */
    public AdDescription(AdFormat format, Keywords keywords){
        this.format = format;
        this.keywords = keywords;
    }
}
