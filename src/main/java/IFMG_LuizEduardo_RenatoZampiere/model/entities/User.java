package IFMG_LuizEduardo_RenatoZampiere.model.entities;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.enums.UserType;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;


@Entity
@Table(name = "user_table")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;
    private String phone;
    private String realName;
    private String address;
    private String addressNumber;
    private String district;
    private UserType userType;
    private LocalDate registrationDate; //  yyyy-MM-dd

    public User(){
        this.registrationDate = LocalDate.now();
    }

    public User(UserDTO dto){
        this.userName = dto.getUserName();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.realName = dto.getRealName();
        this.address = dto.getAddress();
        this.addressNumber = dto.getAddressNumber();
        this.district = dto.getDistrict();
        this.userType = dto.getUserType();
        this.registrationDate = LocalDate.now();
    }

    public User(Long id, String userName, String password, String email, String phone, String realName, String address,
                String addressNumber, String district, UserType userType, LocalDate registrationDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.realName = realName;
        this.address = address;
        this.addressNumber = addressNumber;
        this.district = district;
        this.userType = userType;
        this.registrationDate = registrationDate;
        this.registrationDate = LocalDate.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }



    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", address='" + address + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", district='" + district + '\'' +
                ", userType=" + userType +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
