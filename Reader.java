import java.util.ArrayList;
import java.util.Arrays;

public class Reader {

    public static ArrayList<String> read(String expresion){
        ArrayList<String> todo = new ArrayList<>();
        String[] separado = expresion.split("");
        System.out.println(Arrays.toString(separado));
        String temporal = "";
        int contador = 0;

        for(String caracter: separado) {
            if (caracter.equals(" ")) {
                todo.add(temporal);
                temporal = "";
            } else if (caracter.equals("(")) {
                todo.add(temporal);
                temporal = "";
                contador++;
            } else if (caracter.equals(")")) {
                todo.add(temporal);
                temporal = "";
                contador--;
            } else {
                temporal += caracter;
            }
        }
        if(contador == 0){
            System.out.print("Expresion valida");
            return todo;
        }else {
            System.out.println("Expresion invalida");
            return null;
        }
    }
}
