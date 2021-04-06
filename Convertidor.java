import java.util.Stack;
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
        Stack<String> stack = new Stack<String>();
        //String[] expresion = exp.split(" ");

        for (int i = exp.length() - 1; i >= 0; i--){
            char c = exp.charAt(i);

            if (isOperator(c)) {
                String s1 = stack.pop();
                String s2 = stack.pop();

                String temp = s1 + s2 + String.valueOf(c);
                stack.push(temp);
            } else {
                stack.push(String.valueOf(c));
            }
        }
        //System.out.println(stack.peek());

        return stack.peek();
    }
}
