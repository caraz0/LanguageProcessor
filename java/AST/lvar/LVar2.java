package AST.lvar;

import AST.LVar;
import java.io.*;
import Errors.*;

public class LVar2 implements LVar{
    public String i1;
    public LVar LVar1;
    

    public LVar2(String i1, LVar LVar1){
        this.i1 = i1;
        this.LVar1 = LVar1;
    }


}