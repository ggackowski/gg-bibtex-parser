package ggbibtex;

public interface IFactory {

    default Record produceRecord() {
        String Cl = this.getClass().toString();
        String ClName = Record.mkstr(this.getClass().toString().substring(15, Cl.length() - 7));
        Record r = new Record(RecordType.valueOf(ClName), "default");
        String[] necs = getNecessary();
        String[] ops = getOptional();
        for (String nec : necs)
            r.addNecessary(nec);
        for (String op : ops)
            r.addOptional(op);
        return r;
    }

    String[] getNecessary();
    String[] getOptional();

}
