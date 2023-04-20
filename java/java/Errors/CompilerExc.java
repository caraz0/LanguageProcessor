package Errors;

public class CompilerExc extends RuntimeException { 

    public CompilerExc() {

    }

    public CompilerExc(String msg) {
        super(msg);
    }

}