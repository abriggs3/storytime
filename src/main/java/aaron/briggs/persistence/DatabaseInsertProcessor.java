package aaron.briggs.persistence; /**
 * Created by aaronBriggs on 3/13/17.
 */

import java.sql.*;

public class DatabaseInsertProcessor {

    public void insertData(String contentOfParagraph) {

        Database database = Database.getInstance();
        Connection connection = null;

        try {
            database.connect();
            connection = database.getConnection();
            String sql;
            sql = "INSERT INTO paragraph (ID, dateParagraphPosted, timesFlaggedForContent, authorId, paragraphContent)" +
                    " VALUES (null,null, 1, 1,'" + contentOfParagraph + "')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            database.disconnect();

        } catch (SQLException e) {
            System.out.println("SQL Exception has occurred");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("General Exception has occurred");
            e.printStackTrace();
        }
    }
}

