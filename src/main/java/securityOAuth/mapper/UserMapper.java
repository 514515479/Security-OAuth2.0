package securityOAuth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import securityOAuth.entity.UserDto;

/**
 * @Author: tobi
 * @Date: 2020/7/13 19:38
 **/
@Mapper
public interface UserMapper {
    @Select("select id, username, password, fullname, mobile from t_user")
    UserDto getUserByUsername(String username);


}
