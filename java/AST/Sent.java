package AST;

public interface Sent{
   
    public void computeStType();

    void generateCode(StringBuilder buffer, String prefix);

}