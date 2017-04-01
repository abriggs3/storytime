package aaron.briggs.controller;

import aaron.briggs.entity.Paragraph;
import aaron.briggs.entity.Story;
import aaron.briggs.entity.User;
import aaron.briggs.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * Created by aaronBriggs on 3/6/17.
 */

@WebServlet(
        name = "storyProcessor",
        urlPatterns = {"/story", "/processor"}
)
public class StoryProcessor extends HttpServlet {
    private DatabaseInsertProcessor databaseInsertProcessor;
    private Story story;
    private User user;
    private Paragraph paragraph;
    private String nameOfForm;
    private ArrayList<Paragraph> paragraphArrayList;

    public void  doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        databaseInsertProcessor = new DatabaseInsertProcessor();
        story = new Story();
        user = new User();
        paragraphArrayList = new ArrayList<Paragraph>();
        nameOfForm = request.getParameter("formName");


        story.setStoryTitle(request.getParameter("storyTitle"));
        story.setStorySummary(request.getParameter("storyShortDescription"));
        story.setStoryAgeRating(Integer.parseInt(request.getParameter("ageRating")));
        story.setStoryType(request.getParameter("contentType"));
        story.setStoryGenre(request.getParameter("typeDropdown"));
        story.setStoryBasedOnGenre(request.getParameter("basedOnCustomGenre"));



        String fullSubmittedText = request.getParameter("story");
        String[] storyParagraphs = fullSubmittedText.split("(?<=\\?\\r\\n\\r\\n)|(?<=\\.\r\\n\\r\\n)|(?<=!\\r\\n\\r\\n)");


//TODO complete this loop for creating the paragraph objects needed to do database insert
        for (String contentOfParagraph : storyParagraphs) {
            paragraph = new Paragraph();
            paragraph.setParagraphContent(contentOfParagraph);


            paragraphArrayList.add(paragraph);
        }



        databaseInsertProcessor.onCreationOfNewStoryInsertIntoDatabase(nameOfForm, storyParagraphs, story);



        response.setContentType("text/HTML");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>");
        out.println("Story title: " + request.getParameter("storyTitle"));
        out.println("<br />Story description: " + request.getParameter("storyShortDescription"));
        out.println("<br />Story age rating: " + request.getParameter("ageRating"));
        out.println("<br />Story type: " + request.getParameter("contentType"));
        out.println("<br />Story genre: " + request.getParameter("typeDropdown"));
        out.println("<br />Story based on or custom genre: " + request.getParameter("basedOnCustomGenre"));
        out.println("<br />name of form " + request.getParameter("formName"));

        out.println("<br />The number of paragraphs is: " + storyParagraphs.length);
        out.println("<br />Here are the paragraphs");

        for (String paragraph : storyParagraphs) {
            out.print("<br />");
            out.println(paragraph);
        }

        out.println("</h1></body></html>");
    }
}
