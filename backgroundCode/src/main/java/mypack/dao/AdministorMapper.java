package mypack.dao;

import mypack.pojo.Administor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdministorMapper {
    @Select("select * from administor where id=#{id} and password=#{password}")
    Administor findWithIdAndPassword(@Param("id") int id, @Param("password") String password);

}
