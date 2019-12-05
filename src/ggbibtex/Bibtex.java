package ggbibtex;



import  java.lang.*;



public class Bibtex {
    public static Record createRecord(String type) {
        Class c = null;
        Record record = null;
        try {
            c = Class.forName("ggbibtex." + type + "Factory");
            record = ((IFactory) c.getConstructor().newInstance()).produceRecord();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Invalid Record type");
        }
        catch (NoSuchMethodException e) {
            System.out.println("error no such method");
        }
        catch (ReflectiveOperationException e) {
            System.out.println("other error");
        }
        if (record == null) System.out.println("no pieknie");
        return record;
    }
}
