package MyPackage;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
        
       double param1 = Double.valueOf(request.getParameter("parameter1"));    
       double param2 = Double.valueOf(request.getParameter("parameter2"));
       int operation = Integer.valueOf(request.getParameter("operation"));
       double result = 0;
       String error = "";
       
       switch(operation)
       {
           case 0: 
               result = param1+param2;  break;
           case 1: 
               result = param1-param2;  break;
           case 2: 
               result = param1*param2;  break;
           case 3:
               result = param1/param2;  break;
           case 4: 
               result = param1*param2/100;  break;
           case 5: 
               result = Math.pow(param1,param2);   break;
           default:
               error = "Error in operation code!";
       }
       
       if(Double.isInfinite(result) || Double.isNaN(result))
       {
            error = "Error! Value is NAN/is infinite";
       }
       
       if (error.compareTo("")==0) 
       { 
           response.getWriter().write(new Gson().toJson(result));
       }
       else 
       { 
           response.getWriter().write(new Gson().toJson(error));
       }         
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          processRequest(request, response);      
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
