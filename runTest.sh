set -e        # Stop on error

for file in ejemplos/**/*.prg
do
   tput reset
   echo "Testing ->>> $file"
   echo "------------------------------------------------------------------------------------------------ \n"
   java -cp class:class/java-cup-11b-runtime.jar Main $file
   # echo "-------------------------------- "
   # echo "\n\n"
done