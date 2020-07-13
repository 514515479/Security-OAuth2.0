package securityOAuth.entity;

import lombok.Data;

/**
 * @Author: tobi
 * @Date: 2020/7/13 19:36
 **/
@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
