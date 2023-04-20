package AST;

public class VDef1 implements VDef{
    public Decl Decl1;
    

    public VDef1(Decl Decl1){
        this.Decl1 = Decl1;
        
    }

    public void computeAH1() {
        Decl1.computeAH1();
    }

    public void generateCode(StringBuilder w, String ident) {
        Decl1.generateCode(w, ident);
    }
}