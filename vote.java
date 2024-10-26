import java.util.Scanner;

public class vote {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();
        try{
            validate(age);
            System.out.println("Age is valid.");
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void validate(int age)throws IllegalArgumentException{
        if(age<18){
            throw new IllegalArgumentException("Age must be at least 18");
        }
    }
}