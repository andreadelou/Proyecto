import java.util.LinkedList;
import java.util.HashMap;
public class Evaluador {

    public static HashMap<String, Function> funciones = new HashMap<>();
    public static String nombrefun;


    public static String Evaluate(LinkedList<Object> exp) {
        if (!exp.isEmpty()) {
            Calculator calc = new Calculator();
            String res = "";
            for (int i = 0; i < exp.size(); i++) {
                Object temp = exp.get(i);
                //System.out.println(temp);
                if (temp instanceof LinkedList) {
                    res += Evaluate((LinkedList<Object>) temp);
                } else {
                    if (funciones.containsKey((String) temp)) {
                        LinkedList<Object> tempo = funciones.get((String) temp).getBody();
                        i++;
                        String parametro = (String) exp.get(i);
                        Integer valpar = Integer.valueOf(parametro);
                        funciones.get((String)temp).setparametro("n", valpar);
                        nombrefun = funciones.get((String)temp).getName();
                        res += Evaluate(tempo);


                    }else if(funciones.get(nombrefun).isParameter((String) temp)){
                        res += funciones.get(nombrefun).getparametro((String) temp);
                    }else{
                        res += (String) temp;
                    }
                }
            }
            String calcular = Convertidor.prefixToPostfix(res);
            String calculado = calc.Calculo(calcular);
            System.out.println(calculado);
            return calculado;
        }
        return "";
    }



}
