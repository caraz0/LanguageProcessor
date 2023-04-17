package AST;

import Compiler.*;
import Errors.*;

public class Repet1 implements Repet{
    public Exp Exp1;
    public Sent Sent1;

    public Repet1(Exp Exp1, Sent Sent1){
        this.Exp1 = Exp1;
        this.Sent1 = Sent1;
        
    }

    public void computeStType() {

        Type Exp1Type = Exp1.computeType();
        if ((Exp1Type) != Type.BOOL) 
            throw new TypeDefExc("Repet Expression must be of type bool");

        Sent1.computeStType();
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append("\n");

        buffer.append(prefix + "while");
        Exp1.generateCode(buffer, "");
        buffer.append(" {\n");
        Sent1.generateCode(buffer, prefix.concat("\t"));
        buffer.append(prefix + "}\n");
        
        buffer.append("\n");
    }

}