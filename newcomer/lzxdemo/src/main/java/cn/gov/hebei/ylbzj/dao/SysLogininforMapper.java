package cn.gov.hebei.ylbzj.dao;

import cn.gov.hebei.ylbzj.domain.SysLogininfor;
import org.springframework.stereotype.Repository;


/**
 * 系统访问日志情况信息 数据层
 *
 */
@Repository
public interface SysLogininforMapper
{
    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */

   // @Insert("insert into sys_logininfor (login_name, status, ipaddr, login_location, browser, os, msg, login_time)values (#{loginName}, #{status}, #{ipaddr}, #{loginLocation}, #{browser}, #{os}, #{msg}, sysdate()) ")
    public void insertLogininfor(SysLogininfor logininfor);



    /**
     * 查询系统登录日志访问记录数
     *
     */

    //@Select("select count(1) from sys_logininfor")
    public int selectLogininforCount();

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     *//*
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    *//**
     * 批量删除系统登录日志
     *
     * @param ids 需要删除的数据
     * @return 结果
     *//*
    public int deleteLogininforByIds(String[] ids);

    *//**
     * 清空系统登录日志
     *
     * @return 结果
     *//*
    public int cleanLogininfor();*/
}