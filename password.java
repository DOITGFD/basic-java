import java.util.Scanner;
public class password {
    public static String checkPass(String password) {
        if (password.length() < 8) {
            return "Weak";
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if ("!@#$%^&*()-+=".indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }

    
        if (hasLower && hasUpper && hasDigit && hasSpecial) {
            return "Strong";
        }

    
        if ((hasLower || hasUpper) && hasDigit) {
            return "Moderate";
        }

        return "Weak";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(checkPass(s));

    }
}
