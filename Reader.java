import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

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

    private static LinkedList<Object> Crearbody(Scanner scanneado){
        LinkedList<Object> expresionlistada = new LinkedList<Object>();
        LinkedList<Object> temporal = new LinkedList<Object>();
        while(scanneado.hasNext()) {
            String stringtemp = scanneado.next();
            if (stringtemp.equals("(")) {
                temporal = ListReader(scanneado);
                expresionlistada.add(temporal);
            } else if (stringtemp.equals(")")) {
                return expresionlistada;
            }
        }
        return expresionlistada;
    }

    public static LinkedList<Object> ListReader(Scanner scan){
        LinkedList<Object> expresionlistada = new LinkedList<Object>();
        LinkedList<Object> temporal = new LinkedList<Object>();
        while(scan.hasNext()){
            String stringtemp = scan.next();
            if(stringtemp.equals("(")){
                temporal = ListReader(scan);
                expresionlistada.add(temporal);
            }else if(stringtemp .equals(")")){
                return expresionlistada;
            }else if(stringtemp.equals("defun")){
                String name = scan.next();
                System.out.println(name);
                int contador = 2;
                ArrayList<String> parametros = new ArrayList<>();
                while(contador !=0) {
                    String tempy = scan.next();
                    if (tempy.equals("(")) {
                        contador--;

                    } else if (tempy.equals(")")) {
                        contador--;
                    }else{
                        parametros.add(tempy);
                    }
                }
                HashMap<String, Integer> params = new HashMap<>();
                for(int i = 0; i<parametros.size(); i++){
                    String param = parametros.get(i);
                    params.put(param, 0);
                }
                LinkedList<Object> body = Crearbody(scan);
                System.out.println(body.get(0));
                Function nueva = new Function(name, (LinkedList<Object>) body.get(0), params);
                Evaluador.funciones.put(name, nueva);
                return  (LinkedList<Object>) body.get(0);

            }else{
                expresionlistada.add(stringtemp);
            }
        }

        return expresionlistada;
    }
}
