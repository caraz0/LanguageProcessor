package AST;

public interface Plot{
   
    void computeStType();
    void generateCode(StringBuilder w, String ident);
}