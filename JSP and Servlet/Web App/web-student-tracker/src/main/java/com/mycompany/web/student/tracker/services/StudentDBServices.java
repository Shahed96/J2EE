package com.mycompany.web.student.tracker.services;

import com.mycompany.web.student.tracker.model.Student;
import exceptions.StudentNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class StudentDBServices {

    private DataSource dataSource;

    public StudentDBServices(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

//get a connection 
        con = dataSource.getConnection();
//create sql statment
        String sql = "select * from student order by first_name";
        st = con.createStatement();
//excute query
        rs = st.executeQuery(sql);
//process the result 
        while (rs.next()) {
//retrieve the data from rs row   
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            //create new student object
            Student tepmStudent = new Student(id, firstName, lastName, email);
            // Add it to the list 
            students.add(tepmStudent);

        }
        close(con, st, rs);
        return students;

    }

    public void addStudent(Student theStudent) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        // get db connection
        myConn = dataSource.getConnection();

        // create sql for insert
        String sql = "insert into student "
                + "(first_name, last_name, email) "
                + "values (?, ?, ?)";

        myStmt = myConn.prepareStatement(sql);

        // set the param values for the student
        myStmt.setString(1, theStudent.getFirstName());
        myStmt.setString(2, theStudent.getLastName());
        myStmt.setString(3, theStudent.getEmail());

        // execute sql insert
        myStmt.execute();

        // clean up JDBC objects
        close(myConn, myStmt);

    }

    public Student getStudent(String theStudentId) throws SQLException, Exception {
        Student theStudent = null;

        Connection myConn = null;
        PreparedStatement myStmt = null; //we wait a parameter
        ResultSet myRs = null;

        int studentId;

        // convert student id to int
        studentId = Integer.parseInt(theStudentId);

        // get connection to database
        myConn = dataSource.getConnection();

        // create sql to get selected student
        String sql = "select * from student where id=?";

        // create prepared statement
        myStmt = myConn.prepareStatement(sql);

        // set params
        myStmt.setInt(1, studentId);

        // execute statement
        myRs = myStmt.executeQuery();

        // retrieve data from result set row
        if (myRs.next()) {
            String firstName = myRs.getString("first_name");
            String lastName = myRs.getString("last_name");
            String email = myRs.getString("email");

            // use the studentId during construction
            theStudent = new Student(studentId, firstName, lastName, email);
        } else {
            throw new StudentNotFoundException("Could not find student id: " + studentId);
        }
        // clean up JDBC objects
        close(myConn, myStmt, myRs);

        return theStudent;

    }

    private void close(Connection con, Statement st, ResultSet rs) throws SQLException {
        con.close();
        st.close();
        rs.close();
    }

    private void close(Connection con, Statement st) throws SQLException {
        con.close();
        st.close();
    }

    public void updateStudent(Student theStudent) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        // get db connection
        myConn = dataSource.getConnection();

        // create SQL update statement
        String sql = "update student "
                + "set first_name=?, last_name=?, email=? "
                + "where id=?";

        // prepare statement
        myStmt = myConn.prepareStatement(sql);

        // set params
        myStmt.setString(1, theStudent.getFirstName());
        myStmt.setString(2, theStudent.getLastName());
        myStmt.setString(3, theStudent.getEmail());
        myStmt.setInt(4, theStudent.getId());

        // execute SQL statement
        myStmt.execute();

        // clean up JDBC objects
        close(myConn, myStmt);

    }

    public void deleteStudent(String theStudentId) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        // convert student id to int
        int studentId = Integer.parseInt(theStudentId);

        // get connection to database
        myConn = dataSource.getConnection();

        // create sql to delete student
        String sql = "delete from student where id=?";

        // prepare statement
        myStmt = myConn.prepareStatement(sql);

        // set params
        myStmt.setInt(1, studentId);

        // execute sql statement
        myStmt.execute();

        // clean up JDBC code
        close(myConn, myStmt);

    }

}
