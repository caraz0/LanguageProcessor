package AST;

import Compiler.*;
import Errors.*;

public class ExpMayorQue implements Exp{
    public Exp e1;
    public Exp e2;

    public ExpMayorQue(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Type computeType() {
        if ((e1.computeType() == Type.INT && e2.computeType() == Type.INT) || (e1.computeType() == Type.REAL && e2.computeType() == Type.REAL))
            return Type.BOOL;
        else
            throw new TypeDefExc("MayorQue Exp: Type must be Int or Real");

    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "(");
        e1.generateCode(buffer, "");
        buffer.append(" > ");
        e2.generateCode(buffer, "");
        buffer.append(")");
    }
   
}