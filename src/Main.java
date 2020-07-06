import Login.Model;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
//	    new Controller();
        Object[] User;
        Model model = new Model();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int id = scanner.nextInt();
            model.getUser(id);
            User = model.User;
            System.out.println(User[0] + " - " + User[1]);
        }
    }
}
