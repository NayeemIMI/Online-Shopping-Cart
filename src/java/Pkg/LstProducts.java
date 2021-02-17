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

public class LstProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {        
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head>"); 
        out.println("<title>Items Selection</title>"); 
        out.println("</head>"); 
        out.println("<body bgcolor='green'>");        
        out.println("<h1 align='center'>Select product(s) to buy</h1>");        
        out.println("<br><form method=post>"); 
        out.println("<br><input type=checkbox " + "name=item value= \"Laptop\">Laptop"); 
        out.println("<br><input type=checkbox " + "name=item value=\"Desktop\">Desktop"); 
        out.println("<br><input type=checkbox " + "name=item value= \"Mobile\">Mobile"); 
        out.println("<br><input type=checkbox " + "name=item value=\"Charger\">Charger");
        out.println("<br><input type=checkbox " + "name=item value=\"Monitor\">Monitor");
        out.println("<br><input type=checkbox " + "name=item value=\"Mouse\">Mouse");
        out.println("<br><input type=checkbox " + "name=item value=\"Keyboard\">Keyboard");
        out.println("<br><input type=checkbox " + "name=item value=\"Printer\">Printer");
        out.println("<br>");
        out.println("<br>");
        out.println("<br><input type=submit style='color:red;background-color:yellow' value=\"Add to Cart\">"); 
        out.println("</form>");         
        out.println("</body>"); 
        out.println("</html>"); 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {        
        HttpSession session = request.getSession(true);
        String UserInput[] = request.getParameterValues("item");
        int len = 0;
        try{
            len = UserInput.length;
            ArrayList<String> products = new ArrayList<String>();
            for(int i=0;i<len;i++){
                products.add(UserInput[i]);
            }
            session.setAttribute("UserInput", products);
            Cookie cki[] = request.getCookies();
            if(request.getCookies() == null || cki.length == 0){
                response.sendRedirect("SignIn");
            }
            else{
                response.sendRedirect("OrderInfo");
            }
        }
        catch(NullPointerException n){
            response.sendRedirect("Vacant");
        }        
    }
}