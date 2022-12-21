/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pdm;
import java.sql.*;

/**
 *
 * @author user
 */
public class SqlQuery {
    
    public static String getURl()
    {
        return "jdbc:sqlserver://localhost:1433;databaseName= test_database;user=duy;password=duy03032002;Encrypt=false";
    }
    
    
    public  ResultSet getUnenrolledResultSet() throws SQLException, SQLException
    {
        String unenrolledQuery = String.format("select * from course\n" +
                                                "except\n" +
                                                "Select c.courseID, c.courseName, c.classroom, c.teacher, c.credit\n" +
                                                "From Student as s\n" +
                                                "INNER JOIN\n" +
                                                "Enrolled as e ON s.studentID = e.studentID\n" +
                                                "INNER JOIN\n" +
                                                "Course as c ON c.courseID = e.courseID\n" +
                                                "where s.studentID = '%s'", Student.getInstance().getStudentID());
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(unenrolledQuery);
    }

    public ResultSet getEnrolledResultSet() throws SQLException, SQLException, SQLException {
        String EnrolledQuery = String.format("Select c.courseID, c.courseName, c.classroom, c.teacher, c.credit\n" +
                                            "From Student as s\n" +
                                            "INNER JOIN\n" +
                                            "Enrolled as e ON s.studentID = e.studentID\n" +
                                            "INNER JOIN\n" +
                                            "Course as c ON c.courseID = e.courseID\n" +
                                            "where s.studentID = '%s'", Student.getInstance().getStudentID());
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(EnrolledQuery);
    }
    public ResultSet getMajorResultSet() throws SQLException, SQLException
    {
        String query= String.format("Select curriculum.majorName, curriculum.curriculumID\n" +
                                    "From Student\n" +
                                    "INNER JOIN\n" +
                                    "study  ON study.studentID = student.studentID\n" +
                                    "INNER JOIN\n" +
                                    "curriculum ON study.curriculumID = curriculum.curriculumID\n" +
                                    "where student.studentID = '%s';", Student.getInstance().getStudentID());
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(query);
    }
    public ResultSet getGradeResultset() throws  SQLException
    {
        String query= String.format("select enrolled.courseID, course.courseName, enrolled.[process score], enrolled.[midterm score], enrolled.[final score]\n" +
                                    "from student \n" +
                                    "inner join\n" +
                                    "enrolled on student.studentID = enrolled.studentID\n" +
                                    "inner join\n" +
                                    "course on course.courseID= enrolled.courseID\n" +
                                    "where student.studentID = '%s';", Student.getInstance().getStudentID());
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(query);
    }
    
    public ResultSet getCourseResultSet() throws SQLException 
    {
        String query= String.format("select * from course");
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(query);
    }
    
    
    
   
    public ResultSet getAccountResultSet() throws SQLException
    {
        String accountQuery= "select * from student;";
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(accountQuery);
    }
    public ResultSet getScholardshipResultSet() throws SQLException
    {
        String query= String.format("select Scholarship.scholarshipID, Scholarship.scholarshipName, Scholarship.description\n" +
                                    "from student \n" +
                                    "inner join\n" +
                                    "has on student.studentID = has.studentID\n" +
                                    "inner join\n" +
                                    "Scholarship on has.scholardshipID = Scholarship.scholarshipID\n" +
                                    "where student.studentID = '%s';", Student.getInstance().getStudentID());
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(query); 
    }
    public void addCourse(String StudentID, String CourseID) throws SQLException
    {
        String query= String.format("insert into enrolled values  ('%s', '%s', null, null, null);", StudentID, CourseID);
        Statement stmt = getConnection().createStatement();
        stmt.execute(query);

    }
    
    public void deleteCourse(String StudentID, String CourseID) throws SQLException
    {
        String query= String.format("delete from enrolled where studentID = '%s' and courseID = '%s';", StudentID, CourseID);
        Statement stmt = getConnection().createStatement();
        stmt.execute(query);
    }
    
    public ResultSet getSscholardsgipResultSet() throws SQLException
    {
        String query= String.format("select * from scholarship, has where scholarship.ScholarshipId= has.scholardshipID;");
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(query); 
    }

    public static Connection getConnection()
    {
        try {
            Connection connection = DriverManager.getConnection(getURl());
            System.out.println("successful");
            return connection;
        }
        catch (SQLException e) {
            System.out.println("error here");
            throw new RuntimeException(e);
        }
    }
}

