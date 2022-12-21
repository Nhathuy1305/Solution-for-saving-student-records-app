/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pdm;

/**
 *
 * @author user
 */
public class Student {

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }
    
    
    
    private  Student() {
        //pass
    }
    
    public static Student getInstance()
    {
        if(instance == null)
        {
            instance= new Student();
        }
        return instance;
    }
    

    private static Student instance= null ;
    private String studentID;
    private String studentName;
    private String gender;
    private String dob;
}
