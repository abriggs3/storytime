package aaron.briggs.controller;

import aaron.briggs.entity.Paragraph;
import aaron.briggs.persistence.DataBaseSelectParagraph;
import aaron.briggs.persistence.DatabaseSelectProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronBriggs on 4/12/17.
 */

@WebServlet(
        name = "storyReaderProcessor",
        urlPatterns = {"/storyReader"}
)
public class StoryReaderProcessor extends HttpServlet {
    private DatabaseSelectProcessor databaseSelectProcessor;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        String storyTitle = request.getParameter("storyTitle");
        int storyId = Integer.parseInt(request.getParameter("storyId"));

        deliverStoryFragmentToReadingPage(request, response, storyTitle, storyId);
    }

    private void deliverStoryFragmentToReadingPage(HttpServletRequest request, HttpServletResponse response, String storyTitle, int storyId) {
        DataBaseSelectParagraph dataBaseSelectParagraph = new DataBaseSelectParagraph();
        List<Paragraph> allParagraphsInStoryArrayList = new ArrayList<Paragraph>();

        allParagraphsInStoryArrayList = dataBaseSelectParagraph.getAllParagraphsInASingleStory(storyId);
        String storyForDisplay = "";

        for(Paragraph paragraph : allParagraphsInStoryArrayList) {
            String paragraphContent = paragraph.getParagraphContent();
            storyForDisplay += paragraphContent;
        }

        request.setAttribute("author_readPage", request.getParameter("resultTitle_1"));
        request.setAttribute("storyTitle_readPage", storyTitle);
        request.setAttribute("assembledStoryFragment_readPage", storyForDisplay);

        String url = "/readStory.jsp";
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

