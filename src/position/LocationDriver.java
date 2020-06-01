package position;

import java.sql.SQLException;
/**
 *
 * @author K
 */
public class LocationDriver {

    public static void main(String[] args) throws SQLException {
        

        AdminPosition adminposition = new AdminPosition();
        Displaysave1 displaysave1
                = new Displaysave1(adminposition);
        
        displaysave1.menu();

        

        
    }
}
