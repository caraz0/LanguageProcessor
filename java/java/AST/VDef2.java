package AST;

public class VDef2 implements VDef{
    public Decl Decl1;
    public VDef VDef1;

    public VDef2(Decl Decl1, VDef VDef1){
        this.Decl1 = Decl1;
        this.VDef1 = VDef1;
    }

    public void computeAH1() {
        Decl1.computeAH1();
        VDef1.computeAH1();
    }

    public void generateCode(StringBuilder w, String ident) {
        Decl1.generateCode(w, ident);
        VDef1.generateCode(w, ident);
    }
}