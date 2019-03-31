package pro.sunhao.bookstore.pojo;

public class UserBase {
    private Long userId;
    private String userUsername;
    private String userPassword;
    private String userPhone;
    private int userGender;
    private String userAddress1;
    private String userAddress2;
    private String userAddress3;

    public UserBase(Long userId, String userUsername, String userPassword, String userPhone, int userGender, String userAddress1, String userAddress2, String userAddress3) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.userAddress1 = userAddress1;
        this.userAddress2 = userAddress2;
        this.userAddress3 = userAddress3;
    }

    public UserBase(String username, String password, int gender, String phone) {
        this.userUsername = username;
        this.userPassword = password;
        this.userGender = gender;
        this.userPhone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress1() {
        return userAddress1;
    }

    public void setUserAddress1(String userAddress1) {
        this.userAddress1 = userAddress1;
    }

    public String getUserAddress2() {
        return userAddress2;
    }

    public void setUserAddress2(String userAddress2) {
        this.userAddress2 = userAddress2;
    }

    public String getUserAddress3() {
        return userAddress3;
    }

    public void setUserAddress3(String userAddress3) {
        this.userAddress3 = userAddress3;
    }
}
