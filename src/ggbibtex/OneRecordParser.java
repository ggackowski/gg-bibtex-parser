package ggbibtex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OneRecordParser implements IOneRecordParser {
    public Record parse(String input) {
        try {
            StringBuilder recordName = new StringBuilder(input);
            String letter = Character.toString(Character.toUpperCase(recordName.charAt(1)));
            recordName.replace(1, 2, letter);
            String name = recordName.toString().substring(1).split(" |\\{")[0];
            if (RecordType.valueOf(name) == null) {
                throw new RuntimeException("Wrong record type", null);
            }
            else {
                System.out.println("mamy tu: " + RecordType.valueOf(name));
                int keyBegin = input.indexOf("{");
                int keyEnd = input.indexOf(",");
                String key = input.substring(keyBegin + 1, keyEnd);
                System.out.println(key);
                Record record = Bibtex.createRecord(name);
                record.setKey(key);


                Pattern p1 = Pattern.compile(".*\\{ *(.*) *\\}");
                System.out.println("wyszlo:" + input + ",- inpiut");
                Matcher m1 = p1.matcher(input);


                while (m1.find()) {
                    System.out.println(m1.group(1));
                    String[] inputLines = m1.group(1).split(",");
                    for (String inp : inputLines) {
                        Pattern p = Pattern.compile("([A-Za-z_]\\w*) *= *(\".*\")");
                        Matcher m = p.matcher(inp);
                        String fname = m.group(1);
                        String fvalue = m.group(2);
                        System.out.println(fname + " " + fvalue);
                        int pos = 0;
                        boolean quoteOpened = false;
                        StringBuilder field = new StringBuilder();
                        while (pos != fvalue.length() - 1) {
                            if (fvalue.charAt(pos) == '\"') {
                                if (quoteOpened == false) quoteOpened = true;
                                else quoteOpened = false;
                            } else {
                                if (quoteOpened) field.append(fvalue.charAt(pos));
                            }
                            ++pos;
                        }
                        System.out.println(m.group());
                        System.out.println("field name: " + fname);
                        System.out.println("field value: " + fvalue);
                        System.out.println(field.toString());
                        String ffvalue = field.toString();

                        if (fname.equals("author") && !ffvalue.contains(",")) {
                            String[] names = ffvalue.split(" and ");
                            String author = "";
                            for (String n : names) {
                                String sn = n.substring(n.lastIndexOf(' ') + 1);
                                String nm = n.substring(0, n.lastIndexOf(' '));
                                author += sn + ", " + nm + " and ";
                            }
                            if (record.hasNecessary(fname))
                                record.fillNecessary(fname, author);
                            else if (record.hasOptional(fname))
                                record.fillOptional(fname, author);
                        } else {
                            if (record.hasNecessary(fname))
                                record.fillNecessary(fname, ffvalue);
                            else if (record.hasOptional(fname))
                                record.fillOptional(fname, ffvalue);
                        }
                    }

                }
                return record;
            }
        } catch (RuntimeException e) {
            System.out.println("sdfdsf");
            System.out.println(e.getMessage() + " in " + input);
        }
       return null;
    }
}
