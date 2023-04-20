package AST;

import Compiler.*;
;
public interface Exp{
    Type computeType();
    void generateCode(StringBuilder w, String ident);
}
