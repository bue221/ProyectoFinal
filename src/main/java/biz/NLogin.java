package biz;

public class NLogin {

    private String user;
    private String password;
    private String realUser="demo";
    private String realPassword="12345";
    
    public NLogin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean comprobar() {
        if(this.user == this.realUser && this.password == this.realPassword){
            return true;
        }else{
            return false;
        }
    }
}
