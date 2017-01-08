package cps.uom.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Keywords class
 */
public class Keywords {
    List<String> keys = new ArrayList<String>();

    public Keywords() {
    }

    public Keywords(List<String> keys) {
        this.keys = keys;
    }

    public void addKeys(String s){
        keys.add(s);
    }

    public List getList() {
        return keys;
    }
}
