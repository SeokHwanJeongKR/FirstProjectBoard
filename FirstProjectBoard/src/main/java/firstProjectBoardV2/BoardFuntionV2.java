package firstProjectBoardV2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BoardFuntionV2 {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> boardNames = new ArrayList<>();
    ArrayList<PostFunctionV2> board = new ArrayList<>();

    private String boardname;
    private int boardnumber;
    private String boardoption;
    private String newboardName;

    public void addBoard() {
        System.out.println("추가 할 게시판 이름을 입력 해주세요 : ");
        boardname = sc.nextLine();
        boardNames.add(boardname);
        board.add(new PostFunctionV2());

    }

    public void editBoard() {
        try{
            listBoard();
            System.out.println("수정 할 게시판 번호를 입력 해주세요");
            boardnumber = Integer.parseInt(sc.nextLine());
            System.out.println("게시판 이름을 어떻게 수정하시겠습니까?");
            newboardName = sc.nextLine();

            boardNames.set(boardnumber-1, newboardName);

        } catch (NumberFormatException e){
            System.out.println("숫자를 입력해주세요.");
        }
    }

    public void removeBoard() {
        if(board.isEmpty()){
            System.out.println("게시판이 없습니다");
        } else {
            listBoard();
            System.out.println("삭제 할 게시판 번호를 입력 해주세요");
            boardnumber = Integer.parseInt(sc.nextLine());
            boardNames.remove(boardnumber-1);
            board.remove(boardnumber-1);
            System.out.println("게시판 삭제 완료");
            listBoard();
        }
    }



    public void listBoard() {
        if(board.isEmpty()){
            System.out.println("작성된 게시판이 없습니다");
        } else {
            System.out.println("게시판 목록");
            System.out.println("---------------------");
            for (int i = 0; i < boardNames.size(); i++) {
                System.out.println("No : " + (i + 1) + " " + boardNames.get(i));
            }
        }
    }

    public void entryBoard() {

            try {
                if(board.isEmpty()){
                    System.out.println("작성된 게시판이 없습니다.");
                } else {
                    System.out.println("어떤 게시판으로 접속 하시겠습니까?");
                    listBoard();
                    boardnumber = Integer.parseInt(sc.nextLine());

                    if (boardnumber > 0 && boardnumber <= board.size()) {
                        PostFunctionV2 selectedBoardFunction = board.get(boardnumber - 1);  // 선택된 게시판의 기능 가져오기
                        menuPost(selectedBoardFunction);
                    } else if (boardnumber == 10) {
                        System.out.println("나갑니다");
                    } else {
                        System.out.println("유효하지 않은 게시판 번호입니다.");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력 해주세요");
            }

    }


    public void menuPost(PostFunctionV2 pf) {
        Map<String, Runnable> Postfunction = new HashMap<>();
        Postfunction.put("/add",pf::writePost);
        Postfunction.put("/view",pf::viewPost);
        Postfunction.put("/remove",pf::deletePost);
        Postfunction.put("/edit",pf::editPost);
        Postfunction.put("/list",pf::postList);

        while (true) {

            System.out.println("어떤 기능을 사용 하시겠습니까? /add, /edit, /remove, /list, /view, /back");
            System.out.print( "http://www.board.com/" + boardNames.get(boardnumber - 1)+"/post");
            pf.setBoardname(boardNames.get(boardnumber - 1));
            boardoption = sc.nextLine();
            Runnable action = Postfunction.get(boardoption);

            if (action != null) {
                action.run();
            } else if (boardoption.equals("/back")) {
                System.out.println("메뉴로 돌아갑니다");
                break;
            }else {
                System.out.println("처리 불가능");
            }

        }
    }

}
