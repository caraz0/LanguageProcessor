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

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + n);
    }
}