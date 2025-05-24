package IFMG_LuizEduardo_RenatoZampiere.entities;

public class Client {

    private String phone;
    private String name;
    private String passWord;
    private String userName;
    private Long id;

    public Client(){}

    public Client(String phone, String name, String userName, String passWord) {
        this.phone = phone;
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                '}';
    }
}
