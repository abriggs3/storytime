package aaron.briggs.controller;

import aaron.briggs.persistence.DatabaseSelectProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        deliverStoryFragmentToReadingPage(request, response);

    }

    private void deliverStoryFragmentToReadingPage (HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("author_readPage", " <em>a connection test of author worked</em>");
        request.setAttribute("storyTitle_readPage", " <em>connection test of title worked</em>");
        request.setAttribute("assembledStoryFragment_readPage", " connection test of the story fragment worked");

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

