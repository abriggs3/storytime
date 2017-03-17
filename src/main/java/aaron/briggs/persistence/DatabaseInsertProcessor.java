package aaron.briggs.persistence; /**
 * Created by aaronBriggs on 3/13/17.
 */

import java.sql.*;


public class DatabaseInsertProcessor {


    public void onCreationOfNewStoryInsertIntoDatabase(String[] storyParagraphs) {
        Database database = Database.getInstance();
        Connection connection = null;

        for (String contentOfParagraph : storyParagraphs) {

            try {
                database.connect();
                connection = database.getConnection();
                String sql;
                sql = "INSERT INTO paragraph (paragraphContent)" +
                        " VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
     //           preparedStatement.setString(1, contentOfParagraph);
                preparedStatement.setString(1, contentOfParagraph);

                preparedStatement.executeUpdate();
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
}

