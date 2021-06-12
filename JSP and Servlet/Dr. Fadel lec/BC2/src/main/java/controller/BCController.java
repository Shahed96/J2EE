
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BC;
import services.BCServices;


@WebServlet(name = "BCController", urlPatterns = {"/BC"}, loadOnStartup = 1)
public class BCController extends HttpServlet {
    
     public static String path = "";
     
     @Override
    public void init() {

       path = this.getServletContext().getRealPath("");

        try {
            BCServices.loadFile();
        } catch (IOException ex) {
            Logger.getLogger(BCController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    
    
    
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        
        //set the first page (jsp) to view 
         if (cmd == null) {
            cmd = "RBCA";
        }
         
         if (cmd.equals("RBCA")) {
            request.setAttribute("bcv", BCServices.read());
            
            this.getServletContext().getRequestDispatcher("/RBCA.jsp").forward(request, response);
        }
        
         
          if (cmd.equals("BCR")) {
            //get para
            int id = Integer.parseInt(request.getParameter("id"));

            //call the method read(). and fill the trail
            request.setAttribute("bc", BCServices.read(id));
            this.getServletContext().getRequestDispatcher("/BCR.jsp").forward(request, response);

        }
          
          if (cmd.equals("BCC")){
            //call the method create()
            BC bc = BCServices.create(request.getParameter("name"), request.getParameter("tel"));
            
            request.setAttribute("bcv", BCServices.read());
            this.getServletContext().getRequestDispatcher("/RBCA.jsp").forward(request, response);
        
        }
           if (cmd.equals("BCD")){
            //get para
            int id = Integer.parseInt(request.getParameter("id"));
            //call the method delete(id)
            boolean b  = BCServices.delete(id);
            
            request.setAttribute("bcv", BCServices.read());
            this.getServletContext().getRequestDispatcher("/RBCA.jsp").forward(request, response);
        
        }
           if (cmd.equals("BCU")){
            //get para
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String tel = request.getParameter("telphone");
            
            //call the method delete(id)
            boolean b  = BCServices.update(new BC(id, name, tel));
            
            //Back to the main page 
            request.setAttribute("bcv", BCServices.read());
            this.getServletContext().getRequestDispatcher("/RBCA.jsp").forward(request, response);
        
        }
        
        if (cmd.equals("BCS")){
            
            BCServices.save();
            
            //Back to the main page 
            request.setAttribute("bcv", BCServices.read());
            this.getServletContext().getRequestDispatcher("/RBCA.jsp").forward(request, response);
        
        }
        
        
        
        
        
        
        
        
        
        
      
      
    }

    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
