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

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "if (");
        Exp1.generateCode(buffer, "");
        buffer.append(") {\n");
        Sent1.generateCode(buffer, prefix.concat("\t"));
        buffer.append(prefix + "}\n");
    }
}