import java.util.Scanner;

public class Tac {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String input = in.nextLine();
        Stack<Character> stack = new Stack<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }
        for (int i = 0; i < input.length(); i++) {
            System.out.print(stack.pop());
        }
    }
}
