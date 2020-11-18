package biz;

public class NLogin {

    private String user;

    private String password;

    public NLogin(String user, String password) {
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
       if(user=="demo" && password=="12345"){
           return true;
       }
       return false;
    }
}
