package ggbibtex;

import java.util.HashMap;

public class FilteringRecordType implements IFiltering {
    public HashMap<String, Record> filter(HashMap<String, Record> records, String constr) {
        HashMap<String, Record> filtered = new HashMap<String, Record>();
        for (String s : records.keySet()) {
            RecordType type = RecordType.valueOf(constr);
            if (records.get(s).getType() == type)
                filtered.put(records.get(s).getKey(), records.get(s));
        }
        return filtered;
    }
}
