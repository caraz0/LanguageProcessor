package Compiler;

public class TableEntry {
    private String name;
    private Type type;

    public TableEntry(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
