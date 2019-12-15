package ggbibtex;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OneRecordParser implements IOneRecordParser {
    public Record parse(String input) {
        try {
            //System.out.println("w parserze 1 el:  " + input);
            StringBuilder recordName = new StringBuilder(input);
            String letter = Character.toString(Character.toUpperCase(recordName.charAt(1)));
            recordName.replace(1, 2, letter);
            String name = recordName.toString().substring(1).split(" |\\{")[0];
            if (!(name.equalsIgnoreCase("String") || name.equalsIgnoreCase("Preamble") || name.equalsIgnoreCase("Comment")) && RecordType.valueOf(Record.mkstr(name)) == null) {
                throw new RuntimeException("Wrong record type", null);
            }
            else if (!(name.equalsIgnoreCase("String") || name.equalsIgnoreCase("Preamble") || name.equalsIgnoreCase("Comment"))){
                int keyBegin = input.indexOf("{");
                while (input.charAt(keyBegin + 1) == ' ')
                    keyBegin++;
                int keyEnd = input.indexOf(",");
                String key = input.substring(keyBegin + 1, keyEnd);

                Record record = Bibtex.createRecord(Record.mkstr(name));
                record.setKey(key);
                Pattern p1 = Pattern.compile(".*\\{ *(.*) *\\}");
                Matcher m1 = p1.matcher(input);
                while (m1.find()) {
                    String inpt = m1.group(1);
                    List<String> lines = new LinkedList<>();
                    int indexBegin = 0;
                    int index = 0;
                    boolean isInQuotes = false;
                    while (index < inpt.length()) {
                        if (inpt.charAt(index) == '\"')
                            isInQuotes = !isInQuotes;
                        if ((inpt.charAt(index) == ',') && !isInQuotes) {
                            String line = inpt.substring(indexBegin, index);
                            lines.add(line);
                            indexBegin = index + 1;
                        }
                        index++;
                    }

                    if (indexBegin != index)
                        lines.add(inpt.substring(indexBegin, index - 1));
                    String[] Result = lines.toArray(new String[lines.size()]);
                    for (String inp : Result) {
                        Pattern p = Pattern.compile("([A-Za-z_]\\w*) *= *(\".*\"|[0-9]+)");
                        Matcher m = p.matcher(inp);
                        if (m.find()) {
                            String fname = m.group(1);
                            String fvalue = m.group(2);
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
                            String ffvalue = new String();

                            if (field.toString().equals(""))
                               ffvalue = m.group(2);
                            else ffvalue = field.toString();
                            if (fname.equalsIgnoreCase("author") || fname.equalsIgnoreCase("editor") && !ffvalue.contains(",")) {
                                String[] names = ffvalue.split(" and ");
                                String author = "";
                                for (String n : names) {
                                    if (n.lastIndexOf(' ') < 0) author += n;
                                    else {
                                        String sn = n.substring(n.lastIndexOf(' ') + 1);
                                        String nm = n.substring(0, n.lastIndexOf(' '));
                                        author += sn + ", " + nm + " and ";
                                    }
                                }
                                if (record.hasNecessary("Author"))
                                    record.fillNecessary("Author", author);
                                else if (record.hasOptional("Author"))
                                    record.fillOptional("Author", author);
                            } else {
                                if (record.hasNecessary(fname))
                                    record.fillNecessary(fname, ffvalue);
                                else if (record.hasOptional(fname))
                                    record.fillOptional(fname, ffvalue);
                            }
                        }
                    }

                }
                return record;
            }
        } catch (RuntimeException e) {
            System.out.println("Parsing error at " + input);
            System.out.println("Cause: " + e.getMessage());
        }
       return null;
    }
}
