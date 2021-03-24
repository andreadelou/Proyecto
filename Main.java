/*
Andrea Lam, 20102
Maria Fernanda Argueta,
Alejandro Archila,

Fecha de creación: 08/03/21
Modificacón 1 : 12/03/21

 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main( String[] args){
        //Variables
        int op=0;
        boolean bandera;

        Scanner scan = new Scanner(System.in);
        List<String> Tempo = new ArrayList<String>();
        ArrayList<String> parentesis = new ArrayList<String>();
        ArrayList<String> operandos = new ArrayList<String>();
        ArrayList<String> numeros = new ArrayList<String>();
        ArrayList<String> variables = new ArrayList<String>();
        HashMap <String, ArrayList<String>> datas = new HashMap<String, ArrayList<String>>();

        System.out.print("Bienvenido a la simulación del Interprete LISP");


        do {
            System.out.print("Desea 1. ingresar alguna intrucción 2. Salir");
            op=scan.nextInt();

            //validación de entrada correcta
            while(true){
                try{
                    op = scan.nextInt();
                    System.out.println("\n");
                    if(op>2 && op<1){
                        //Si el usuario ingresa los datos correctos terminará el ciclo while.
                    }else{break;}
                }
                //Si el usuario ingresa una letra regresará un mensaje de error.
                catch(Exception o){
                    scan.nextLine();
                    System.out.println("Porfavor ingrese una opción valida");
                }
            }

            if(op ==2)
            {
                bandera =false;
                break;
            }
            else
            {
                bandera=true;
            }

            System.out.println("Ingrese el codigo: ");
            String data = scan.nextLine();
            try{
                // separando el string por espacios
                String[] str = data.split(" ");
                Tempo = Arrays.asList(str);
                for(String i: Tempo){
                    if(i.equals("(")){
                        parentesis.add(i);
                    }else if(i.equals(")")){
                        parentesis.add(i);
                    }else{
                        //operaciones
                        operandos.add(i);
                    }
                }

                String numero=("0123456789");

                //guardar numeros
                for (int i = 0; i < operandos.size(); i++) {
                    String t = operandos.get(i);
                    if(numero.contains(t))
                    {
                        numeros.add(t);
                    }

                }

                //por si no son ni de aqui ni de alla
                for(int i=0; i < operandos.size(); i++){
                    if(operandos.get(i).equals("Defun") || operandos.get(i).equals(">") || operandos.get(i).equals("<") || operandos.get(i).equals("=") || operandos.get(i).equals("atom") || operandos.get(i).equals("setq") || operandos.get(i).equals("+") || operandos.get(i).equals("-") || operandos.get(i).equals("*") || operandos.get(i).equals("/") || FuncionesExtra.isNumeric(operandos.get(i))){
                        //no pasa nada
                    }else{
                        variables.add(operandos.get(i));
                    }
                }

                //Verificar si fue ingresada bien la instrucción
                if( parentesis.size() % 2 == 0 )
                {
                    //no pasa nada
                }
                else{
                    System.out.println("Ha ingresado mal los datos, porfavor verifique");
                    bandera = false;
                    break;
                }

            }catch(Exception e){
                System.out.println("Error, porfavor verifique datos");
            }

            //Realizar operaciones
            if(operandos.contains("Defun")){
                //
                DEFUN defun = new DEFUN();
                String resultado =  defun.definir_funcion(operandos);
                System.out.println(resultado);

            }else if(operandos.contains(">")){
                //
            }else if(operandos.contains("<")){
                //
            }else if(operandos.contains("equal")|| operandos.contains("eq")){
                //
            }else if(operandos.contains("atom")){
                //
            }else if(operandos.contains("setq")){
                //
                for(int i=0; i < variables.size();i++){
                    ArrayList<String> valor = new ArrayList<String>();
                    valor.add(numeros.get(i));
                    datas.put(variables.get(i), valor);
                    //mostrar el resultado de setq
                    System.out.println(variables.get(i) + "=" + datas.get(variables.get(i)));
                }

            }else if(operandos.contains("quote") || operandos.contains("'")){
                //
            }else if(operandos.isEmpty()){
                //
            }else if(operandos.contains("Cond")){
                //
            }


        }while (bandera==true);



    }
}
