package AST;

import Compiler.*;
import Errors.*;

public class Plot1 implements Plot{
    
    public Exp Exp1;
    public Exp Exp2;
   

    public Plot1(Exp Exp1, Exp Exp2){
        
        this.Exp1 = Exp1;
        this.Exp2 = Exp2;
        
    }

    public void computeStType() {
        Type exp1Type = Exp1.computeType();
        Type exp2Type = Exp2.computeType();
        if ((exp1Type != Type.INT) || (exp2Type != Type.INT))
            throw new TypeDefExc("Expresions in plot must be of type int");
    }

}