import java.util.LinkedList;
import java.util.HashMap;
public class Evaluador {

    public static HashMap<String, Function> funciones = new HashMap<>();
    public static String nombrefun;
    public static String[] ops = {"+", "-", "*", "/"};



    public static String Evaluate(LinkedList<Object> exp) {
        //System.out.println(exp);
        boolean verificar;
        Compare comparing = new Compare();
        if (!exp.isEmpty()) {
            Calculator calc = new Calculator();
            String res = "";
            for (int i = 0; i < exp.size(); i++) {
                Object temp = exp.get(i);
                //System.out.println(temp);
                if (temp instanceof LinkedList) {
                    res += Evaluate((LinkedList<Object>) temp);
                } else {
                    if(temp.equals("cond")){
                        for(int j = 1; j < exp.size(); j++){
                            LinkedList<Object> toca = (LinkedList<Object>) exp.get(j);
                            if(toca.size() == 1){
                                LinkedList<Object> recur = (LinkedList<Object>) toca.get(0);
                                res += Evaluate(recur);
                                System.out.println(res);
                            }else{
                                LinkedList<Object> condicion = (LinkedList<Object>) toca.get(0);
                                String esver = Evaluate(condicion);
                                if(esver.equals("true")){
                                    LinkedList<Object> task = new LinkedList<>();
                                    task.add(toca.get(1));
                                    res+= Evaluate(task);
                                    return res;
                                }
                            }
                            i++;
                        }
                    }
                    if(temp.equals("setq"))
                    {
                        for (int j=0;j<exp.size();j++)
                        {
                            Object variable= exp.get(j);
                            Object valor = exp.get(j+1);
                            variable = valor;
                            exp.add(variable);
                            exp.remove(j);
                            exp.remove(j+1);
                            j=0;
                        }

                        for (int k = 0; k < exp.size(); k++) {
                            res+= (exp.get(k));
                        }
                        return res;
                    }
                    if(temp.equals("<")){
                        String n1 = "";
                        String n2 = "";
                        if(nombrefun != null && !nombrefun.equals("")){
                            if(funciones.get(nombrefun).isParameter((String)exp.get(exp.size()-1))){
                                n1 = funciones.get(nombrefun).getparametro(((String)exp.get(exp.size()-1))) + "";
                            }else{
                                n1 = ((String)exp.get(exp.size()-1));
                            }
                            if(funciones.get(nombrefun).isParameter((String)exp.get(exp.size()-2))){
                                n2 = funciones.get(nombrefun).getparametro(((String)exp.get(exp.size()-2))) + "";
                            }else{
                                n2 = ((String)exp.get(exp.size()-2));
                            }
                        }else{
                            n1 = ((String)exp.get(exp.size()-1));
                            n2 = ((String)exp.get(exp.size()-2));
                        }
                        verificar = comparing.comparar(n1, n2,1);
                        //System.out.println(verificar);
                        exp.remove(exp.size()-1);
                        exp.remove(exp.size()-2);

                        return Boolean.toString(verificar);
                    }
                    if(temp.equals(">")){
                        String n1 = "";
                        String n2 = "";
                        if(nombrefun != null && !nombrefun.equals("")){
                            if(funciones.get(nombrefun).isParameter((String)exp.get(exp.size()-1))){
                                n1 = funciones.get(nombrefun).getparametro(((String)exp.get(exp.size()-1))) + "";
                            }else{
                                n1 = ((String)exp.get(exp.size()-1));
                            }
                            if(funciones.get(nombrefun).isParameter((String)exp.get(exp.size()-2))){
                                n2 = funciones.get(nombrefun).getparametro(((String)exp.get(exp.size()-2))) + "";
                            }else{
                                n2 = ((String)exp.get(exp.size()-2));
                            }
                        }else{
                            n1 = ((String)exp.get(exp.size()-1));
                            n2 = ((String)exp.get(exp.size()-2));
                        }
                        verificar = comparing.comparar(n1, n2,2);
                        //System.out.println(verificar);
                        exp.remove(exp.size()-1);
                        exp.remove(exp.size()-2);
                        return Boolean.toString(verificar);
                    }
                    if(temp.equals("equal")|| temp.equals("eq")){
                        String n1 = "";
                        String n2 = "";
                        if(nombrefun != null && !nombrefun.equals("")){
                            if(funciones.get(nombrefun).isParameter((String)exp.get(exp.size()-1))){
                                n1 = funciones.get(nombrefun).getparametro(((String)exp.get(exp.size()-1))) + "";
                            }else{
                                n1 = ((String)exp.get(exp.size()-1));
                            }
                            if(funciones.get(nombrefun).isParameter((String)exp.get(exp.size()-2))){
                                n2 = funciones.get(nombrefun).getparametro(((String)exp.get(exp.size()-2))) + "";
                            }else{
                                n2 = ((String)exp.get(exp.size()-2));
                            }
                        }else{
                            n1 = ((String)exp.get(exp.size()-1));
                            n2 = ((String)exp.get(exp.size()-2));
                        }
                        verificar = comparing.equal(n1, n2);
                        //System.out.println(verificar);
                        exp.remove(exp.size()-1);
                        exp.remove(exp.size()-2);
                        return Boolean.toString(verificar);

                    }
                    if(temp.equals("atom")) {
                        //Hay que verificar si hay números y letras
                        //Atom es ""true" si solo hay un tipo de variable

                        if (exp == null || exp.size() == 0) {
                            System.out.println("T");
                        } else {
                            System.out.println("NIL");
                        }
                    }
                    if(exp.contains("quote") || exp.contains("'")) {
                        //El quote no afecta el resultado
                        String resultado = (exp) + "";

                        System.out.println(resultado);
                    }
                    if (funciones.containsKey((String) temp)) {
                        LinkedList<Object> tempo = funciones.get((String) temp).getBody();
                        System.out.println(tempo + " aqui es");
                        i++;
                        String parametro;
                        if(exp.get(i) instanceof LinkedList){
                            parametro = Evaluate((LinkedList<Object>) exp.get(i));
                        }else{
                            parametro = (String) exp.get(i);
                        }
                        double valpar = Double.valueOf(parametro.trim());
                        funciones.get((String)temp).setparametro("n", valpar);
                        nombrefun = funciones.get((String)temp).getName();
                        res += Evaluate(tempo);


                    }else if(nombrefun != null && !nombrefun.equals("")){
                        if(funciones.get(nombrefun).isParameter((String) temp)) {
                            res += funciones.get(nombrefun).getparametro((String) temp) + " ";
                        }else{
                            res += (String) temp + " ";
                        }
                    }else{
                        res += (String) temp + " ";
                    }
                }
            }
            for(int i = 0; i < ops.length; i++){
                if(res.contains(ops[i])){
                    String calcular = Convertidor.prefixToPostfix(res);
                    String calculado = calc.Calculo(calcular);
                    //System.out.println(calculado);
                    return calculado + " ";
                }
            }
            return res;
        }
        return "";
    }

}
