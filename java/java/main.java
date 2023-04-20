import Parser.*;
import Lexer.*;
import java.io.*;

import AST.Prog;

public class Main {
  public static void main(String args[]) throws Exception {
    java.io.BufferedReader in;
    Yylex sc;
    parser p;
    java_cup.runtime.Symbol sroot;
    boolean error = false;

    // El primer parametro es el nombre del fichero con el programa
    if (args.length < 1) {
      System.out.println(
          "Uso: java Main <nombre_fichero>");
      error = true;
    }

    // Análisis léxico y sintáctico

    if (!error) {
      try {
        in = new java.io.BufferedReader(new java.io.FileReader(args[0]));
        sc = new Yylex(in);
        p = new parser(sc);
        sroot = p.parse();
        System.out.println("Analisis lexico, sintactico y semántico correctos");

        generateCode(args[1], (Prog) sroot.value);
      } catch (IOException e) {
        System.out.println("Error abriendo fichero: " + args[0]);
        error = true;
      }
    }
  }

  private static void generateCode(String fileName, Prog prog) {
    File file = new File(fileName);

    StringBuilder w = new StringBuilder(30);

    w.append("import java.util.*;\n");
    w.append("import GeneratedCodeLib.*;\n");
    w.append("import java.util.Arrays;\n");
    w.append("\n");
    w.append("public class " + fileName + " {\n\n");
    prog.generateCode(w, "\t");
  

  //   for (int fila = 0; fila < filas; fila++) {
  //     for (int columna = 0; columna < columnas; columna++) {
  //         matrizGirada[columna][filas - 1 - fila] = matrizOriginal[fila][columna];
  //     }
  // }
  
    w.append("\timagen = transposeMatrix(imagen);\n");
    w.append("\tint indice = 0;\n");
    w.append("\tfor (int fila = imagen.length - 1; fila >= 0; fila--) {\n");
    w.append("\t\tint posicionInicial = fila * 20;\n");
    w.append("\t\tfor (int columna = 0; columna < imagen[fila].length; columna++) {\n");
    w.append("\t\tpixel[indice] = imagen[fila][columna];\n");
    w.append("\t\tindice++;\n");
    w.append("\t\t}\n");
    w.append("\t}\n");
    // w.append("\tfor (int x = 0; x < imagen.length; x++) {\n");
    // w.append("\t\tSystem.arraycopy(imagen[x], 0, pixel, imagen[x].length * x, imagen[x].length);\n");
    // w.append("\t}\n");
    
    w.append("\tBMP_Gen.map2BMP(imagen.length, imagen[0].length, pixel, args[args.length - 1]);\n");
    w.append("\t}\n");

    
    w.append("public static int[][] transposeMatrix(int[][] matrix){\n");
    w.append("\tint m = matrix.length;\n");
    w.append("\tint n = matrix[0].length;\n");
    w.append("\tint[][] transposedMatrix = new int[n][m];\n");
    w.append("\tfor(int x = 0; x < n; x++) {\n");
    w.append("\t\tfor(int y = 0; y < m; y++) {\n");
    w.append("\t\t\ttransposedMatrix[x][y] = matrix[y][x];\n");
    w.append("\t\t}\n");
    w.append("\t}\n");
    w.append("\treturn transposedMatrix;\n");
    w.append("\t}\n");
    w.append("}\n");

    try (Writer fileWriter = new FileWriter(file + ".java")) {
      fileWriter.write(w.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
