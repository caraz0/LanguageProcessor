package AST;


public class Sent2 implements Sent{
    public SentSimp SentSimp1;
    

    public Sent2(SentSimp SentSimp1){
        this.SentSimp1 = SentSimp1;
       
        
    }

    public void computeStType() {
        SentSimp1.computeStType();
    }

    public void generateCode(StringBuilder w, String ident) {
        SentSimp1.generateCode(w, ident);
    }
}