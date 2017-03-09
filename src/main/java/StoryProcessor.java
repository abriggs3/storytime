
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

    public void  doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

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
        out.println("<br />Story: " + request.getParameter("story"));
        out.println("</h1></body></html>");
    }

    public void  doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/HTML");
        System.out.println("the story is" + request.getParameter("story") );
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>");
        out.println("Story title: " + request.getParameter("storyTitle"));
        out.println("<br />Story description: " + request.getParameter("storyShortDescription"));
        out.println("<br />Story age rating: " + request.getParameter("ageRating"));
        out.println("<br />derivative dropdown: " + request.getParameter("derivativeDropdown"));
        out.println("<br />derived from title: " + request.getParameter("derivedFromDerivative"));
        out.println("<br />original dropdown: " + request.getParameter("originalDropdown"));
        out.println("<br />custom genre: " + request.getParameter("customGenre"));
        out.println("<br />Story: " + request.getParameter("story"));
        out.println("</h1></body></html>");
    }



}
