package AST;

import Compiler.*;
import Errors.*;

public class ExpIgualQue implements Exp{
    public Exp e1;
    public Exp e2;

    public ExpIgualQue(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Type computeType() {
        Type type1 = e1.computeType();
        Type type2 = e2.computeType();
        if ( (type1 == type2) && (type1 == Type.INT || type2 == Type.BOOL)) 
            return Type.BOOL;
        else
            throw new TypeDefExc("Expresions in IGUALQUE must be the same type, and must be Int or Bool");
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "(");
        e1.generateCode(w, "");
        w.append(" == ");
        e2.generateCode(w, "");
        w.append(")");
    }
}