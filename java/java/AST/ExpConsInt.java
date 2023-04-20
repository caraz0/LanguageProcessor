package AST;

import Compiler.*;


public class ExpConsInt implements Exp{
    public int n;
    

    public ExpConsInt(int n){
        this.n = n;
        
    }

    public Type computeType() {
        return Type.INT;
    }
   
    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + n);
    }
}