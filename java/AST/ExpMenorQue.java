package AST;

import Compiler.*;
import Errors.*;

public class ExpMenorQue implements Exp{
    public Exp e1;
    public Exp e2;

    public ExpMenorQue(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Type computeType() {
        if ((e1.computeType() == Type.INT && e2.computeType() == Type.INT) || (e1.computeType() == Type.REAL && e2.computeType() == Type.REAL))
            return Type.BOOL;
        else
            throw new TypeDefExc("MenorQue Exp: Type must be Int or Real");

    }
   
}