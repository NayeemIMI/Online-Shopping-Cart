package Pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.Object;
import javax.servlet.RequestDispatcher;

public class OrderInfo extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {       
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();  
        HttpSession session=request.getSession(false); 
        ArrayList<String> Orders = new ArrayList<String>();
        try{
            Orders=(ArrayList<String>) session.getAttribute("UserInput");
        }
        catch(NullPointerException e){
            response.sendRedirect("Vacant");
        }
        out.println("<html>"); 
        out.println("<head>"); 
        out.println("<title>Order Information</title>"); 
        out.println("</head>");
        out.print("<body bgcolor='green'>");
        out.print("<h1 align='center'>You have ");out.print(Orders.size());       
        out.print(" item(s) in your cart.</h1>");
        out.println("<h2>Your selected items are:</h2>");
        for (String i : Orders){
            out.print("<ul><li>"+i+"</li></ul>");
        }
        out.println("<br><form method=post>"); 
        out.println("<br><div><input type=submit " + "name=Update value=Update></div>"); 
        out.println("<br><div><input type=submit " + "name=ChackOut value=\"Check Out\"></div>"); 
        out.println("<br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(request.getParameter("Update") != null){
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter();
        out.print("<HTML><HEAD></HEAD><BODY>");
        out.print("<script>window.history.go(-2)</script>");
        out.println("</BODY>");
        out.println("</HTML>");
        }
            else
        { 
            HttpSession session = request.getSession(false);
            ArrayList<String> Orders=(ArrayList<String>) session.getAttribute("UserInput");
            session.invalidate();
            PrintWriter out = response.getWriter();
            out.println("<html><body bgcolor='green'><h1 align='center'>Payment Successful!</h1>");
            out.print("<h2>You have purchased "+ Orders.size()+" item(s). Cart is empty now.<h2>");
            out.println("<form action=\"index.html\"><br><input type=submit " + "name=\"SignOut\" value=\"SignOut\"></form></body></html>"); 
            out.print("<form action=\"OrderInfo\"><input type=submit " + "name=\"VC\" value=\"View Cart\"></form>");
        }
    }
}