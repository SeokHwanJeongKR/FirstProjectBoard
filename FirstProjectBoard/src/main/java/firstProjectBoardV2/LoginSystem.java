package firstProjectBoardV2;


import java.util.Scanner;

public class LoginSystem {
    Scanner sc = new Scanner(System.in);


    private boolean ResultChooseLogin = false;
    private String inputValue;
    private String id;
    private String passwords;
    private String selectResult;
    private boolean start = false;
    private boolean idLoginAccess;
    private boolean passwordsAccess;
    private MenuV2 menu;

    public LoginSystem(MenuV2 menu) {
        this.menu = menu;
    }


    public boolean isStart() {
        return start;
    }

    public boolean isResultChooseLogin() {
        return ResultChooseLogin;
    }

    public boolean isIdLoginAccess() {
        return idLoginAccess;
    }

    public boolean isPasswordsAccess() {
        return passwordsAccess;
    }

    public void start() {
        System.out.println("게시판에 접속 합니다 로그인 하시려면 (아무 키)나 쳐주세요");
        sc.nextLine();
        start = true;
    }


    public void chooseLogin() {
        while (start) {

            System.out.println("로그인 하시겠습니까?");
            System.out.println("1 = 로그인 2 = 종료하기");
            inputValue = sc.nextLine();

            if (inputValue.equals("1")) {
                ResultChooseLogin = true;
                break;
            } else if (inputValue.equals("2")) {
                break;
            } else {
                System.out.println("제대로 된 값을 입력하지 않았습니다.");
            }

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

    public void chooseMenufuntion() {
        while (idLoginAccess && passwordsAccess) {
            System.out.println("무엇을 하시겠습니까?");
            System.out.println("현재 구현된 기능은 1. 게시판 2. 로그아웃 입니다.");
            selectResult = sc.nextLine();

            // 사용자의 입력 값에 따라 동작 분기
            if (selectResult.equals("1")) {
                System.out.println("게시판");
                menu.setBoardAccess(true);
                break;

            } else if (selectResult.equals("2")) {
                System.out.println("로그아웃을 선택함으로 로그아웃 합니다.");
                break;

            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }


}
