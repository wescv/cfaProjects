import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
   User user = new User();
   user.setName("Luciano");
     request.setAttribute("user", user);
     RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("WEB-INF/index.jsp");
     page1Dispatcher.forward(request, response);
 }


}
