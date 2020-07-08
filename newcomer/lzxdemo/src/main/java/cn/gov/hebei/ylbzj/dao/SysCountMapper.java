package cn.gov.hebei.ylbzj.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/**
 * 计数 数据层
 *
 */
@Repository
public interface SysCountMapper
{

    /**
     * 更新计数
     *
     */
    @Update("update sys_countinfo set sys_count = sys_count+#{count}")
    public void updateCount(long count);

    /**
     * 访问计数
     *
     */
    @Select("select sys_count from sys_countinfo")
    public int selectCount();

}