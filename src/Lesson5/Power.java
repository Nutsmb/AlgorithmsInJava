package Lesson5;

public class Power {

    public static void main(String[] args) {
        System.out.println(power(0,0));
    }

    public static int power(int a, int pow){
        if(pow == 0){
            return 1;
        }
        return a * power(a,pow-1);
    }
}
