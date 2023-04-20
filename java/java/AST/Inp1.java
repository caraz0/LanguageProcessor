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

    public void generateCode(StringBuilder w, String ident) {
        
        
        List<String> names = LVar1.getNames();
        for (int i = 0; i< names.size(); i++) {
            w.append(ident + "int " + names.get(i) + " = Integer.parseInt(args[" + i + "]);\n");
            w.append(ident + "if (" + names.get(i) + " < 0) {\n");
            w.append(ident + "\tSystem.out.println(\"Error: Las variables son menores que 0\");\n");
            w.append(ident + "\tSystem.exit(-1);\n");
            w.append(ident + "}\n");
        }
    }
    
}