import java.util.HashMap;
import java.util.LinkedList;

public class Function {
  public String name;
  public LinkedList<Object> body;
  public HashMap<String, Integer>  params;

  public Function(String nombre, LinkedList<Object> cuerpo, HashMap<String, Integer> parametros){
      name = nombre;
      body = cuerpo;
      params = parametros;

  }

  public void setparametro(String nombrepar, int par){
    params.remove(nombrepar);
    params.put(nombrepar, par);
  }

  public Integer getparametro(String par){
    Integer valor = params.get(par);
    return valor;
  }
}
