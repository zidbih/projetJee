package projet_jee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display the login form
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h2>Login</h2>");
        if ("true".equals(request.getParameter("error"))) {
            out.println("<p style=\"color: red;\">Invalid username or password</p>");
        }
        out.println("<form action=\"login\" method=\"post\" style =' max-width: 400px;\r\n"
        		+ "   width:700px;\r\n"
        		+ "     padding: 10px;\r\n"
        		+ "      border: 1px solid #ccc;\r\n"
        		+ "        border-radius: 5px;\r\n"
        		+ "     background-color: #f9f9f9;'>");
        out.println("<label for=\"username\" style='display: block;\r\n"
        		+ "           margin-bottom: 8px;\r\n"
        		+ "        	   color: #555;'>Username:</label>");
        out.println("<input type='text' id=\"username\" name=\"username\" required style=' width: calc(100% - 16px);\r\n"
        		+ " height:35px;\"\r\n"
        		+ "   font-size:20px;\r\n"
        		+ "     padding: 8px;\r\n"
        		+ "   margin-bottom: \r\n"
        		+ "  border-radius: 4px;"
        		+ "outline:none;'><br>");
        
        out.println("<label for=\"password\" style=' width: calc(100% - 16px);\\r\\n\"\r\n"
        		+ "        height:35px;\r\n"
        		+ "      font-size:20px;\r\n"
        		+ "          padding: 8px;\r\n"
        		+ "        	  margin-bottom: 16px;\r\n"
        		+ "        	   border-radius: 4px;'>Password:</label><br><br>");
        
        out.println("<input type=\"password\" id=\"password\" name=\"password\" required style=' width: calc(100% - 16px);\\r\\n\"\r\n"
        		+ " height:35px;\"\r\n"
        		+ "   font-size:20px;\r\n"
        		+ "     padding: 8px;\r\n"
        		+ "   margin-bottom: \r\n"
        		+ "  border-radius: 4px;"
        		+ "outline:none;'><br><br>");
        out.println("<input type=\"submit\" value=\"Login\" style='background-color: #4caf50;\r\n"
        		+ " color: #fff;\r\n"
        		+ " cursor: pointer;\r\n"
        		+ " width:50%;\r\n"
        		+ " border:none;\r\n"
        		+ "  padding:10px 20px;'>");
        out.println("</center>");

       

        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User defaultUser = UserService.getUser("admin"); // Retrieve the default user

        if (defaultUser != null && defaultUser.getPassword().equals(password)) {
            // Authentication successful
            request.getSession().setAttribute("user", defaultUser); // Store user in session
            response.sendRedirect("home"); // Redirect to the home page
        } else {
            // Authentication failed
            response.sendRedirect("login?error=true");
        }
    }
}

