package aaron.briggs.controller;

import aaron.briggs.entity.Paragraph;
import aaron.briggs.entity.Story;
import aaron.briggs.entity.User;
import aaron.briggs.persistence.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
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
    private String resultOfInsertAttempt;

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



        resultOfInsertAttempt = databaseInsertProcessor.onCreationOfNewStoryInsertIntoDatabase(nameOfForm, storyParagraphs, story);

        switch (resultOfInsertAttempt) {
            case "fail_titleMatchInDatabase" :
                displayToUserCauseOfFailureTitleMatch(request, response);
                break;
            case "successful_insert" :
                displayToUserSuccessOfInsert(request, response);
                break;
            default :
                System.out.println("The switch statement that reports the results of insert has failed. Bummer.");
        }
    }


    private void displayToUserCauseOfFailureTitleMatch(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("resultTitle_1", "Bummer");
        request.setAttribute("resultTitle_2", "We have a problem");
        request.setAttribute("resultMessage", "Your story title, <em>" + request.getParameter("storyTitle")
                + "</em>, is already in the TwistedTrail library.<br />"
                + "All titles must be unique.");
        request.setAttribute("linkMessage", "<a href=\"/submitStory.jsp\">Let me fix it!</a>");

        String url = "/submitResultsPage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void displayToUserSuccessOfInsert(HttpServletRequest request, HttpServletResponse response) {
        String storyTitle = request.getParameter("storyTitle");
        int storyId = databaseInsertProcessor.getValueOfAutoIdReturnedFromInsert();
        request.setAttribute("storyId", storyId);
        request.setAttribute("resultTitle_1", "Congratulations!");
        request.setAttribute("resultTitle_2", "You're a TwistedTrail Author");
        request.setAttribute("resultMessage", "Your story, <em>" + storyTitle
                + "</em>, has officially joined the TwistedTrail library.<br />");

        request.setAttribute("linkMessage", "<form method=\"get\" action=\"/storyReader\">\n" +
                "<input type=\"hidden\" name=\"storyTitle\" value=\"" + storyTitle + "\">\n" +
                "<input type=\"hidden\" name=\"storyId\" value=\"" + storyId + "\">\n" +
                "<input type=\"Submit\" value=\"Read it here!\"/>");

        String url = "/submitResultsPage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
