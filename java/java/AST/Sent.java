package AST;

public interface Sent{
   
    public void computeStType();

    void generateCode(StringBuilder w, String ident);

}