package AST;

import Compiler.*;
import Errors.*;

public class ExpInt2Real implements Exp{
    private final Exp exp;

    public ExpInt2Real(Exp exp){
        this.exp = exp;

    }

    public Type computeType() {
        if (exp.computeType() != Type.INT) 
            throw new TypeDefExc("Int2Real Exp: Type is not correct");

        return Type.REAL;
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "Double.valueOf(");
        exp.generateCode(w, ident);
        w.append(")");
    }
}
