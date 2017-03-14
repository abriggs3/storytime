package aaron.briggs.persistence; /**
 * Created by aaronBriggs on 3/13/17.
 */

import java.sql.*;
public class DatabaseInsertProcessor {



    public void insertData(String contentOfParagraph) {
        PreparedStatement preparedContentOfParagraph = null;

        Database database = Database.getInstance();
        Connection connection = null;
        try {

            database.connect();
            System.out.println("this is the contentOfParagraph " + contentOfParagraph);
            connection = database.getConnection();
            Statement insertStatement = connection.createStatement();
            String sql;
            sql = "INSERT INTO paragraph (ID, dateParagraphPosted, timesFlaggedForContent, authorId, paragraphContent)" +
                    " VALUES (null,null, 1, 1, 'contentOfParagraph')";

            insertStatement.executeUpdate(sql);
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
