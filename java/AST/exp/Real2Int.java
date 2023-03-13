package AST.exp;

import AST.Exp;
import java.io.*;
import Errors.*;

public class Real2Int implements Exp{
    private final Exp exp;

    public Real2Int(Exp exp){
        this.exp = exp;

    }
}
