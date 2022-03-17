package com.shang.demo.pojoConvertTest;

import lombok.Data;

@Data
public class User {
    String userName;
    String phone;

    public static User convertToUser(UserDTO item) {
        if (item == null) {
            return null;
        }
        User result = new User();
        result.setUserName(item.getUserName());
        result.setPhone(item.getPhone());
        return result;
    }
}
