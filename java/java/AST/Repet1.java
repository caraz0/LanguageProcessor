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

    public void generateCode(StringBuilder w, String ident) {
        w.append("\n");

        w.append(ident + "while");
        Exp1.generateCode(w, "");
        w.append(" {\n");
        Sent1.generateCode(w, ident.concat("\t"));
        w.append(ident + "}\n");
        
        w.append("\n");
    }

}