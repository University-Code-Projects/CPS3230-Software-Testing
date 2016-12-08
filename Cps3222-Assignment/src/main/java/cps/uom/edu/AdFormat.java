package cps.uom.edu;


import java.awt.*;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdFormat {

    public MediaType mediaType;
    public Dimension dimensions;
    public Keywords keywords;

    /*
    public MediaType getMediaType() {
        return mediaType;
    }
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }


    public Dimension getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    */
    public AdFormat(MediaType mediaType, Dimension dimensions, Keywords keywords) {
        this.mediaType = mediaType;
        this.dimensions = dimensions;
        this.keywords = keywords;
    }
}
