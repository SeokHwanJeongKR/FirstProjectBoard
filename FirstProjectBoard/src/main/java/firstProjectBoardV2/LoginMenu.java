package firstProjectBoardV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginMenu {


    Scanner sc = new Scanner(System.in);


    LoginSystemV2 memberfunction = new LoginSystemV2();


    private String LoginOption;



    public void LoginFuntion () {

            Map<String, Runnable> Loginsystem = new HashMap<>();
            Loginsystem.put("/signup", memberfunction::signup);
            Loginsystem.put("/signin", memberfunction::signin);
            Loginsystem.put("/detail", memberfunction::detail);
            Loginsystem.put("/edit", memberfunction::edit);
            Loginsystem.put("/remove", memberfunction::remove);

        while (true) {

            System.out.println("어떤 기능을 사용 하시겠습니까? /signup, /signin, /detail, /edit, /remove, /exit");
            System.out.print( "URL : http://www.board.com/accounts");
            LoginOption = sc.nextLine();
            Runnable action = Loginsystem.get(LoginOption);

            if (action != null) {
                action.run();
            } else if (LoginOption.equals("/exit")) {
                System.out.println("프로그램을 종료 합니다");
                break;
            }else {
                System.out.println("처리 불가능");
            }
        }
    }

}


