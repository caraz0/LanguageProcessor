package AST;

public class Sent1 implements Sent{
    public SentSimp SentSimp1;
    public Sent Sent1;

    public Sent1(SentSimp SentSimp1, Sent Sent1){
        this.SentSimp1 = SentSimp1;
        this.Sent1 = Sent1;
        
    }

    public void computeStType() {
        SentSimp1.computeStType();
        Sent1.computeStType();
    }

    public void generateCode(StringBuilder w, String ident) {
        SentSimp1.generateCode(w, ident);
        Sent1.generateCode(w, ident);
    }
}