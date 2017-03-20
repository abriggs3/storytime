package aaron.briggs.persistence;

import aaron.briggs.entity.Story;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronBriggs on 3/15/17.
 */
public class DatabaseSelectProcessor {

    public List<Story> getAllStories() {

        String sql = "SELECT * FROM story";
        return executeQuery(sql);
    }




    private List<Story> executeQuery(String sql) {

        List<Story> storyArrayList = new ArrayList<Story>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            demoWhile(storyArrayList, results);
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("There has been an SQL error in the executeQuery method of the Story class.");


        } catch (Exception e) {
            System.out.println("UserData.getAllUsers()...Exception: " + e);
            e.printStackTrace();
        }
        return storyArrayList;
    }

    private void demoWhile(List<Story> storyArrayList, ResultSet results) throws SQLException {
        while (results.next()) {
            Story story = createStoryFromResults(results);
            storyArrayList.add(story);
        }
    }

    private Story createStoryFromResults(ResultSet results) throws SQLException {
        Story story = new Story();
        story.setStoryId(results.getInt("ID"));
        story.setStoryTitle(results.getString("storyTitle"));
        story.setStoryRating(results.getInt("storyRating"));
        story.setStoryNumberOfRatings(results.getInt("storyNumberOfRatings"));
        story.setStoryContentRating(results.getInt("storyContentRating"));
        story.setStoryNumberOfContentRatings(results.getInt("storyNumberOfContentRatings"));
        story.setUserId(results.getInt("userId"));
        story.setStoryDatePublished(results.getDate("storyDatePublished").toLocalDate());
        return story;
    }










    public String testThisMethod() {
        String test = "<li>TESTING!!</li>";
        String list = "";

        for (int counter = 0; counter < 10 ; counter++) {
            list += test;
        }
        String printThis = "<ul>" + list + "</ul>";
        return printThis;
    }
}
