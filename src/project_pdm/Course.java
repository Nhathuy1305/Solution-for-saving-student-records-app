/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pdm;

/**
 *
 * @author user
 */
public class Course {

    public Course(String courseID, String courseName, String classroom, int credit, String teacher) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.classroom = classroom;
        this.credit = credit;
        this.teacher = teacher;
    }
    public Course()
    {
        //pass
    }
    
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String toString()
    {
        return String.format("%s %s %s %s %d", getCourseID(), getCourseName(), getClass(), getTeacher(), getCredit());
   
    }
    

    
    private String courseID;
    private String courseName;
    private String classroom;
    private String teacher;
    private int credit;

}
