package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class E_ConstanteEntera implements Exp{
    public int n;
    

    public E_ConstanteEntera(int n){
        this.n = n;
        
    }

   
}