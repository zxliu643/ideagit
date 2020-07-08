package cn.gov.hebei.ylbzj.dao;

import cn.gov.hebei.ylbzj.domain.SysOperLog;

/**
 * 操作日志 数据层
 *
 */

public interface SysOperLogMapper
{
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

}
