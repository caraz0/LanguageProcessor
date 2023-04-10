package AST;

import Compiler.*;
import Errors.*;

public class ExpAnd implements Exp{
    public Exp e1;
    public Exp e2;

    public ExpAnd(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Type computeType() {
        if (!(e1.computeType() == Type.BOOL && e2.computeType() == Type.BOOL)) 
            throw new TypeDefExc("Expresions in AND must be of type BOOL");

        return Type.BOOL;
    }
   
}