package AST;

import Compiler.*;
import Errors.*;

public class Cond2 implements Cond{
    public Exp Exp1;
    public Sent Sent1;
    public Sent Sent2;

    public Cond2(Exp Exp1, Sent Sent1, Sent Sent2){
        this.Exp1 = Exp1;
        this.Sent1 = Sent1;
        this.Sent2= Sent2;
    }

    public void computeStType() {
        Type type = Exp1.computeType();
        if (type != Type.BOOL)
            throw new TypeDefExc("Cond Expression must be of type bool");
        Sent1.computeStType();
        Sent2.computeStType();
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "if (");
        Exp1.generateCode(w, "");
        w.append(") {\n");
        Sent1.generateCode(w, ident.concat("\t"));
        w.append(ident + "} else {\n");
        Sent2.generateCode(w, ident.concat("\t"));
        w.append(ident + "}\n");
    }

}