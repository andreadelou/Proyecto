public class compare{
    boolean retorno = false ;
    public boolean comparar (String one, String two, int signo){
        // 1 es mayor que
        //2 es menor que
        
        uno = Integer.parseInt(one); 
        dos = Integer.parseInt(two); 
        //>
        if(signo == 1){
            if(uno > dos){
                retorno = true;
            }else{
                retorno = false;
            }
        //<
        }else if(signo == 2{
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