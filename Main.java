import java.util.LinkedList;
import java.util.Scanner;
public class Main {

    /**
     * Metodo en el cual se implementa la recursividad, para lograr resolver las expresiones ingresadas
     *@author ALejandro Archila, Maria Argueta, Andrea Lam
     *@gets
     *@returns
     */
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      while(true) {
          System.out.println("Ingrese la expresion");
          String expresion = scanner.nextLine();
          Scanner scan = new Scanner(expresion);

          LinkedList<Object> todo = Reader.ListReader(scan);
          if (!todo.isEmpty()) {
              String resultado = Evaluador.Evaluate((LinkedList<Object>) todo.get(0));
              System.out.println(resultado);
          }
      }
    }
}