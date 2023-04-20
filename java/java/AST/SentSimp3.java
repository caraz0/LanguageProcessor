package AST;

public class SentSimp3 implements SentSimp{
    public Repet Repet1;
   

    public SentSimp3(Repet Repet1){
        this.Repet1 = Repet1;
        
    }

    public void computeStType() {
        Repet1.computeStType();
    }

    public void generateCode(StringBuilder w, String ident) {
        Repet1.generateCode(w, ident);
    }

}