package AST;

import Compiler.*;


public class ExpConstReal implements Exp{
    public Double n;
    
    public ExpConstReal(Double n){
        this.n = n;
        
    }

    public Type computeType() {
        return Type.REAL;
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + n);
    }
}