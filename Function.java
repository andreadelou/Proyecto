import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Function {
    public String name;
    public LinkedList<Object> body;
    public HashMap<String, Stack<Double>>  params;

    /**
     * Metodo con el cual se compara lo ingresado para poder implementar las funciones deseadas de una forma correcta
     * Con implementar es al momento de ingresar los parametros para los defun o variables , etc
     *@author ALejandro Archila, Maria Argueta, Andrea Lam
     *@gets String
     *@returns String
     */

    public Function(String nombre, LinkedList<Object> cuerpo, HashMap<String, Stack<Double>> parametros){
        name = nombre;
        body = cuerpo;
        params = parametros;

    }

    public void setparametro(String nombrepar, double par){
        //params.remove(nombrepar);
        Stack<Double> temporal = params.get(nombrepar);
        temporal.push(par);
        params.replace(nombrepar, temporal);
    }

    public Double getparametro(String par){
        Double valor = params.get(par).peek();
        return valor;
    }
    public void delete(String par){
        params.get(par).pop();
    }

    public LinkedList<Object> getBody(){
        return body;
    }

    public String getName(){
        return name;
    }

    public boolean isParameter(String nombrepar){
        return params.containsKey(nombrepar);
    }
}