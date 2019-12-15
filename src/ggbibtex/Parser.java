package ggbibtex;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements  IParser {
    public HashMap<String, Record> parse(String inpt) {
        HashMap<String, Record> records = new HashMap<>();
        IOneRecordParser parseOneRecord = new OneRecordParser();
        IStringSubstitioner substitioner = new StringSubstitioner();
        String input = substitioner.substitute(inpt);
        Pattern p = Pattern.compile("@\\w+ *\\{.*?\\}");
        Matcher m = p.matcher(input);
        while (m.find()) {
            String s = m.group();
            Record parsed = parseOneRecord.parse(s);
            if (parsed != null)
                records.put(parsed.getKey(), parsed);
        }
        return records;
    }
}
