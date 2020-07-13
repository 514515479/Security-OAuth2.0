package securityOAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import securityOAuth.entity.PermissionDto;
import securityOAuth.entity.UserDto;
import securityOAuth.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tobi
 * @Date: 2020/7/13 19:34
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //将来连接数据库根据账号查询用户信息
        UserDto userDto = userMapper.getUserByUsername(username);
        if(userDto == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<PermissionDto> permissions = userMapper.findPermissionsByUserId(userDto.getId());
        List<String> str = new ArrayList<>();
        permissions.forEach(x -> str.add(x.getCode()));
        //将permissions转成数组
        String[] permissionArray = new String[str.size()];
        str.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }

    //public static void main(String[] args) {
    //    System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
        //$2a$10$VMhDOW4QgxpdQgtcTGly2ew.SPjkv9OulcJ4b7qId11QCA9cgnV9i
    //}
}
