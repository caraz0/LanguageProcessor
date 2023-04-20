package AST;

public interface Cond{
    void computeStType();
    public void generateCode(StringBuilder w, String ident);
}