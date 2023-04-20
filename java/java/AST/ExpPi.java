package AST;

import Compiler.*;


public class ExpPi implements Exp{
    
    public ExpPi(){
        
    }
    public Type computeType() {
        return Type.REAL;
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "Math.PI");
    }
}
