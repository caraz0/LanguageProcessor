package AST;

import Compiler.*;
import Errors.*;

public class ExpReal2Int implements Exp{
    private final Exp exp;

    public ExpReal2Int(Exp exp){
        this.exp = exp;

    }

    public Type computeType() {
        if (exp.computeType() != Type.REAL) 
            throw new TypeDefExc("Real2Int Exp: Type is not correct");

        return Type.INT;
    }
}
