/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pdm;

/**
 *
 * @author user
 */
public class User {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        //pass
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean getAdmin()
    {
        return admin;
    }
    public void setadmin(boolean e)
    {
        admin=e;
    }
    
    public static User getInstance()
    {
        if(instance == null)
        {
            instance= new User();
        }
        return instance;           
    }
         
    private static User instance= null;
    private String username;
    private boolean admin=false;
    private String password;
}
