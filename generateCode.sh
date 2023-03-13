BASEDIR=$(dirname "$0")

rm -r code
mkdir code
cd code
for (( i=1; i <= 8; ++i ))
do
    mkdir Ejem${i}
    (cd Ejem${i} && 
        java -cp ../../class:../../class/java-cup-11b-runtime.jar Main ../../ejemplos/Ejem${i}/ejem${i}.prog Ejem${i})
done