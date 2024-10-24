package firstProjectBoardV2;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PostFunctionV2 implements PostStructureV2 {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> arr = new ArrayList<>();


    private int postnumber;
    private String title;
    private String content;
    private boolean viewPostAccept = false;

    private String boardname;
    private String postparameter;
    private String writeday;
    private String writeday1;



    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }
    public void writePost() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = now.format(formatter);

        System.out.println("제목을 설정 해주세요");
        title = sc.nextLine();
        System.out.println("내용을 입력 해주세요");
        content = sc.nextLine();
        arr.add("제목 : " + title + "\n내용 : " + content + "\n작성일 : " + formattedDate);

    }

    public void viewPost() {
        if (!arr.isEmpty()) {

            viewPostAccept = false;

            while (!viewPostAccept) {
                try {
                    System.out.println("조회 할 항목을 불러옵니다 (?=post+number 형식으로 적어주세요 ex.?=post1)");
                    System.out.print("URL : http://www.board.com/" + boardname + "/post/view");
                    String splitpost = sc.nextLine();

                    String[] parts = splitpost.split("post");

                    if (parts.length == 2 && parts[0].equals("?=")) {
                        String postStr = parts[1].trim();
                        postnumber = Integer.parseInt(postStr);

                        if ( postnumber >= 1 && postnumber - 1 < arr.size()) {
                            System.out.println("선택한 항목 : " + (postnumber) + "\n" + arr.get(postnumber - 1));
                            viewPostAccept = true;

                            break;
                        } else {
                            System.out.println("잘못된 번호입니다. 유효한 범위는 1부터 " + arr.size() + "까지입니다.");
                        }
                    } else {
                        System.out.println("제대로 된 형태를 입력 해주세요");
                    }


                } catch(NumberFormatException e){
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        } else {
            System.out.println("조회할 게시글이 없습니다.");
        }
    }


    public void deletePost() {
        if (!arr.isEmpty()) {
            while (true) {
                try {
                    System.out.println("조회 할 항목을 불러옵니다 (?=post+number 형식으로 적어주세요 ex.?=post1)");
                    System.out.print("URL : http://www.board.com/" + boardname + "/post/remove");
                    String splitpost = sc.nextLine();
                    String[] parts = splitpost.split("post");

                    if (parts.length == 2 && parts[0].equals("?=")) {
                        String postStr = parts[1].trim();
                        postnumber = Integer.parseInt(postStr);

                        if ( postnumber >= 1 && postnumber - 1 < arr.size()) {
                            System.out.println("몇번 항목을 제거 하시겠습니까?");
                            postnumber = Integer.parseInt(sc.nextLine());
                            arr.remove(postnumber-1);
                            break;
                        } else {
                            System.out.println("잘못된 번호입니다. 유효한 범위는 1부터 " + arr.size() + "까지입니다.");
                        }
                    } else {
                        System.out.println("제대로 된 형태를 입력 해주세요");
                    }

                } catch(NumberFormatException e){
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        } else {
            System.out.println("조회할 게시글이 없습니다.");
        }
    }


    public void editPost() {
        if (!arr.isEmpty()) {
            try {
                System.out.println("조회 할 항목을 불러옵니다 (?=post+number 형식으로 적어주세요 ex.?=post1)");
                System.out.print("URL : http://www.board.com/" + boardname + "/post/eidt");
                String splitpost = sc.nextLine();
                String[] parts = splitpost.split("post");

                if (parts.length == 2 && parts[0].equals("?=")) {
                    String postStr = parts[1].trim();
                    postnumber = Integer.parseInt(postStr);

                    if (postnumber >= 1 && postnumber - 1 < arr.size()) {
                        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        String formattedDate = now.format(formatter);

                        System.out.println("제목을 설정 해주세요");
                        title = sc.nextLine();
                        System.out.println("내용을 입력 해주세요");
                        content = sc.nextLine();

                        String writeday = arr.get(postnumber - 1);
                        String[] postParts = writeday.split("\n작성일 : ");
                        String originalDate = postParts[1].split("\n수정일")[0];

                        arr.set(postnumber - 1, "제목 : " + title + "\n내용 : " + content
                                + "\n작성일 : " + originalDate + "\n수정일 : " + formattedDate);

                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        } else {
            System.out.println("조회할 게시글이 없습니다.");
        }

    }


    public void postList() {
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("No" + (i + 1) + "\n" + arr.get(i));
                System.out.println("---------------------");
            }
        } else {
            System.out.println("현재 게시글이 없습니다.");

        }
    }

}


