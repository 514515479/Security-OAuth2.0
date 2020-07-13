package securityOAuth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import securityOAuth.entity.PermissionDto;
import securityOAuth.entity.UserDto;

import java.util.List;

/**
 * @Author: tobi
 * @Date: 2020/7/13 19:38
 **/
@Mapper
public interface UserMapper {
    @Select("select id, username, password, fullname, mobile from t_user where username = #{username}")
    UserDto getUserByUsername(String username);

    @Select("SELECT * FROM t_permission p INNER JOIN t_role_permission rp ON p.id = rp.permission_id inner join t_user_role ur where ur.user_id = #{id}")
    List<PermissionDto>  findPermissionsByUserId(Long id);
}
