package IFMG_LuizEduardo_RenatoZampiere.dtos;

public class UserBasicDataDTO {

    private Long id;
    private String userName;
    private String email;
    private String realName;
    private String auth;


    // SELECT id, email, real_name, user_name, user_type FROM public.user_table
    public UserBasicDataDTO(Long id, String email, String real_name, String user_name, String user_type) {
        this.id = id;
        this.userName = user_name;
        this.email = email;
        this.realName = real_name;
        this.auth = user_type;
    }

    public UserBasicDataDTO(UserBasicDataDTO dto){
        this.id = dto.getId();
        this.userName = dto.getUserName();
        this.email = dto.getEmail();
        this.realName = dto.getRealName();
        this.auth = dto.getAuth();
    }

    public UserBasicDataDTO() {}

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
