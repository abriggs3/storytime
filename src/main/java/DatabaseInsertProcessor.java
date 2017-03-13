/**
 * Created by aaronBriggs on 3/13/17.
 */

import java.sql.*;
public class DatabaseInsertProcessor {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/storyTime";

    //  Database credentials
    static final String USER = "student";
    static final String PASSWORD = "student";

    public void insertData(String contentOfParagraph) {
        Connection connection = null;
        Statement statement = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            String sql;
            sql = "INSERT INTO paragraph (paragraphContent) VALUES (contentOfParagraph)";
            ResultSet resultSet = statement.executeQuery(sql);

            //STEP 5: Clean-up environment
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
