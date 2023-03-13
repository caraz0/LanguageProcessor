package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class E_ConstanteReal implements Exp{
    public double n;
    
    public E_ConstanteReal(double n){
        this.n = n;
        
    }
}