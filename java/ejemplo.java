import java.util.Arrays;
import GeneratedCodeLib.BMP_Gen;

public class ejemplo {
    public static void main(String[] args) {
        int i = 0;
        int alto = 20;
        int ancho = 10;
        int imagen[][] = new int[alto + 10][ancho + 10];
        int pixel[] = new int[(alto + 10) * (ancho + 10)];
        while (i < alto) {
            imagen[i + 5][5] = 2;
            imagen[i + 5][ancho + 4] = 2;
            i++;
        }

        i = 0;
        while (i < ancho) {
            imagen[5][i + 5] = 2;
            imagen[alto + 4][i + 5] = 2;
            i++;
        }

        for (int x = 0; x < imagen.length; x++) {
            System.arraycopy(imagen[x], 0, pixel, imagen[x].length * x, imagen[x].length);
        }   
        BMP_Gen.map2BMP(alto+10, ancho+10, pixel, "ejemplo.bmp");
    }
}
