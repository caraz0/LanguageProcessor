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

    public void generateCode(StringBuilder w, String ident) {
        /* 
        if (i + 5 < 0) || (5<0)
            imagen[i + 5][5] = 2;
            imagen[i + 5][ancho + 4] = 2;*/
        w.append(ident + "if ((");
        Exp1.generateCode(w, "");
        w.append(" >= 0) && (");
        Exp2.generateCode(w, "");
        w.append(" >= 0)) ");
        w.append("imagen[");
        Exp1.generateCode(w, "");
        w.append("][");
        Exp2.generateCode(w, "");
        w.append("] = " + color +";\n");
        w.append(ident + "else {\n");
        w.append(ident + "\tSystem.out.println(\"Error: Las variables son menores que 0\");\n");
        w.append(ident + "\tSystem.exit(-1);\n");
        w.append(ident + "}\n");
        
    }
}