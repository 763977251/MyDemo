package com.shang.demo;

import com.shang.demo.pojoConvertTest.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author liwenyan
 * @Description: TODO
 */
public class MapKeyIsNullTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put(null, null);
        map.put(null,"c");
        System.out.println(map);

        List<UserDTO> list = new ArrayList<>();
        list.add(UserDTO.builder().userName(null).phone("1").build());
        list.add(UserDTO.builder().userName("1").phone("2").build());
        list.add(UserDTO.builder().userName("1").phone("3").build());
        list.add(UserDTO.builder().userName(null).phone("4").build());

        HashMap<String, List<UserDTO>> collect = list.stream().collect(Collectors.groupingBy(UserDTO::getUserName, HashMap::new, Collectors.toList()));
        System.out.println(collect);
    }
}
