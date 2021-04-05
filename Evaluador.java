import java.util.LinkedList;
import java.util.HashMap;
public class Evaluador {

    public static HashMap<String, Function> funciones = new HashMap<>();


    public static String Evaluate(LinkedList<Object> exp){
        Calculator calc = new Calculator();
        String res = "";
        for(int i = 0; i <exp.size(); i++){
            Object temp = exp.get(i);
            if(temp instanceof LinkedList || temp.equals("cond")){
                //Agregar caso para cond
            }else if(temp instanceof LinkedList){
                res  += Evaluate((LinkedList<Object>) temp);
            } else{
                res += (String) temp;
            }
        }
        String calcular = Convertidor.prefixToPostfix(res);
        String calculado = calc.Calculo(calcular);
        System.out.println(calculado);
        return calculado;
    }



}
