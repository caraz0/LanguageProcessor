package AST;

import Compiler.*;

public class LVar2 implements LVar{
    public String i1;
    public LVar LVar1;
    

    public LVar2(String i1, LVar LVar1){
        this.i1 = i1;
        this.LVar1 = LVar1;
    }

    public void computeAH1(Type type) {
        SymbolTable.newEntry(i1, type);
        LVar1.computeAH1(type);
    }
}