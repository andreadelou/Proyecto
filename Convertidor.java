import java.util.Stack;
import java.lang.*;
public class Convertidor {
    private static boolean isOperator(Character c) {
        switch(c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    public static String prefixToPostfix(String exp) {
        //System.out.println(exp);
        Stack<String> stack = new Stack<String>();
        //String[] expresion = exp.split(" ");
        String acumulado = "";
        for (int i = exp.length() - 1; i >= 0; i--){
            Character c = exp.charAt(i);

            if (isOperator(c)) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = s1 + " " + s2 + " " + String.valueOf(c);
                stack.push(temp);
            }else if(c.equals(' ')){
                stack.push(acumulado);
                acumulado = "";
            }else {
                acumulado = c + acumulado;
            }
        }
        //System.out.println(stack.peek());

        return stack.peek();
    }
}
