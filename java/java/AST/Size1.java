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

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "int imagen[][] = new int[");
        Exp2.generateCode(w, "");
        w.append("][ ");
        Exp1.generateCode(w, "");
        w.append("];\n");
        w.append(ident + "int pixel[] = new int[(");
        Exp2.generateCode(w, "");
        w.append(")*(");
        Exp1.generateCode(w, "");
        w.append(")];\n");
    }
}