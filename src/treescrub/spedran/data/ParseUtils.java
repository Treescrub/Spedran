package treescrub.spedran.data;

import kong.unirest.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {
    public static List<String> getStringList(JSONArray array) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < array.length(); i++) {
            list.add(array.getString(i));
        }

        return list;
    }
}
