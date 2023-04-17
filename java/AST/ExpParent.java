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
   
    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + "(");
        e1.generateCode(buffer, "");
        buffer.append(")");
    }
}