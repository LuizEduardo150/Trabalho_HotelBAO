package IFMG_LuizEduardo_RenatoZampiere.dtos;

public class ClientDTO {
    private String phone;
    private String name;
    private String passWord;
    private String userName;

    public ClientDTO() {}

    public ClientDTO(String phone, String name, String passWord, String userName) {
        this.phone = phone;
        this.name = name;
        this.passWord = passWord;
        this.userName = userName;
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

    @Override
    public String toString() {
        return "ClientDTO{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
