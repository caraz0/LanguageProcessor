package AST;

import java.util.List;

import Compiler.*;

public class LVar1 implements LVar{
    public String i1;
    

    public LVar1(String i1){
        this.i1 = i1;
        
    }

    public void computeAH1(Type type) {
        SymbolTable.newEntry(i1, type);
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(i1 + firstValue(i1));
    }
    public List<String> getNames() {
        return List.of(i1);
    }
}