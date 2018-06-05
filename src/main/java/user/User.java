package user;

public class User {
    private String username = "昵称";
    private String password = "密码";
    private String passwordSure = "确认密码";
    private String email = "邮箱";
    private boolean isTrue = false;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPasswordSure(String passwordSure) {
        this.passwordSure = passwordSure;
    }

    public String getPasswordSure() {
        return passwordSure;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public User(){}

}
