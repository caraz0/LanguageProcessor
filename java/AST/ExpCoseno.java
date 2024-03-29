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

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "Math.cos(");
        exp.generateCode(buffer, prefix);
        buffer.append(")");
    }
}
