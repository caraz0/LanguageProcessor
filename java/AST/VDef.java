package AST;

public interface VDef{
   
    void computeAH1();
    void generateCode(StringBuilder buffer, String prefix);
}