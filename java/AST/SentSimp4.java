package AST;

public class SentSimp4 implements SentSimp{
    public Plot Plot1;
   

    public SentSimp4(Plot Plot1){
        this.Plot1 = Plot1;
        
    }

    public void computeStType() {
        Plot1.computeStType();
    }

    public void generateCode(StringBuilder buffer, String prefix) {
        Plot1.generateCode(buffer, prefix);
    }
}