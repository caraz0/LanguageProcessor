package Compiler;

public enum Color {
    WHITE (0),
    GREY  (1),
    BLACK (2),
    RED   (3),
    GREEN (4),
    BLUE  (5),
    YELLOW(6),
    ORANGE(7);
    
    private int i;

    private Color(int i) {

        this.i = i;
    }

    public int getKey() {
        return i;
    }
}
