package AST;

public interface Size{
   
    void computeStType();
    void generateCode(StringBuilder buffer, String prefix);
}