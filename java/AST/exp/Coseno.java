package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class Coseno implements Exp{
    private final Exp exp;

    public Coseno(Exp exp){
        this.exp = exp;

    }
}
