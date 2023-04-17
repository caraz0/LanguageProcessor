package AST;

public class SentSimp2 implements SentSimp{
    public Cond Cond1;
   

    public SentSimp2(Cond Cond1){
        this.Cond1 = Cond1;
        
    }

    public void computeStType() {
        Cond1.computeStType();
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        Cond1.generateCode(buffer, prefix);
    }
}