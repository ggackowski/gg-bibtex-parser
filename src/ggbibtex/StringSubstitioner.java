package ggbibtex;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSubstitioner implements IStringSubstitioner {
    public String substitute(String input) {
        //System.out.println(input);
        HashMap<String, String> subs = new HashMap<>();//[Ss][Tt][Rr][Ii][Nn][Gg]
        Pattern p = Pattern.compile("@string *\\{ *([a-zA-Z0-9_\\-]*) *= *\"([^\"]*)\" *} *", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        while (m.find()) {
            //System.out.println(m.group(2));
            String varName = m.group(1);
            String varValue = m.group(2);
            subs.put(varName, "\"" + varValue + "\"");
        }
        String res = "";
        for (String s : subs.keySet()) {
            res = input.replaceAll(s, subs.get(s));
        }
        if (res.equals("")) res = input;
        //System.out.println(res);
        return res;
    }
}
