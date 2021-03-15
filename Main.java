/*
Andrea Lam, 20102
Maria Fernanda Argueta,
Alejandro Archila,

Fecha de creación: 08/03/21
Modificacón 1 : 12/03/21

 */

import java.util.Scanner;

public class Main {

    public static void main( String[] args){
        //Variables
        int op=0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Bienvenido a la simulación del Interprete LISP");
        System.out.print("porfavor elija una de las siguientes opciones que desee realizar");
        System.out.print("1)operaciones aritméticas");
        System.out.print("2)instrucción QUOTE");
        System.out.print("3)definición de funciones (DEFUN)");
        System.out.print("4)SETQ");
        System.out.print("5)predicados (ATOM, LIST, EQUAL, <, >)");
        System.out.print("6)condicionales (COND)");
        System.out.print("7)paso de parámetros");

        //validación de entrada correcta
        while(true){
            try{
                op = scan.nextInt();
                System.out.println("\n");
                if(op>7 && op<1){
                    //Si el usuario ingresa los datos correctos terminará el ciclo while.
                }else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error.
            catch(Exception o){
                scan.nextLine();
                System.out.println("Porfavor ingrese una opción valida");
            }
        }

        switch(op) {
            case 1:
                // code block
                break;
            case 2:
                // code block
                break;
            case 3:
                // code block
                break;
            case 4:
                // code block
                break;
            case 5:
                // code block
                break;
            case 6:
                // code block
                break;
            case 7:
                // code block
                break;    

        }

    }



}
