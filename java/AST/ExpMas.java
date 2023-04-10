package AST;

import Compiler.*;
import Errors.*;

public class ExpMas implements Exp{
    public Exp e1;
    public Exp e2;

    public ExpMas(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Type computeType() {
        Type e1Type = e1.computeType();
        Type e2Type = e2.computeType();
        Type type;

        if ((e1Type == Type.INT) && (e2Type == Type.INT))
            type = Type.INT;
        else if ((e1Type == Type.REAL) && (e2Type == Type.REAL))
            type = Type.REAL;
        else 
            throw new TypeDefExc("TYPE in sum must be INT or REAL");
        
        return type;
    }
}