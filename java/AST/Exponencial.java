package AST;

import Compiler.*;
import Errors.*;

public class Exponencial implements Exp{
    private final Exp exp;

    public Exponencial(Exp exp){
        this.exp = exp;

    }

    public Type computeType() {
        if (exp.computeType() != Type.REAL) 
            throw new TypeDefExc("Exponencial Exp: Type must be Real");

        return Type.REAL;
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "Math.exp(");
        exp.generateCode(buffer, prefix);
        buffer.append(")");
    }
}
