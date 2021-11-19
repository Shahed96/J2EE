package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
     
if (request.getParameter("submit")!= null){
    //get the data:
String name=request.getParameter("sname");
String course=request.getParameter("course");
String feeS =request.getParameter("fee");

   Connection con =MyConnection.getConnection();
  /* PreparedStatement ps;
 ps =con.prepareStatement("INSERT INTO `recored`( `stname`, `course`, `fee`) VALUES (?,?,?)");
   ps.setString(1, name);
   ps.setString(2,course );
   double feed =Double.valueOf(feeS);
   ps.setDouble(3,feed);
   
   ps.executeUpdate();*/



}
   
 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"POST\" action=\"#\">\n");
      out.write("            <div class=\"form-group \">\n");
      out.write("                <label for=\"ex1\">Student Name:<input type=\"text\" id=\"ex1\" name=\"sname\" placeholder=\"name\" class=\"form-control\">\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group \">\n");
      out.write("                <label for=\"ex2\">Course:\n");
      out.write("                    <input type=\"text\" id=\"ex2\" name=\"course\" placeholder=\"course\" class=\"form-control\">\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group \">\n");
      out.write("                <label for=\"ex3\">Fee:\n");
      out.write("                    <input type=\"text\" id=\"ex2\" placeholder=\"fee\"  name=\"fee\" class=\"form-control\">\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"\">\n");
      out.write("                <button class=\"btn btn-default btn-info\" name=\"submit\">submit</button>\n");
      out.write("                <button class=\"btn btn-default btn-warning\" name=\"reset\">Reset</button>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("             <div class=\"panel-body col-sm-8\">\n");
      out.write("                 <table id=\"tbl-student\" class=\"table table-responsive table-bordered\" cellpadding=\"0\" width=\"100%\">\n");
      out.write("                 <thead>\n");
      out.write("                 <tr>\n");
      out.write("                     <th>Student</th>\n");
      out.write("                     <th>Course</th>\n");
      out.write("                     <th>Fee</th>\n");
      out.write("                     <th>Edit</th>\n");
      out.write("                     <th>Delete</th>\n");
      out.write("                 </tr>\n");
      out.write("                 </thead>\n");
      out.write("                 \n");
      out.write("                  <tr>\n");
      out.write("                     <td> </td>\n");
      out.write("                      <td> </td>\n");
      out.write("                       <td> </td>\n");
      out.write("                        <td> </td>\n");
      out.write("                         <td> </td>\n");
      out.write("                 </tr>\n");
      out.write("                 \n");
      out.write("                 \n");
      out.write("             </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
