
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Fruit;
import services.FruitServices;

/**
 *
 * @author DELL
 */
@WebServlet(name = "FruitController", urlPatterns = {"/FC"})
public class FruitController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public static String path = "";

    @Override
    public void init() {

        path = this.getServletContext().getRealPath("");

        try {
            
            FruitServices.loadFile();
        } catch (IOException ex) {
            Logger.getLogger(FruitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession ses =request.getSession();
        if (ses.isNew()){
        ArrayList<Fruit> As = new ArrayList<>();
        ses.setAttribute("se", As);
        
        }
        String cmd = request.getParameter("cmd");
        if (cmd == null) {
            cmd = "RFA";
        }
        
        if (cmd.equals("RFA")) {
            request.setAttribute("FL", FruitServices.read());
            this.getServletContext().getRequestDispatcher("/RFA.jsp").forward(request, response);
        }
        
        if (cmd.equals("FRO")) {
            String id =request.getParameter("id");
            request.setAttribute("F", FruitServices.read(id));
            this.getServletContext().getRequestDispatcher("/RFO.jsp").forward(request, response);
        }
         if (cmd.equals("FAS")) {
            String id =request.getParameter("id");
            Fruit read = FruitServices.read(id);
            
            ArrayList <Fruit> As2  =(ArrayList <Fruit>) ses.getAttribute("se");
            As2.add(read);
            
            //view on RFA.jsp
            request.setAttribute("FL", FruitServices.read());
            this.getServletContext().getRequestDispatcher("/RFA.jsp").forward(request, response);
           
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
