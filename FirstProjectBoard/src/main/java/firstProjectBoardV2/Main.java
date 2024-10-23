package firstProjectBoardV2;

public class Main {
    public static void main(String[] args) {
        URL url = new URL();
        MenuV2 menu = new MenuV2();
        MemberInformation mI = new MemberInformation();

            url.connectToURL();
            url.processInput();

    }
}
