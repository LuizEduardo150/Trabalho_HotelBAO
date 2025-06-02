package IFMG_LuizEduardo_RenatoZampiere.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {

    GUEST("guest"),
    CLIENT("client"),
    ADMIN("admin");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static UserType fromValue(String value){

        for (UserType type : UserType.values()){
            if (type.getValue().equals(value)){
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid user Type: " + value);
    }

}
