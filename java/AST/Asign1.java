package AST;

import Compiler.*;
import Errors.*;

public class Asign1 implements Asign{
    public String i1;
    public Exp Exp1;
   

    public Asign1(String i1, Exp Exp1){
        this.i1 = i1;
        this.Exp1 = Exp1;
        
    }

    public void computeStType() {
        Type ident = SymbolTable.getType(i1);
        Type expType = Exp1.computeType();
        if (ident != expType)
            throw new TypeDefExc("Cannot assign " + expType + " to variable " + i1 + " of type " + ident);
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + i1 + " = " );
        Exp1.generateCode(buffer, "");
        buffer.append(";\n");
    }
}