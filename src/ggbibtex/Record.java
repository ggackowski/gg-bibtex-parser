package ggbibtex;

public class Record {
    private int a;
    private RecordType type;
    public Record(RecordType t) {
       a = 5;
       type = t;
    }

    public int getA() {
        return a;
    }

    public RecordType getType() {
        return type;
    }
}
