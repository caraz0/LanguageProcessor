package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class Int2Real implements Exp{
    private final Exp exp;

    public Int2Real(Exp exp){
        this.exp = exp;

    }
}
