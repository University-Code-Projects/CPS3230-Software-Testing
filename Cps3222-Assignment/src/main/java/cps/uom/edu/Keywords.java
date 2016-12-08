package cps.uom.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 08/12/2016.
 */
public class Keywords {
    List<String> keys = new ArrayList<String>();

    public Keywords(List<String> keys) {
        this.keys = keys;
    }

    public Keywords() {

    }

    public void addKeys(String s){
        keys.add(s);
    }

    public List getList() {
        return keys;
    }
}
