package AST;

public interface Decl{
   
    void computeAH1();

    void generateCode(StringBuilder w, String ident);
}