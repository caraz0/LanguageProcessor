package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class E_Parentesis implements Exp{
    public Exp e1;
    

    public E_Parentesis(Exp e1){
        this.e1 = e1;
        
    }

   
}