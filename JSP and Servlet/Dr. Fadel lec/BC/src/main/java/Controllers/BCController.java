package Controllers;

import Services.BCServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BusninessCard;

@WebServlet(name = "BCController", urlPatterns = {"/C"}, loadOnStartup = 1)
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
        if (cmd == null) {
            cmd = "RBCA";
        }

        if (cmd.equals("RBCA")) {
            request.setAttribute("bcv", BCServices.read());
            this.getServletContext().getRequestDispatcher("/RBCA.jsp").forward(request, response);
        }
        if (cmd.equals("RBC")) {
            //get para
            int id = Integer.parseInt(request.getParameter("id"));

            //call the method read()
            BusninessCard bc = BCServices.read(id);
            request.setAttribute("bc", bc);
            this.getServletContext().getRequestDispatcher("/BCR.jsp").forward(request, response);

        }
        if (cmd.equals("BCC")){
            //call the method read()
            BusninessCard bc = BCServices.create(request.getParameter("name"), request.getParameter("tel"));
            
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
            String tel = request.getParameter("tel");
            
            //call the method delete(id)
            boolean b  = BCServices.update(new BusninessCard(id, name, tel));
            
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
