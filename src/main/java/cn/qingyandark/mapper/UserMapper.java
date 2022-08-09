package cn.qingyandark.mapper;

import cn.qingyandark.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectUserByUsername(@Mapper String username);
}
