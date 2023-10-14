package com.mycompany.web.student.tracker.controllers;

import com.mycompany.web.student.tracker.model.Student;
import com.mycompany.web.student.tracker.services.StudentDBServices;
import exceptions.StudentNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "StudentServlet", urlPatterns = {"/Students"})
public class StudentServlet extends HttpServlet {

    private StudentDBServices studentDBServices;

    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        //Create StudentDBServices and pass in the conn pool
        studentDBServices = new StudentDBServices(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.log(request.getRemoteAddr() + "  " + request.getQueryString());
        try {

            //read cmd 
            String theCommand = request.getParameter("command");

            //if the command is missing, then the default is listing 
            if (theCommand == null) {
                theCommand = "LIST";
            }

            //rout to the appropriate method
            switch (theCommand) {
                case "LIST":
                    //List the student in MVC fashion
                    listStudents(request, response);
                    break;

                case "ADD":

                    addStudent(request, response);

                    break;

                case "LOAD":
                    loadStudent(request, response);
                    break;

                case "UPDATE":
                    updateStudent(request, response);
                    break;

                case "DELETE":
                    deleteStudent(request, response);
                    break;

                default:
                    listStudents(request, response);

            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.print(request.getRemoteAddr() +""+ request.getQueryString());
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        // Get the students from db services
        List<Student> students = studentDBServices.getStudents();

        //Add students to the request object
        request.setAttribute("students_list", students);

        //send to JSP 
        this.getServletContext().getRequestDispatcher("/students.jsp").forward(request, response);

    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, StudentNotFoundException, Exception {
        // read student info from form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        // create a new student object (constructor without id)
        Student theStudent = new Student(firstName, lastName, email);
        // add the student to the database (call add method in the services)
        studentDBServices.addStudent(theStudent);
        // send back to main page (the student list)
        listStudents(request, response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        // read student id from form data
        String theStudentId = request.getParameter("id");

        // get student from database (db util)
        Student theStudent = studentDBServices.getStudent(theStudentId);

        // place student in the request attribute
        request.setAttribute("THE_STUDENT", theStudent);

        // send to jsp page: update-student-form.jsp
        this.getServletContext().getRequestDispatcher("/update-student-form.jsp").forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        // read student info from form data, and convert it to its appropriate type
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create a new student object
        Student theStudent = new Student(id, firstName, lastName, email);

        // perform update on database
        studentDBServices.updateStudent(theStudent);

        // send them back to the "list students" page
        listStudents(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        // read student id from form data
        String id = request.getParameter("id");

        // delete student from database
        studentDBServices.deleteStudent(id);

        // send them back to "list students" page
        listStudents(request, response);
    }

}
