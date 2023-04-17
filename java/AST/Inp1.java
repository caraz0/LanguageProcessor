package AST;

import java.util.List;

import Compiler.*;

public class Inp1 implements Inp{
    public LVar LVar1;

    public Inp1(LVar LVar1){
        this.LVar1 = LVar1;
    }

    public void computeAH1(){
        LVar1.computeAH1(Type.INT);
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        
        
        List<String> names = LVar1.getNames();
        for (int i = 0; i< names.size(); i++) {
            buffer.append(prefix + "int " + names.get(i) + " = Integer.parseInt(args[" + i + "]);\n");
        }
    }
    
}