import java.util.Scanner;

public class Tac {

    public static void main(String[] args) {

        String input = " ";
        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<>(input.length());
        while(!input.equals("")){
            System.out.print("Input a string: ");
            input = in.nextLine();
            stack.reCapacity(input.length());

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                stack.push(ch);
            }
            for (int i = 0; i < input.length(); i++) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
}
