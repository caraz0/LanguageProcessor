package AST.cond;

import AST.Cond;
import AST.Exp;
import AST.Sent;
import java.io.*;
import Errors.*;

public class Cond1 implements Cond{
    public Exp Exp1;
    public Sent Sent1;

    public Cond1(Exp Exp1, Sent Sent1){
        this.Exp1 = Exp1;
        this.Sent1 = Sent1;
        
    }


}