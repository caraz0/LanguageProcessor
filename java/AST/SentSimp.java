package AST;

public interface SentSimp{
   
    public abstract void computeStType();
    public void generateCode(StringBuilder buffer, String prefix);
}