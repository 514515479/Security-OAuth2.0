package securityOAuth.entity;

import lombok.Data;

/**
 * @Author: tobi
 * @Date: 2020/7/14 0:40
 **/
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
