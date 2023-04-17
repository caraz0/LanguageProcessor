package AST;

import Compiler.*;
import Errors.*;

public class Plot1 implements Plot{
    
    public Exp Exp1;
    public Exp Exp2;
    public int color;

    public Plot1(Exp Exp1, Exp Exp2, int color){
        
        this.Exp1 = Exp1;
        this.Exp2 = Exp2;
        this.color = color;
    }

    public void computeStType() {
        Type exp1Type = Exp1.computeType();
        Type exp2Type = Exp2.computeType();
        if ((exp1Type != Type.INT) || (exp2Type != Type.INT))
            throw new TypeDefExc("Expresions in plot must be of type int");
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        // imagen[i + 5][5] = 2;
        // imagen[i + 5][ancho + 4] = 2;

        buffer.append(prefix + "imagen[");
        Exp2.generateCode(buffer, "");
        buffer.append("][");
        Exp1.generateCode(buffer, "");
        buffer.append("] = " + color +";\n");
        
    }
}