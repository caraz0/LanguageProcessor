package AST;

import java.util.List;
import java.util.Map;

import Compiler.*;

public interface LVar{
   
    void computeAH1(Type type);
    void generateCode(StringBuilder buffer, String prefix);

    default String initializeVar(String name) {
        Map<Type, String> map = Map.of(
            Type.INT, " = 0",
            Type.REAL, " = 0.0",
            Type.BOOL, " = false"    
        );

        return map.get(SymbolTable.getType(name));
    }

    List<String> getNames();
}