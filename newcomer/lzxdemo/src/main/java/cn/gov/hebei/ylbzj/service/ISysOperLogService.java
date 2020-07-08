package cn.gov.hebei.ylbzj.service;

import cn.gov.hebei.ylbzj.domain.SysOperLog;

public interface ISysOperLogService
{
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);


}
