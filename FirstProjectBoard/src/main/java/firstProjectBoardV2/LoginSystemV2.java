package firstProjectBoardV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystemV2 {


    Map<String, Runnable> membersetting = new HashMap<>();
    HashMap<String, LoginSystemV2> memberinfo = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    BoardMenu menu = new BoardMenu();

    public HashMap<String, LoginSystemV2> getMemberinfo() {
        return memberinfo;
    }

    public void setMemberinfo(HashMap<String, LoginSystemV2> memberinfo) {
        this.memberinfo = memberinfo;
    }

    public String getCheckID() {
        return checkID;
    }

    private String id;
    private String checkID;
    private String name;
    private String password;
    private String checkPassword;
    private boolean loginAccess;
    private String email;;

    public LoginSystemV2() {
        membersetting.put("/signup",this::signup);
        membersetting.put("/signin",this::signin);
        membersetting.put("/signout",this::logout);
        membersetting.put("/detail",this::detail);
        membersetting.put("/edit",this::edit);
        membersetting.put("/remove",this::remove);
    }

    public LoginSystemV2(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void signup() {

        System.out.println("성함이 어떻게 되시나요?");
        name = sc.nextLine();

        while (true) {
            System.out.println("등록할 ID를 입력해주세요");
            id = sc.nextLine();

            if (memberinfo.containsKey(id)) {
                System.out.println("이미 있는 id입니다! 다른 id를 선택해주세요.");
            } else {
                break; // 중복되지 않으면 루프 종료
            }
        }

        System.out.println("등록할 password를 입력해주세요");
        password = sc.nextLine();

        while (true) {
            System.out.println("등록할 E-mail을 입력 해주세요");
            email = sc.nextLine();

            String[] emailcheck = email.split("@");
            if (emailcheck.length != 2) {
                System.out.println("잘못된 형식 입니다. 다시 입력해주세요.");
                continue;
            }
            String emailaddress = emailcheck[1];  // @ 뒤쪽 부분


            if (!emailaddress.endsWith(".com")) {
                System.out.println("잘못된 형식 입니다. 다시 입력해주세요.");
                continue;
            }

            System.out.println("올바른 이메일 형식입니다: " + email);
            break;

        }


        memberinfo.put(id,new LoginSystemV2(id,password,name,email));

    }

    public void signin() {

        if (!memberinfo.isEmpty()) {
            System.out.println("id를 입력해주세요");
            checkID = sc.nextLine();
            System.out.println("password를 입력 해주세요");
            checkPassword = sc.nextLine();

            if(memberinfo.containsKey(checkID)){
                LoginSystemV2 mi = memberinfo.get(checkID);
                if(mi.password.equals(checkPassword)){
                    System.out.println("(로그인에 성공했습니다)");
                    System.out.println(checkID + " 님 어서오세요");
                    loginAccess = true;
                    menu.menuBoard();

                } else{
                    System.out.println("비밀번호가 틀렸습니다");
                }
            } else {
                System.out.println("등록된 ID가 아닙니다");
            }
        } else {
            System.out.println("등록된 계정이 없습니다");
        }
    }

    public void logout() {
        if (loginAccess) {
            System.out.println("로그아웃 합니다");
            loginAccess = false;
        } else {
            System.out.println("이미 로그아웃 되어 있습니다");
        }
    }

    public void detail() {

        if (!memberinfo.isEmpty()) {
            System.out.println("id를 입력해주세요");
            checkID = sc.nextLine();
            System.out.println("password를 입력 해주세요");
            checkPassword = sc.nextLine();


            if(memberinfo.containsKey(checkID)){
                LoginSystemV2 checkinfo = memberinfo.get(checkID);

                if(checkinfo.password.equals(checkPassword)) {

                    System.out.println("URL : http://www.board.com/accounts/detail/"+checkID);

                    System.out.println("정보를 확인했습니다");
                    System.out.println("ID : " + checkinfo.id);
                    System.out.println("Password : " + checkinfo.password);
                    System.out.println("Name : " + checkinfo.name);
                    System.out.println("Email : " + checkinfo.email);
                    System.out.println("-----------------------------");

                } else{
                    System.out.println("비밀번호가 틀렸습니다");
                }

            } else {
                System.out.println("등록된 ID가 아닙니다");
            }

        } else {
            System.out.println("등록된 계정이 없습니다");
        }
    }




    public void edit() {
        if (!memberinfo.isEmpty()) {

            System.out.println("정보를 수정 확인하기 위해 ID를 입력해주세요");
            checkID = sc.nextLine();
            System.out.println("확인하기 위해 password를 입력해주세요");
            checkPassword = sc.nextLine();
            LoginSystemV2 checkinfo = memberinfo.get(id);

            if(memberinfo.containsKey(checkID)){
                LoginSystemV2 mi = memberinfo.get(checkID);
                if(mi.password.equals(checkPassword)){

                    System.out.println("URL : http://www.board.com/accounts/edit/"+checkID);

                    System.out.println("정보를 확인했습니다");
                    System.out.println("ID : " + id);
                    System.out.println("Password : " + checkinfo.password);
                    System.out.println("Name : " + checkinfo.name);
                    System.out.println("Email : " + checkinfo.email);
                    System.out.println("-----------------------------");


                    System.out.println("바꿀 성함이 어떻게 되시나요?");
                    name = sc.nextLine();

                    System.out.println("바꿀 password를 입력해주세요");
                    password = sc.nextLine();

                    System.out.println("등록할 E-mail을 입력 해주세요");
                    email = sc.nextLine();

                    memberinfo.put(id,new LoginSystemV2(id,password,name,email));
                } else {
                    System.out.println("비밀번호가 틀렸습니다");
                }

            } else {
                System.out.println("등록된 ID가 아닙니다.");
            }
        } else {
            System.out.println("등록된 계정이 없습니다");
        }
    }


    public void remove() {
        if (!memberinfo.isEmpty()) {
            System.out.println("정보를 수정 확인하기 위해 ID를 입력해주세요");
            checkID = sc.nextLine();
            System.out.println("확인하기 위해 password를 입력해주세요");
            checkPassword = sc.nextLine();
            LoginSystemV2 checkinfo = memberinfo.get(id);

            if(memberinfo.containsKey(checkID)){
                LoginSystemV2 mi = memberinfo.get(checkID);
                if(mi.password.equals(checkPassword)){

                    System.out.println("URL : http://www.board.com/accounts/remove/"+checkID);

                    memberinfo.remove(id);
                    System.out.println("성공적으로 ID를 삭제 했습니다");

                } else {
                    System.out.println("비밀번호가 틀렸습니다");
                }
            } else {
                System.out.println("등록된 ID가 아닙니다.");
            }
        } else {
            System.out.println("등록된 계정이 없습니다");
        }
    }

}
