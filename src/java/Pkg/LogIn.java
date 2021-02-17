package Pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogIn extends HttpServlet {
    
    private void sendLoginForm(HttpServletResponse response, 
    boolean error) 
    throws ServletException, IOException  { 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head>"); 
        out.println("<title>Sign In</title>"); 
        out.println("</head>"); 
        out.println("<body bgcolor='green'>"); 
        if (error) 
        out.println("<h1 style=\"color:red;\" align='center'>Sign In failed. Please try again.<h1><br>");
        out.println("<br><h1 style='margin-left:3%;color:red;'>Please Sign In before poceeding!<h1>");   
        out.println("<form method=post>"); 
        out.println("<ul style=\"list-style-type:none\"><li>UserName: <input type=text name=UserName></li>"); 
        out.println("<br><li style='margin-left:.4%'>Password: <input type=password name=Password></li>"); 
        out.println("<br><li style='margin-left:.1%'><input type=submit value=Sign In></li></ul>"); 
        out.println("</form>"); 
        out.println("</body>"); 
        out.println("</html>");
  }   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        sendLoginForm(response, false);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String UserName = request.getParameter("UserName"); 
        String Password = request.getParameter("Password"); 
        Cookie cki1 = new Cookie("userName", UserName);
        Cookie cki2 = new Cookie ("password", Password); 
        response.addCookie(cki1); 				
        response.addCookie(cki2); 
        if (UserName!=null && Password!=null && 
          UserName.equals("Nayeem") && Password.equals("Nishaat")) {
          response.sendRedirect("Products"); 
        } 
        else {
          sendLoginForm(response, true); 
        } 
    }
}