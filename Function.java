import java.util.HashMap;
import java.util.LinkedList;

public class Function {
  public String name;
  public LinkedList<Object> body;
  public HashMap<String, Double>  params;

  public Function(String nombre, LinkedList<Object> cuerpo, HashMap<String, Double> parametros){
    name = nombre;
    body = cuerpo;
    params = parametros;

  }

  public void setparametro(String nombrepar, double par){
    params.remove(nombrepar);
    params.put(nombrepar, par);
}

  public Double getparametro(String par){
    Double valor = params.get(par);
    return valor;
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
