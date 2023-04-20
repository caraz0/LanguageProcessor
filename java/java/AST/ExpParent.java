package AST;

import Compiler.*;


public class ExpParent implements Exp{
    public Exp e1;
    

    public ExpParent(Exp e1){
        this.e1 = e1;
        
    }

    public Type computeType() {
        return e1.computeType();
    }
   
    public void generateCode(StringBuilder w, String ident) {
        w.append(ident + "(");
        e1.generateCode(w, "");
        w.append(")");
    }
}