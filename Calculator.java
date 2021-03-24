/**
 *Clase calculator con el metodo calculo para operaciones transformadas de prefix a portfix usando Stack
 */

import java.util.Stack;
public class Calculator{
    Stack<Integer> stick = new Stack<>();

    /**
     *Metodo que recibe una String con los datos para realizar la operacion postfix
     *recibe una String con la operacion
     */
    public String Calculo(String datos){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < datos.length(); i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(datos.charAt(i));
        }
        String data = result.toString();
        String[] operacion = data.split(" ");
        String resultado = "";
        for(String dato : operacion){
            int isnum = 0;
            boolean num = false;
            try{
                if(dato.equals(" ")){
                    ;
                }
                isnum = Integer.parseInt(dato);
                num = true;
            }catch(Exception e){
                num = false;

            }
            if(num == true){
                stick.push(isnum);
            }else{
                int num1 = stick.pop();
                int num2 = stick.pop();
                switch (dato){
                    case "+":
                        resultado = String.valueOf(num2 + num1);
                        break;

                    case "-":
                        resultado = String.valueOf(num2 -num1);
                        break;

                    case "/":
                        resultado = String.valueOf(num2 / num1);
                        break;

                    case "*":
                        resultado = String.valueOf(num2 * num1);
                        break;
                }
                stick.push(Integer.parseInt(resultado));
            }
        }
        return resultado;
    }
}
