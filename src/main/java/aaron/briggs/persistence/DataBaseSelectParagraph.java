package aaron.briggs.persistence;

import aaron.briggs.entity.Paragraph;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronBriggs on 4/19/17.
 */
public class DataBaseSelectParagraph {
    public List<Paragraph> getAllParagraphsInASingleStory(int ID) {
        String sql = "SELECT * FROM paragraph WHERE storyId = " + ID + "";
        return executeQuery(sql);
    }


    private List<Paragraph> executeQuery(String sql) {
        List<Paragraph> allParagraphsInStoryArrayList = new ArrayList<Paragraph>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            runWhileLoop(allParagraphsInStoryArrayList, results);
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("There has been an SQL error in the executeQuery method of the DataSelectProcessor class." +
                    "This error is caused when an attempt to run a select statement on the 'story' table has failed.");


        } catch (Exception e) {
            System.out.println("UserData.getAllUsers()...Exception: " + e);
            e.printStackTrace();
        }
        return allParagraphsInStoryArrayList;
    }

    private void runWhileLoop(List<Paragraph> allParagraphsInStoryArrayList, ResultSet results) throws SQLException {

        while (results.next()) {
            Paragraph paragraphInStory = createParagraphFromResults(results);
            allParagraphsInStoryArrayList.add(paragraphInStory);
        }
    }

    private Paragraph createParagraphFromResults(ResultSet resultSet) throws SQLException {
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraphId(resultSet.getInt("ID"));
        paragraph.setParagraphDatePosted(resultSet.getDate("dateParagraphPosted").toLocalDate());
        paragraph.setParagraphTimesFlaggedForContent(resultSet.getInt("timesFlaggedForContent"));
        paragraph.setParagraphAuthorId(resultSet.getInt("authorId"));
        paragraph.setParagraphContent(resultSet.getString("paragraphContent"));
        paragraph.setParagraphStoryId(resultSet.getInt("storyId"));
        paragraph.setParagraphPathId(resultSet.getInt("pathId"));
        return paragraph;
    }
}

