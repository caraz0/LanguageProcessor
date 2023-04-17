package AST;

public interface Cond{
    void computeStType();
    public void generateCode(StringBuilder buffer, String prefix);
}