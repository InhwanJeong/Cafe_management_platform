package allmenu;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Inan
 */
public class TestDriver {
     /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {
        MainMenu mainmenu = new MainMenu();
        mainmenu.showmenu();
    }
}
