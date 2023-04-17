package AST;

public interface Plot{
   
    void computeStType();
    void generateCode(StringBuilder buffer, String prefix);
}