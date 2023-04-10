package AST;

import Compiler.*;
import Errors.*;

public class Cond1 implements Cond{
    public Exp Exp1;
    public Sent Sent1;

    public Cond1(Exp Exp1, Sent Sent1){
        this.Exp1 = Exp1;
        this.Sent1 = Sent1;
        
    }

    public void computeStType() {
        Type type = Exp1.computeType();
        if (type != Type.BOOL)
            throw new TypeDefExc("Cond Expression must be of type bool");
        Sent1.computeStType();
    }
}