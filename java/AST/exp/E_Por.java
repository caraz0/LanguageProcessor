package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class E_Por implements Exp{
    public Exp e1;
    public Exp e2;

    public E_Por(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

   
}