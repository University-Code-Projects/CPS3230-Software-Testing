import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.awt.*;

/**
 * Created by jonathan on 29/11/2016.
 */
public class AdFormat {
    private MediaType mediaType;
    private Dimension dimensions;
    private Keywords keywords;

    //getters
    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    //setters
    public void setDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }
}
