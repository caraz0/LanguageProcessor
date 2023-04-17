package AST;

import Compiler.*;
import Errors.*;

public class Size1 implements Size{
    public Exp Exp1;
    public Exp Exp2;

    public Size1(Exp Exp1, Exp Exp2){
        this.Exp1 = Exp1;
        this.Exp2 = Exp2;
        
    }

    public void computeStType(){
        Type exp1Type = Exp1.computeType();
        Type exp2Type = Exp2.computeType();
        if ((exp1Type != Type.INT) && (exp2Type != Type.INT))
            throw new TypeDefExc("Expresions in size must be of type int");
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "int imagen[][] = new int[");
        Exp1.generateCode(buffer, "");
        buffer.append("][ ");
        Exp2.generateCode(buffer, "");
        buffer.append("];\n");
        buffer.append(prefix + "int pixel[] = new int[(");
        Exp1.generateCode(buffer, "");
        buffer.append(")*(");
        Exp2.generateCode(buffer, "");
        buffer.append(")];\n");
    }
}