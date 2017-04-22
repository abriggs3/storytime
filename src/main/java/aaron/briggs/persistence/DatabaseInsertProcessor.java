package aaron.briggs.persistence; /**
 * Created by aaronBriggs on 3/13/17.
 */

import aaron.briggs.entity.Story;

import java.sql.*;
import java.util.List;


public class DatabaseInsertProcessor {
    private int valueOfAutoIdReturnedFromInsert = -9999; // if -9999 shows up as a value, something went wrong.
    /**
     *
     * @param nameOfForm the name of the from
     * @param storyParagraphs
     * @param story
     * @return String that is the result code, if the insert was a success, or failure due to duplicateTitle
     */

    public String onCreationOfNewStoryInsertIntoDatabase(String nameOfForm, String[] storyParagraphs, Story story) {
        Database database = Database.getInstance();
        Connection connection;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String sql;
        String resultOfInsertAttempt;


        try {

            if (nameOfForm.equals("storySubmitInsert")) {
                database.connect();

                List<Story> listOfStories;
                DatabaseSelectProcessor databaseSelectProcessor = new DatabaseSelectProcessor();

                listOfStories = databaseSelectProcessor.getAllStories();
                for (Story storyTitlesAndMore : listOfStories) {
                    String titleInDataBase = storyTitlesAndMore.getStoryTitle();
                    String desiredUserTitle = story.getStoryTitle().trim();
                    if (titleInDataBase.toLowerCase().equals(desiredUserTitle.toLowerCase())) {
                        return resultOfInsertAttempt = "fail_titleMatchInDatabase";
                    }
                }
            }

            database.connect();
            connection = database.getConnection();
            // insert form contents into story table
            preparedStatement = getPreparedStatement(story, connection);

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                valueOfAutoIdReturnedFromInsert = resultSet.getInt(1);
            } else {
                System.out.println("In DatabaseInsertProcessor, the attempt to retrieve the auto generated id has failed.");
            }
            System.out.println("The value of the newly generated 'story' primary key: " + valueOfAutoIdReturnedFromInsert);

            for (String contentOfParagraph : storyParagraphs) {

                switch (nameOfForm) {
                    case "storySubmitInsert" :
             //TODO userId needs to be added once the user log on is finished.

                        sql = "INSERT INTO paragraph (paragraphContent, storyId)" +
                                " VALUES (?,?)";
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, contentOfParagraph);
                        preparedStatement.setInt(2, valueOfAutoIdReturnedFromInsert);
                        preparedStatement.executeUpdate();
                        break;
                    default:
                        System.out.println("Dang. Something went wrong in the switch statement of DataInsertProcessor");
                        break;
                }

            }

            database.disconnect();

        } catch (SQLException e) {
            System.out.println("SQL Exception has occurred");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("General Exception has occurred");
            e.printStackTrace();
        }

        return resultOfInsertAttempt = "successful_insert";
    }

    private PreparedStatement getPreparedStatement(Story story, Connection connection) throws SQLException {
        String sql;
        PreparedStatement preparedStatement;
        sql = "INSERT INTO  story (ID, storyTitle, storyRating, storyNumberOfRatings, storyAgeRating," +
                " storyNumberOfAgeRatings, userId, storyDatePublished, storyNumberOfPaths, storyType, genre," +
                " basedOnCustomGenre, summary)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, null);
        preparedStatement.setString(2, story.getStoryTitle());
        preparedStatement.setInt(3, 0);
        preparedStatement.setInt(4, 0);
        preparedStatement.setInt(5, story.getStoryAgeRating());
        preparedStatement.setInt(6, 1);
        preparedStatement.setInt(7, 1);
        preparedStatement.setTimestamp(8, null);
        preparedStatement.setInt(9, 1);
        preparedStatement.setString(10, story.getStoryType());
        preparedStatement.setString(11, story.getStoryGenre());
        preparedStatement.setString(12, story.getStoryBasedOnGenre());
        preparedStatement.setString(13, story.getStorySummary());
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    /**
     * This method allows other classes to get the value.
     * @return valueOfAutoIdReturnedFromInsert the auto generated id value for the story
     */

    public int getValueOfAutoIdReturnedFromInsert() {
        return valueOfAutoIdReturnedFromInsert;
    }
}

