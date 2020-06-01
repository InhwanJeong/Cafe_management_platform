package java_project_login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import membership.*;

/**
 *
 * @author 20143701 최유래 로그인 TestDriver
 */
public class TestDriverLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        UserInfo userinfo = new UserInfo();
        int type;

        SelectUseType sut = new SelectUseType();
        userinfo = sut.runSelectUseType();

        type = userinfo.getUserType();

        System.out.println("어떤 기능을 선택하시겠습니까?");

        switch (type) {
            case 1:
                System.out.println("관리자");
                break;
            case 2:
            case 3:
            case 4:
                int select = 0;
                System.out.println("1.멤버십");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                select = Integer.parseInt(in.readLine());
                if (select == 1) {
                    Client membership = new Client();
                    int level = type;
                    membership.runMembership(level);
                }
            default:
        }
    }
}
