package AST;

public interface Asign{
    void computeStType();
    void generateCode(StringBuilder buffer, String prefix);
}