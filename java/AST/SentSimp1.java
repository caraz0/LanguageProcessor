package AST;

public class SentSimp1 implements SentSimp{
    public Asign Asign1;
   

    public SentSimp1(Asign Asign1){
        this.Asign1 = Asign1;
        
    }

    public void computeStType() {
        Asign1.computeStType();
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        Asign1.generateCode(buffer, prefix);
    }
}