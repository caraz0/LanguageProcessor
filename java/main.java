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

    StringBuilder buffer = new StringBuilder(30);

    buffer.append("import java.util.*;\n");
    buffer.append("import GeneratedCodeLib.*;\n");
    buffer.append("import java.util.Arrays;\n");
    buffer.append("\n");
    buffer.append("public class " + fileName + " {\n\n");
    prog.generateCode(buffer, "\t");
  
    buffer.append("\tfor (int x = 0; x < imagen.length; x++) {\n");
    buffer.append("\t\tSystem.arraycopy(imagen[x], 0, pixel, imagen[x].length * x, imagen[x].length);\n");
    buffer.append("\t}\n");
    buffer.append("\tint aux, temp; \n");
    buffer.append("\tfor (aux = 0; aux < pixel.length / 2; aux++) { \n");
    buffer.append("\t\ttemp = pixel[aux]; \n");
    buffer.append("\t\tpixel[aux] = pixel[pixel.length - aux - 1]; \n");
    buffer.append("\t\tpixel[pixel.length - aux - 1] = temp; \n");
    buffer.append("\t}\n");
    buffer.append("\tBMP_Gen.map2BMP(imagen.length, imagen[0].length, pixel, args[args.length - 1]);\n");
    buffer.append("\t}\n");
    buffer.append("}\n");

    try (Writer fileWriter = new FileWriter(file + ".java")) {
      fileWriter.write(buffer.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
