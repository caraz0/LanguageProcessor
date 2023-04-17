package Compiler;

import java.util.Vector;
import Errors.*;

public class SymbolTable {
    
    private static Vector<TableEntry> table = new Vector<TableEntry>();

    public static void newEntry(String name, Type type) {
        TableEntry e = search(name);
        if (e == null) {
            e = new TableEntry(name, type);
            table.add(e);
        }
        else{
            throw new DoubleDefExc("Variable " + name + " already exists");
        }
    }

    public static Type getType(String name) {
        TableEntry e = search(name);
        
        if (e == null)
            throw new VarNoDefExc("Variable " + name + " does not exist");
        
        return e.getType();
    }
    private static TableEntry search(String name) {
        TableEntry e = null;
        int i = 0;
        while(i<table.size()) {
            e = table.get(i);
            if (e.getName().equals(name)){
                break;
            }else{
                e = null;
                i++;
            }
        }
        return e;
    }
    

}
