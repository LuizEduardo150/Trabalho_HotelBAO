package IFMG_LuizEduardo_RenatoZampiere.dtos;


import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;

public class UserDTO{
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String realName;
    private String address;
    private String addressNumber;
    private String district;

    public UserDTO(){}

    public UserDTO(String userName, String password, String email, String phone, String realName, String address,
                String addressNumber, String district) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.realName = realName;
        this.address = address;
        this.addressNumber = addressNumber;
        this.district = district;
    }

    public UserDTO(User user){
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.realName = user.getRealName();
        this.address = user.getAddress();
        this.addressNumber = user.getAddressNumber();
        this.district = user.getDistrict();
    }


    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
