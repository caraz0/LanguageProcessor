package AST;

import Compiler.*;
import Errors.*;

public class ExpOr implements Exp{
    public Exp e1;
    public Exp e2;

    public ExpOr(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Type computeType() {
        if (!(e1.computeType() == Type.BOOL && e2.computeType() == Type.BOOL)) 
            throw new TypeDefExc("Expresions in OR must be of type BOOL");

        return Type.BOOL;
    }
   
    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "(");
        e1.generateCode(w, "");
        w.append(" || ");
        e2.generateCode(w, "");
        w.append(")");
    }
}