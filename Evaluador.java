import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Evaluador {

    public static HashMap<String, Function> funciones = new HashMap<>();
    public static String nombrefun;
    public static String[] ops = {"+", "-", "*", "/"};


    /**
     * Metodo con el cual se compara lo ingresado para llamar a las funciones correspondientes o realizar datos en el mismo espacio
     *@author ALejandro Archila, Maria Argueta, Andrea Lam
     *@gets LinkedList<Object>
     *@returns String
     */
    public static String Evaluate(LinkedList<Object> exp) {
        boolean verificar;
        Compare comparing = new Compare();
        if (!exp.isEmpty()) {
            Calculadora calc = new Calculadora();
            String res = "";
            for (int i = 0; i < exp.size(); i++) {
                Object temp = exp.get(i);
                if (temp instanceof LinkedList) {
                    res += Evaluate((LinkedList<Object>) temp);
                } else {
                    if(temp.equals("cond")){
                        for(int j = 1; j < exp.size(); j++){
                            LinkedList<Object> toca = (LinkedList<Object>) exp.get(j);
                            if(toca.size() == 1){
                                LinkedList<Object> recur = (LinkedList<Object>) toca.get(0);
                                res += Evaluate(recur);
                            }else if(toca.get(0) instanceof String){
                                String validar = (String) toca.get(0);
                                if(validar.equals("t")){
                                    LinkedList<Object> operacion = (LinkedList<Object>) toca.get(1);
                                    res += Evaluate(operacion);
                                }

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
                            i+=1;
                        }
                    }
                    if(temp.equals("setq"))
                    {
                        //( setq world 5 )
                        for (int j=1;j<exp.size()-1;j++)
                        {
                            Object variable= exp.get(j);
                            Object valor = exp.get(j+1);
                            variable = valor;
                            exp.add(variable);
                            exp.remove(j);
                            exp.remove(j+1);
                            j=0;
                        }

                        for (int k = 1; k < exp.size(); k++) {
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
                    if(temp.equals("list")){
                        exp.remove("list");
                        if(exp == null || exp.size() == 0) {
                            //Si ya no hay operandos ya se puede imprimir la lista hecha previamente
                            if (exp != null || exp.size() != 0) {
                                //Se imprimen los números como lista
                                System.out.print("(");
                                for (int o = 0; i < exp.size(); o++) {
                                    System.out.print(o + ", ");
                                }
                                System.out.print(")");
                            } else {
                                //se imprimen las variables como lista
                                System.out.print("(");
                                /*for (int e = 0; exp.size(); e++){
                                    System.out.print(e+ ", ");
                                }
                                System.out.print(")");*/
                            }
                        }

                    }
                    if(exp.contains("quote") || exp.contains("'")) {
                        //El quote no afecta el resultado
                        String resultado = (exp) + "";

                        System.out.println(resultado);
                    }
                    if (funciones.containsKey((String) temp)) {
                        LinkedList<Object> tempo = funciones.get((String) temp).getBody();
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
                        funciones.get((String)temp).delete("n");


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
            return res.replaceAll("cond", "");
        }
        return "";
    }
}