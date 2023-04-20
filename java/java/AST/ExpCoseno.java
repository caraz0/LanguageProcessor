package AST;

import Compiler.*;
import Errors.*;

public class ExpCoseno implements Exp{
    private final Exp exp;

    public ExpCoseno(Exp exp){
        this.exp = exp;

    }

    public Type computeType() {
        if (exp.computeType() != Type.REAL) 
            throw new TypeDefExc("Coseno Exp: Type must be Real");

        return Type.REAL;
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "Math.cos(");
        exp.generateCode(w, ident);
        w.append(")");
    }
}
