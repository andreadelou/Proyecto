import java.util.*;

public class Reader {

     static boolean fun = false;

    /**
     * Metodo con el cual se lee la expresion y se guarda en una lista dependiendo de la expresión ingresada
     *@author ALejandro Archila, Maria Argueta, Andrea Lam
     *@gets LinkedList<Object>
     *@returns String
     */

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
            }else if(stringtemp.equals(")")){
                return expresionlistada;
            }else if(stringtemp.equals("defun")){
                fun = true;
                String name = scan.next();
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
                HashMap<String, Stack<Double>> params = new HashMap<>();
                for(int i = 0; i<parametros.size(); i++){
                    String param = parametros.get(i);
                    Stack<Double> stack = new Stack<>();
                    params.put(param, stack);
                }
                LinkedList<Object> body = Crearbody(scan);
                Function nueva = new Function(name, (LinkedList<Object>) body.get(0), params);
                Evaluador.funciones.put(name, nueva);

            }else if(!stringtemp.isBlank()){
                expresionlistada.add(stringtemp);
            }
        }

        limpiarlista(expresionlistada);

        return expresionlistada;
    }

    private static void limpiarlista(LinkedList liston){
        for(int i = 0; i <liston.size(); i++){
            if(liston.get(i) instanceof LinkedList){
                if(((LinkedList) liston.get(i)).isEmpty()){
                    liston.remove(i);
                }
            }
        }

    }
}