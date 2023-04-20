package AST;

import Compiler.*;


public class ExpConstBool implements Exp{
    public boolean n;
    

    public ExpConstBool(boolean n){
        this.n = n;
        
    }

    public Type computeType() {
        return Type.BOOL;
    }

    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + n);
    }
}
