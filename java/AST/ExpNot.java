package AST;

import Compiler.*;
import Errors.*;

public class ExpNot implements Exp{
    public Exp e1;
    

    public ExpNot(Exp e1){
        this.e1 = e1;
        
    }

    public Type computeType() {

        if (e1.computeType() != Type.BOOL)
            throw new TypeDefExc("Expresion in NOT type must be Bool");

        return Type.BOOL;
    }
    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "!(");
        e1.generateCode(buffer, "");
        buffer.append(")");
    }
   
}