/*
Andrea Lam, 20102
Maria Fernanda Argueta,
Alejandro Archila,

Fecha de creación: 08/03/21
Modificacón 1 : 12/03/21

 */

import java.util.LinkedList;
import java.util.Scanner;
public class Main {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Ingrese la expresion");
            String expresion = scanner.nextLine();
            Scanner scan = new Scanner(expresion);

            LinkedList<Object> todo = Reader.ListReader(scan);
            //System.out.println(todo);
            if (!todo.isEmpty()) {
                String resultado = Evaluador.Evaluate((LinkedList<Object>) todo.get(0));
                System.out.println(resultado);
            }
        }
    }
}
