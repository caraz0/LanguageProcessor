package AST;

public class Vars1 implements Vars{
    public VDef VDef1;
    

    public Vars1(VDef VDef1){
        this.VDef1 = VDef1;
        
    }

    public void computeAH1(){
        VDef1.computeAH1();
    }

    public void generateCode(StringBuilder buffer, String prefix){
        VDef1.generateCode(buffer, prefix);
    }
}