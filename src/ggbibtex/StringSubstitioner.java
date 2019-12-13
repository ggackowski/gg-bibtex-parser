package ggbibtex;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSubstitioner implements IStringSubstitioner {
    public String substitute(String input) {
        HashMap<String, String> subs = new HashMap<>();
        Pattern p = Pattern.compile("@string *\\{ *([a-zA-Z]*) *= *\"([^\"]*)\" *}");
        Matcher m = p.matcher(input);
        while (m.find()) {
            String varName = m.group(1);
            String varValue = m.group(2);
            subs.put(varName, varValue);
        }
        String res = "";
        for (String s : subs.keySet()) {
            res = input.replaceAll(s, subs.get(s));
        }
        return res;
    }
}