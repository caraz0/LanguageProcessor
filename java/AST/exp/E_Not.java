package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class E_Not implements Exp{
    public Exp e1;
    

    public E_Not(Exp e1){
        this.e1 = e1;
        
    }

   
}