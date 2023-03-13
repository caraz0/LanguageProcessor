package AST.cond;

import AST.Cond;
import AST.Exp;
import AST.Sent;
import java.io.*;
import Errors.*;

public class Cond2 implements Cond{
    public Exp Exp1;
    public Sent Sent1;
    public Sent Sent2;

    public Cond2(Exp Exp1, Sent Sent1, Sent Sent2){
        this.Exp1 = Exp1;
        this.Sent1 = Sent1;
        this.Sent2= Sent2;
        
    }


}