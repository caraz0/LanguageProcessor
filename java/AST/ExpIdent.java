package AST;

import Compiler.*;


public class ExpIdent implements Exp{
    public String i1;
    

    public ExpIdent(String i1){
        this.i1 = i1;
        
    }

    public Type computeType() {
        return SymbolTable.getType(i1);
    }
   
    public void generateCode(StringBuilder buffer, String prefix) {
        buffer.append(prefix + i1);
    }
}