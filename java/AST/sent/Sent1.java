package AST.sent;

import AST.SentSimp;
import AST.Sent;
import java.io.*;
import Errors.*;

public class Sent1 implements Sent{
    public SentSimp SentSimp1;
    public Sent Sent1;

    public Sent1(SentSimp SentSimp1, Sent Sent1){
        this.SentSimp1 = SentSimp1;
        this.Sent1 = Sent1;
        
    }


}