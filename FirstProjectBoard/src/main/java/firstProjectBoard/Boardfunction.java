package firstProjectBoard;

import java.util.Scanner;

public class Boardfunction implements BoardStructure {

    Scanner sc = new Scanner(System.in);

    private String title;
    private int postnumber;
    private String content;

    //현재 id 와 pass word는 user 0000만 가능하다.
    private boolean ResultChooseLogin = false;
    private String inputValue;
    private String id;
    private String passwords;
    private boolean idLoginAccess = false;
    private boolean passwordsAccess = false;


    public boolean isIdLoginAccess() {
        return idLoginAccess;
    }

    public boolean isPasswordsAccess() {
        return passwordsAccess;
    }

    public void start() {
        System.out.println("게시판에 접속 합니다 로그인 하시려면 (아무 키)나 쳐주세요");
        sc.nextLine();
    }

    public void chooseLogin() {
        System.out.println("로그인 하시겠습니까?");
        System.out.println("1 = 로그인 2 = 종료하기");
        inputValue = sc.nextLine();

        if (inputValue.equals("1")) {
            ResultChooseLogin = true;
        } else {
            System.out.println("종료합니다");
        }

    }


    public void acceptLogin() {
        while (ResultChooseLogin) {
            if (inputValue.equals("1")) {
                System.out.println("아이디를 입력 해주세요 현재 가능한 id = user1 밖에 없습니다");
                id = sc.nextLine();
                idLoginAccess = true;
                break;
            } else if (inputValue.equals("2")) {
                System.out.println("안녕히 가세요");
                id = "2";
                idLoginAccess = false;
                start();
            } else {
                System.out.println("제대로 된 숫자를 입력해주세요");
                chooseLogin();
            }
        }

    }



    public void login() {
        while (idLoginAccess) {
            if ((id.equals("user1")) && (idLoginAccess)) {
                System.out.println("비밀번호를 입력해주세요 현재 가능한 비밀번호는 0000입니다.");
                passwords = sc.nextLine();
                passwordsAccess = true;
                break;
            } else if ((!id.equals("user1")) && (idLoginAccess)) {
                System.out.println("등록된 id 가 아닙니다.");
                acceptLogin();
            } else {
                System.out.println("정상적인 방법으로 연결 해주세요");
                break;
            }
        }

    }


    public void checkPassword() {
        while (passwordsAccess) {
            if ((passwords.equals("0000")) && (passwordsAccess)) {
                System.out.println(id + " 님 반갑습니다 ");
                break;
            } else if ((!passwords.equals("0000")) && (passwordsAccess)) {
                System.out.println("비밀번호가 잘못 되었습니다.");
                login();
            } else {
                System.out.println("비밀 번호를 정상적인 방법으로 연결 해주세요");
                break;
            }
        }

    }



    @Override
    public void Wr1itePost() {
        if ()


    }

    @Override
    public void ViewPost() {

    }

    @Override
    public void DeletePost() {

    }

    @Override
    public void EditPost() {

    }

    @Override
    public void PostList() {

    }

    public void logout() {

    }
}
