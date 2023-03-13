package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class Seno implements Exp{
    private final Exp exp;

    public Seno(Exp exp){
        this.exp = exp;

    }
}
