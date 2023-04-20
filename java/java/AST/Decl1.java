package AST;

import Compiler.*;

public class Decl1 implements Decl{
    private final Type type;
    private final LVar LVar1;

    public Decl1(Type type, LVar LVar1){
        this.type = type;
        this.LVar1 = LVar1;
    }

    public void computeAH1() {
        LVar1.computeAH1(type);
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + type + " ");
        LVar1.generateCode(w, ident);
        w.append(";\n");
    }
}