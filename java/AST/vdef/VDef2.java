package AST.vdef;

import AST.VDef;
import AST.Decl;
import java.io.*;
import Errors.*;

public class VDef2 implements VDef{
    public Decl Decl1;
    public VDef VDef1;
    
    

    public VDef2(Decl Decl1, VDef VDef1){
        this.Decl1 = Decl1;
        this.VDef1 = VDef1;
    }
}