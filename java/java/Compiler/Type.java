package Compiler;

public enum Type {
    BOOL("boolean"),
    INT("int"),
    REAL("double");

    private final String type;

    private Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}