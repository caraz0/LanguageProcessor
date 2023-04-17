java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem1/Rectangulo.prg Rectangulo
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem2/Diagonal1.prg Diagonal1
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem3/Diagonal2.prg Diagonal2
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem4/Triangulo1.prg Triangulo1
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem5/Circulo.prg Circulo
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem6/Circulo.prg Circulo2
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem7/Triangulo2.prg Triangulo2
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem8/Triangulo3.prg Triangulo3
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem9/Mixto.prg Mixto
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem10/Seno.prg Seno
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem11/Zigzag.prg Zigzag
java -cp class/java-cup-11b-runtime.jar:class Main ejemplos/Ejem12/Exponencial.prg Exponencial

javac *.java

java Rectangulo 200 100 Rectangulo.bmp
java Diagonal1 150 Diagonal1.bmp
java Diagonal2 150 Diagonal2.bmp
java Triangulo1 400 400 200 Triangulo1.bmp
java Circulo Circulo.bmp
java Circulo2 Circulo2.bmp
java Triangulo2 400 400 200 Triangulo2.bmp
java Triangulo3 400 400 200 Triangulo3.bmp
java Mixto Mixto.bmp
java Seno 600 8 Seno.bmp
java Zigzag 900 Zigzag.bmp
java Exponencial 900 1 Exponencial.bmp