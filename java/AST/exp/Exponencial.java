package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class Exponencial implements Exp{
    private final Exp exp;

    public Exponencial(Exp exp){
        this.exp = exp;

    }
}
