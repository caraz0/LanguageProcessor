package AST;

import Compiler.*;
import Errors.*;

public class ExpSeno implements Exp{
    private final Exp exp;

    public ExpSeno(Exp exp){
        this.exp = exp;

    }

    public Type computeType() {
        if (exp.computeType() != Type.REAL) 
            throw new TypeDefExc("Seno Exp: Type must be Real");

        return Type.REAL;
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "Math.sin(");
        exp.generateCode(buffer, prefix);
        buffer.append(")");
    }
}
