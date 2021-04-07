import java.util.Stack;
public class Calculadora{
    Stack<Double> stick = new Stack<>();

    /**
     * Metodo que recibe una String con los datos para realizar la operacion postfix
     *@author Alejandro Archila
     *@gets String, String, int
     *@returns boolean
     */
    public String Calculo(String datos){
        String[] operacion = datos.split(" ");
        String resultado = "";
        for(String dato : operacion){
            double isnum = 0;
            boolean num = false;
            try{
                if(dato.equals(" ")){
                    ;
                }
                isnum = Double.parseDouble(dato);
                num = true;
            }catch(Exception e){
                num = false;

            }
            if(num == true){
                stick.push(isnum);
            }else{
                double num1 = stick.pop();
                double num2 = stick.pop();
                switch (dato){
                    case "+":
                        resultado = String.valueOf(num2 + num1);
                        break;

                    case "-":
                        resultado = String.valueOf(num2 - num1);
                        break;

                    case "/":
                        resultado = String.valueOf(num2 / num1);
                        break;

                    case "*":
                        resultado = String.valueOf(num2 * num1);
                        break;
                }
                stick.push(Double.parseDouble(resultado));
            }
        }
        return resultado;
    }
}
