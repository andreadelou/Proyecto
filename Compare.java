public class Compare{
  boolean retorno = false ;

    /**
     * Metodo donde se comparan los String con el int, para ver si estos son signos para retornar a la calculadora
     *@author ALejandro Archila, Maria Argueta, Andrea Lam
     *@gets String, String, int
     *@returns boolean
     */
  public boolean comparar (String one, String two, int signo){
    // 1 es mayor que
    // 2 es menor que
    double uno = Double.parseDouble(one);
    double dos = Double.parseDouble(two);
    //>
    if(signo == 1){
        if(uno > dos){
          retorno = true;
        }else{
          retorno = false;
        }
        //<
    }else if(signo == 2){
        if(uno < dos){
            retorno = true;
        }else{
            retorno = false;
        }
    }
    return retorno;
  }

  public boolean equal(String one, String two){
      if(one.equals(two)){
          retorno = true;
      }else{
          retorno = false;
      }
      return retorno;
  }
}