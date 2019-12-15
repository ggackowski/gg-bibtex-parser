package ggbibtex;

import java.util.HashMap;

public class FilteringAuthor implements IFiltering {
    public HashMap<String, Record> filter(HashMap<String, Record> records, String constr) {
        if (constr.equals(""))
            return records;
        HashMap<String, Record> filtered = new HashMap<>();

        for (String s : records.keySet()) {
            String authors = "";
            if (records.get(s).hasNecessary("author"))
                authors = records.get(s).getNecessary("author");
            else if (records.get(s).hasOptional("author"))
                authors = records.get(s).getOptional("author");
            if (authors != "") {
                String[] authorsArray = authors.split(" and ");
                for (String auth : authorsArray) {
                    //System.out.println(auth);
                    int count = 0;
                    String[] namesSurname = auth.split(",");
                    String surname = namesSurname[0];
                    String[] names = namesSurname[1].split(" +");
                    String authorns[] = auth.split(" +");
                    for (String aut : authorns) {
                        for (String na : names) {
                            //System.out.println("porownanie " + aut + " z " + na);
                            if (aut.equals(na)) count++;
                        }
                    }
                    boolean good = false;
                    if (constr.substring(constr.lastIndexOf(' ') + 1, constr.length()).equals(surname))
                        good = true;
                    //System.out.println(surname);
                    //System.out.println(constr.substring(constr.lastIndexOf(' ') + 1, constr.length()));
                    if (good && count >= authorns.length - 1) filtered.put(s, records.get(s));
                }
            }
        }
        return filtered;
    }
}
