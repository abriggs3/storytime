package aaron.briggs.controller;

import aaron.briggs.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by aaronBriggs on 3/6/17.
 */

@WebServlet(
        name = "storyProcessor",
        urlPatterns = {"/story", "/processor"}
)
public class StoryProcessor extends HttpServlet {
    DatabaseInsertProcessor databaseInsertProcessor;

    public void  doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        databaseInsertProcessor = new DatabaseInsertProcessor();

        String fullSubmittedText = request.getParameter("story");
        String[] storyParagraphs = fullSubmittedText.split("(?<=\\?\\r\\n\\r\\n)|(?<=\\.\r\\n\\r\\n)|(?<=!\\r\\n\\r\\n)");

        for (String contentOfParagraph : storyParagraphs) {
           databaseInsertProcessor.insertData(contentOfParagraph);
        }



        response.setContentType("text/HTML");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>");
        out.println("Story title: " + request.getParameter("storyTitle"));
        out.println("<br />Story description: " + request.getParameter("storyShortDescription"));
        out.println("<br />Story age rating: " + request.getParameter("ageRating"));
        out.println("<br />derivative dropdown: " + request.getParameter("derivativeDropdown"));
        out.println("<br />derived from title: " + request.getParameter("derivedFromDerivative"));
        out.println("<br />original dropdown: " + request.getParameter("originalDropdown"));
        out.println("<br />custom genre: " + request.getParameter("customGenre"));

        out.println("<br />The number of paragraphs is: " + storyParagraphs.length);
        out.println("<br />Here are the paragraphs");

        for (String paragraph : storyParagraphs) {
            out.print("<br />");
            out.println(paragraph);
        }

        out.println("</h1></body></html>");
    }
}
