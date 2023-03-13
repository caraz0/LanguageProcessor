package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;
public class E_ConstanteBooleana implements Exp{
    public boolean n;
    

    public E_ConstanteBooleana(boolean n){
        this.n = n;
        
    }

}
