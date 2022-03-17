package com.shang.demo.pojoConvertTest;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    String userName;
    String phone;
    List<String> roles;

    public static UserDTO convertToUserDTO(User item) {
        if (item == null) {
            return null;
        }
        UserDTO result = new UserDTO();
        result.setUserName(item.getUserName());
        result.setPhone(item.getPhone());
        return result;
    }
}
