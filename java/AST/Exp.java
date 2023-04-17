package AST;

import Compiler.*;
;
public interface Exp{
    Type computeType();
    void generateCode(StringBuilder buffer, String prefix);
}
