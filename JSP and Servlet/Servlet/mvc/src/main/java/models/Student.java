
package models;

public class Student {
   private String fname;
   private String lname;
   private String email;

    public Student(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
}
