package AST;

public class Prog1 implements Prog{
    public String i1;
    public Inp Inp1;
    public Vars Vars1;
    public Size Size1;
    public Sent Sent1;

    public Prog1(String i1, Inp Inp1, Vars Vars1, Size Size1, Sent Sent1){
        this.i1 = i1;
        this.Inp1 = Inp1;
        this.Vars1 = Vars1;
        this.Size1 = Size1;
        this.Sent1 = Sent1;

        computeAH1();
    }

    public void computeAH1() {
        Inp1.computeAH1();
        Vars1.computeAH1();
        Size1.computeStType();;
        Sent1.computeStType();;
    }

}