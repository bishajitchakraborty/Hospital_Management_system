
package hms;

public class securitysystem {
    private String username;
    private String password;
    private String confarmpassword;
    private String usertype;
    private String gender;
    private String age;
    private String phone_num;

    public securitysystem(String username, String password, String confarmpassword, String usertype, String gender, String age, String phone_num) {
        this.username = username;
        this.password = password;
        this.confarmpassword = confarmpassword;
        this.usertype = usertype;
        this.gender = gender;
        this.age = age;
        this.phone_num = phone_num;
    }

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

    public String getConfarmpassword() {
        return confarmpassword;
    }

    public void setConfarmpassword(String confarmpassword) {
        this.confarmpassword = confarmpassword;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
    
    
}
