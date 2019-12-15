package ggbibtex;

import java.util.HashMap;

public interface IParser {
    HashMap<String, Record> parse(String inpt);
}
