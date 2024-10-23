package firstProjectBoardV2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberInformation implements MemberInformationSystem{


    Map<String, Runnable> membersetting = new HashMap<>();
    HashMap<String, MemberInformation> memberinfo = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    private String id;
    private String checkID;
    private String name;
    private String password;
    private String checkPassword;
    private boolean loginAccess;
    private String email;;



    public boolean isLoginAccess() {
        return loginAccess;
    }

    public void setLoginAccess(boolean loginAccess) {
        this.loginAccess = loginAccess;
    }

    public MemberInformation() {
        membersetting.put("/signup",this::signup);
        membersetting.put("/signin",this::signin);
        membersetting.put("/signout",this::signout);
        membersetting.put("/detail",this::detail);

    }

    public MemberInformation(String id,String password,String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }


    @Override
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

        System.out.println("등록할 E-mail을 입력 해주세요");
        email = sc.nextLine();

        memberinfo.put(id,new MemberInformation(id,password,name,email));

    }




    @Override
    public void signin() {

        while (!memberinfo.isEmpty()) {
            System.out.println("id를 입력해주세요");
            checkID = sc.nextLine();
            System.out.println("password를 입력 해주세요");
            checkPassword = sc.nextLine();


            if(memberinfo.containsKey(checkID)){
                MemberInformation mi = memberinfo.get(checkID);
                if(mi.password.equals(checkPassword)){
                    System.out.println("로그인에 성공했습니다");
                    System.out.println(checkID + " 님 어서오세요");
                    loginAccess = true;
                    break;
                } else{
                    System.out.println("비밀번호가 틀렸습니다");
                }
            } else {
                System.out.println("등록된 ID가 아닙니다");
            }
        }
    }

    @Override
    public void signout() {
        if (loginAccess) {
            System.out.println("로그아웃 합니다");
            loginAccess = false;
        } else {
            System.out.println("이미 로그아웃 되어 있습니다");
        }
    }

    MemberInformation checkinfo = memberinfo.get(id);

    @Override
    public void detail() {
        if (loginAccess) {
            System.out.println("정보를 확인하기 위해 ID를 입력해주세요");
            id = sc.nextLine();
            System.out.println("정보를 확인하기 위해 password를 입력해주세요");
            password = sc.nextLine();
            MemberInformation checkinfo = memberinfo.get(id);

            if(checkinfo != null && checkinfo.password.equals(password) && checkinfo.id.equals(id)) {
                System.out.println("정보를 확인했습니다");
                System.out.println("ID : " + id);
                System.out.println("Password : " + checkinfo.password);
                System.out.println("Name : " + checkinfo.name);
                System.out.println("Email : " + checkinfo.email);
                System.out.println("-----------------------------");
            } else {
                System.out.println("ID 또는 Password가 일치 하지 않습니다.");
            }
        }


    }

    @Override
    public void edit() {
        System.out.println("테스트중");
    }

    @Override
    public void remove() {

    }
}
