package firstProjectBoardV2;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardfunctionV2 implements BoardStructureV2 {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> arr = new ArrayList<>();



    private int postnumber;
    private String title;
    private String content;



    private boolean idLoginAccess = false;
    private boolean passwordsAccess = false;

    private boolean viewPostAccept = false;







    public boolean isIdLoginAccess() {
        return idLoginAccess;
    }

    public boolean isPasswordsAccess() {
        return passwordsAccess;
    }







    @Override
    public void writePost() {

        System.out.println("제목을 설정 해주세요");
        title = sc.nextLine();
        System.out.println("내용을 입력 해주세요");
        content = sc.nextLine();
        arr.add("제목 : " + title + "\n내용 : " + content);

    }

    @Override
    public void viewPost() {
        if (!arr.isEmpty()) {

            viewPostAccept = false;

            while (!viewPostAccept) {
                try {
                    System.out.println("몇 번 항목을 조회하시겠습니까?");
                    postnumber = Integer.parseInt(sc.nextLine());

                    if (postnumber >= 1 && postnumber -1 < arr.size()) {
                        System.out.println("선택한 항목 : " + (postnumber) + "\n" + arr.get(postnumber-1));
                        viewPostAccept = true;

                        break;
                    } else {
                        System.out.println("잘못된 번호입니다. 유효한 범위는 1부터 " + arr.size() + "까지입니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        } else {
            System.out.println("조회할 게시글이 없습니다.");
        }
    }


    @Override
    public void deletePost() {
        if (!arr.isEmpty()) {
            try {
                System.out.println("몇번 항목을 제거 하시겠습니까?");
                postnumber = Integer.parseInt(sc.nextLine());
                arr.remove(postnumber-1);

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");


            }
        }
    }

    @Override
    public void editPost() {
        if (!arr.isEmpty()) {
            try {
                System.out.println("몇번 항목을 수정하시겠습니까??");
                postnumber = Integer.parseInt(sc.nextLine());
                System.out.println("제목을 설정 해주세요");
                title = sc.nextLine();
                System.out.println("내용을 입력 해주세요");
                content = sc.nextLine();
                arr.set((postnumber-1),"제목 : " + title + "\n내용 : " + content);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

    }

    @Override
    public void postList() {
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("항목 " + (i + 1) + ":\n" + arr.get(i));
                System.out.println("---------------------");
            }
        }
    }

}

