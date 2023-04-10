package AST;

import Compiler.*;


public class ExpPi implements Exp{
    
    public ExpPi(){
        
    }
    public Type computeType() {
        return Type.REAL;
    }
}
