package pl.edu.pjwstk.jaz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalDouble;

@WebServlet("hello")
public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String average = req.getParameter("average");
        var respWriter = resp.getWriter();

        if (average != null && !average.isBlank()) {

            try {
                OptionalDouble aver = Arrays.stream(average.split(",")).mapToInt((s) -> Integer.parseInt(s)).average();

                resp.setStatus(200);
                resp.setContentType("text/plain");

                respWriter.println("Average of " + average + " is " + aver.getAsDouble());

            } catch (NumberFormatException nfe) {
                //nfe.printStackTrace();
                respWriter.println("No sequence of numbers");
            }

        } else {
            respWriter.println("No parameters to count");
        }

    }
}