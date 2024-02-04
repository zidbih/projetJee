package projet_jee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/")
public class MainServlet extends HttpServlet {
static int count=0;
	
	private static final long serialVersionUID = 1L;
	public static Map<String, String> formDataMap; // LinkedHashMap to store form data

	    @Override
	    public void init() throws ServletException {
	        super.init();
	        formDataMap = new LinkedHashMap<>(); // Initialize LinkedHashMap in init method
	    }
	    
	    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	 User user = (User) request.getSession().getAttribute("user");
    	 
    	    if (user == null) {
    	      
    	    	response.sendRedirect("login");
    	    }  
    	    
    	  
    	    
        // Set the content type of the response
        response.setContentType("text/html");

        // Get the PrintWriter object to write the HTML content
        PrintWriter out = response.getWriter();

        // Write the HTML content
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Home Page</title>");
        out.println("</head>");
        out.println("<body>");

        out.print("<div style='display:flex;justify-content:space-around;align-items:start;width:100%'>");
        
        // Add a form with 7 input fields
        
        out.println("<form action='' method='post' style =' max-width: 400px;\r\n"
        		+"width:700px;\r\n"
        		+ "    padding: 10px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 5px;\r\n"
        		+ "    background-color: #f9f9f9;'>");
        
        if("true".equals(request.getParameter("success"))) {
        	
        	out.print("<p style='color:blue;font-size:18px ; text-align:center;'>Votre Soumission a ete ajouter avec success</p>");
        }
        
        out.print("<input type='hidden' name='action' value='post-info'>");

        out.println("<h2 style='text-align:center'>Ajouter Votre Information</h1>");
        out.println("<label for='input1' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Nom soumissionnaire</label>");
        out.println("<input type='text' id='input1' name='nomS' required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<label for='input2' style='  display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Montant Proposition</label>");
        out.println("<input type='number' id='input2' name='montantP' min='0' required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<label for='input3' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Date de Soumission</label>");
        out.println("<input type='date' id='input3' name='dateS'required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<label for='input4' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Nom du projet realiser</label>");
        out.println("<input type='text' id='input4' name='nomP' required  style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<label for='input5'style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Client</label>");
        out.println("<input type='text' id='input5' name='clientName'  required    style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<label for='input6' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Montant</label>");
        out.println("<input type='number' id='input6' min='0' name='montant'  required   style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<label for='input7' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Date de realisation</label>");
        out.println("<input type='date' id='input7' name='dateR' required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");

        out.println("<input type='submit' value='Submit'style='background-color: #4caf50;\r\n"
        		+ "    color: #fff;\r\n"
        		+ "    cursor: pointer;"
        		+ "width:50%;"
        		+ "border:none;" 
        		+ "padding:10px 20px;'>");
        out.println("</form>");
        
      
        out.println("<form action='' method='post' style ='max-width: 400px;\r\n"
        		+"width:500px;\r\n"
        		+ "    padding: 10px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 5px;\r\n"
        		+ "    background-color: #f9f9f9;'>");
        
        	
        	 if ("false".equals(request.getParameter("error"))) {
        		 
        		 out.println("<h2 style='color:red;text-align:center;'>Incorrect Information!</h2>");
             	
             }else if("true".equals(request.getParameter("error"))){
            	 
            	 out.println("<h2 style='color:blue;text-align:center'>Password changed successfully!</h2>");
            	 
             }

        
        out.print("<input type='hidden' name='action' value='change-password'>");
        out.println("<h3 style='text-align:center'>Modifier Votre Code</h3>");
        out.println("<label for='input1' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Old password</label>");
        out.println("<input type='text' id='input1' name='oldPassword' required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");
        
        out.println("<label for='input1' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>New password</label>");
        out.println("<input type='text' id='input1' name='newPassword' required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");
        out.println("<label for='input1' style='display: block;\r\n"
        		+ "    margin-bottom: 8px;\r\n"
        		+ "    color: #555;'>Confirm Password</label>");
        out.println("<input type='text' id='input1' name='confirmPassword' required style=' width: calc(100% - 16px);\r\n"
        		+ "height:35px;"
        		+"font-size:20px;"
        		+ "    padding: 8px;\r\n"
        		+ "    margin-bottom: 16px;\r\n"
        		+ "    border: 1px solid #ccc;\r\n"
        		+ "    border-radius: 4px;'><br>");
        
        out.println("<input type='submit' value='Modifier' style='background-color: #4caf50;\r\n"
        		+ "color: #fff;\r\n"
        		+ "cursor: pointer;"
        		+ "width:50%;"
        		+ "border:none;"
        		+ "padding:10px 20px;'>");
        out.println("</form>");
        
        out.print("</div>");


     
        out.println("</body>");
        out.println("</html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user from the session
        User user = (User) request.getSession().getAttribute("user");
        
        String action = request.getParameter("action");
        
        if ("change-password".equals(action)) {
        // Check if the user is not null
        if (user != null) {
            // Get the old password, new password, and confirmed password from the request parameters
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");

            // Validate the input values
            if (oldPassword != null && newPassword != null && confirmPassword != null
                    && !oldPassword.isEmpty() && !newPassword.isEmpty() && !confirmPassword.isEmpty()
                    && newPassword.equals(confirmPassword)) {
                // Check if the old password matches the user's current password
                if (user.getPassword().equals(oldPassword)) {
                    // Update the user's password with the new password
                    user.setPassword(newPassword);

                    response.sendRedirect("home?error=true");
                    
                } else {
                	
                	 response.sendRedirect("home?error=false");
                }
            } else {
            	
            	response.sendRedirect("home?error=false");
            }
        } 
        else {
            // User is not logged in, redirect to the login page
        	
            response.sendRedirect("login");
        }
    }
        else if ("post-info".equals(action)) {
  
        	String[] inputFields = {"nomS", "montantP", "dateS", "nomP", "clientName", "montant", "dateR"};

        	// Iterate over the input fields
        	
        	    for (String fieldName : inputFields) {
        	    // Retrieve the value of each input field from request parameters
        	    String value = request.getParameter(fieldName);
        	    
        	    String  uniqueKey=fieldName+count;
        	    
        	    // Add the value to formDataMap with the unique key
        	    formDataMap.put(uniqueKey, value);
        	}
        	count+=1;
             
        	response.sendRedirect("home?success=true");
            }
    }

   
}
