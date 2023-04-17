package AST;

import Compiler.*;


public class ExpPi implements Exp{
    
    public ExpPi(){
        
    }
    public Type computeType() {
        return Type.REAL;
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "Math.PI");
    }
}
