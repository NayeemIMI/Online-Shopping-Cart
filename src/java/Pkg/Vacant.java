package Pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Vacant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.print("<html><head><title>Vacant</title></head><body bgcolor='green'>");
        out.print("<h1 align='center'>Your Cart is empty. Please select item(s) to buy!</h1>");
        out.println("<br><form method=post>"); 
        out.println("<br><input type=submit style='color:red;background-color:yellow; margin-left: 45%'" + "name=Pur value=\"Purchase\">"); 
        out.println("<br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(request.getParameter("Pur") != null)
        {
          response.sendRedirect("Products");
        }
    }
}