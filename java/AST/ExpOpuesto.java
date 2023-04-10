package AST;

import Compiler.*;
import Errors.*;

public class ExpOpuesto implements Exp{
    public Exp e1;
    

    public ExpOpuesto(Exp e1){
        this.e1 = e1;
        
    }

    public Type computeType() {

        Type e1Type = e1.computeType();
        Type type;

        if (e1Type == Type.INT) 
            type = Type.INT;
        else if (e1Type == Type.REAL)
            type = Type.REAL;
        else
            throw new TypeDefExc("Opposite TYPE is not correct");
        
        return type;
    }
   
}