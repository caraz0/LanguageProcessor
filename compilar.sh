tput reset

# Clean all generated files
################################################################
(cd class && rm -rf AST Errors JLex Parser)
(cd java/Lexer && rm -f Yylex.java)
(cd java/Parser && rm -f parser.java sym.java)
rm -f java/Main.class
################################################################

sleep 2     # Wait for rm to complete (Probably a better way to do this)

set -e      # Stop script on error 

# Compile Java classes in order
javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/JLex/*.java      # Compile JLex
javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/Errors/*.java      # Compile Errors
javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/Compiler/*.java      # Compile Compiler
javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/AST/*.java      # Compile AST


(cd java/Parser && java  -jar ../../class/java-cup-11b.jar parser)        # Generate Parser files

(cd java/Lexer && java -cp ../../class/ JLex.Main Yylex)    # Generate Lexer files


javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/Parser/*.java      # Compile Parser
javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/Lexer/Yylex.java      # Compile Yylex
javac -nowarn -cp class/java-cup-11b-runtime.jar:class -d class java/Main.java      # Compile Main

echo "-------------------------------- "
echo "Compile sucesfull"
echo "-------------------------------- "