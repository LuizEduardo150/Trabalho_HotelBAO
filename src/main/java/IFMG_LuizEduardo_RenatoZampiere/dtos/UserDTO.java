
package IFMG_LuizEduardo_RenatoZampiere.dtos;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.model.enums.UserType;

public class UserDTO {
    private String userName;
    private String realName;
    private UserType userType;

    public UserDTO(){}

    public UserDTO(String userName, String password, String email, String phone, String realName, String address, String addressNumber, String district, UserType userType) {
        this.userName = userName;
        this.realName = realName;
        this.userType = userType;
    }

    public UserDTO(User user){
        this.userName = user.getUsername();
        this.realName = user.getRealName();
        this.userType = user.getUserType();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", userType=" + userType.getValue() +
                '}';
    }
}
