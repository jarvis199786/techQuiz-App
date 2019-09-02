/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

/**
 *
 * @author asus
 */
public class UserPojo {
    private String userid;
    private String password;
    private String usertype;

    public UserPojo(String userid, String password, String usertype) {
        this.userid = userid;
        this.password = password;
        this.usertype = usertype;
    }
    public UserPojo(){
    
        
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
    
}
