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
        System.out.println("ran the select all here is the statement " + sql);
        return executeQuery(sql);
    }

    public List<Story> findAllStoriesByHighestRated() {

        String sql = "SELECT * FROM story ORDER BY storyRating DESC LIMIT 10";
        System.out.println("ran the select order by story rating; here is the statement " + sql);
        return executeQuery(sql);
    }

    public List<Story> findAllStoriesByMostTwisted() {

        String sql = "SELECT * FROM story ORDER BY storyNumberOfPaths DESC LIMIT 10";
        System.out.println("ran the select order by story number of paths; here is the statement " + sql);
        return executeQuery(sql);
    }

    public List<Story> findAllStoriesByPublishedDate() {

        String sql = "SELECT * FROM story ORDER BY storyDatePublished DESC LIMIT 10";
        System.out.println("ran the select order by DATE; here is the statement " + sql);
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
            System.out.println("created the results set " + results);
            runWhileLoop(storyArrayList, results);
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("There has been an SQL error in the executeQuery method of the Story class.");


        } catch (Exception e) {
            System.out.println("UserData.getAllUsers()...Exception: " + e);
            e.printStackTrace();
        }
        return storyArrayList;
    }

    private void runWhileLoop(List<Story> storyArrayList, ResultSet results) throws SQLException {
        System.out.println("started while loop");
        while (results.next()) {
            System.out.println("this comes from inside the while loop");
            Story story = createStoryFromResults(results);
            storyArrayList.add(story);
        }
    }

    private Story createStoryFromResults(ResultSet results) throws SQLException {
        System.out.println("Started create story from results");
        Story story = new Story();
        story.setStoryId(results.getInt("ID"));
        story.setStoryTitle(results.getString("storyTitle"));
        story.setStoryRating(results.getInt("storyRating"));
        story.setStoryNumberOfRatings(results.getInt("storyNumberOfRatings"));
        story.setStoryAgeRating(results.getInt("storyAgeRating"));
        story.setStoryNumberOfAgeRatings(results.getInt("storyNumberOfAgeRatings"));
        story.setUserId(results.getInt("userId"));
        story.setStoryDatePublished(results.getDate("storyDatePublished").toLocalDate());
        return story;
    }

}
