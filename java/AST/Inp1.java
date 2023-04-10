package AST;

import Compiler.*;

public class Inp1 implements Inp{
    public LVar LVar1;

    public Inp1(LVar LVar1){
        this.LVar1 = LVar1;
    }

    public void computeAH1(){
        LVar1.computeAH1(Type.INT);
    }
}