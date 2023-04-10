package AST;

import Compiler.*;

public class LVar1 implements LVar{
    public String i1;
    

    public LVar1(String i1){
        this.i1 = i1;
        
    }

    public void computeAH1(Type type) {
        SymbolTable.newEntry(i1, type);
    }
}