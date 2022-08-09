package cn.qingyandark.mapper;

import cn.qingyandark.pojo.Area;
import cn.qingyandark.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface AreaMapper {
    List<Area> selectProvince();

    List<Area> selectCity(@Mapper int provinceCode);
}
