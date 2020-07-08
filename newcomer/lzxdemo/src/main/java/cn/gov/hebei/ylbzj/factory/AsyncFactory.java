package cn.gov.hebei.ylbzj.factory;

import cn.gov.hebei.ylbzj.constant.Constants;
import cn.gov.hebei.ylbzj.domain.SysLogininfor;
import cn.gov.hebei.ylbzj.domain.SysOperLog;
import cn.gov.hebei.ylbzj.service.ISysOperLogService;
import cn.gov.hebei.ylbzj.service.impl.SysLogininforServiceImpl;
import cn.gov.hebei.ylbzj.util.IpUtils;
import cn.gov.hebei.ylbzj.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;
import java.util.concurrent.atomic.LongAdder;

public class AsyncFactory
{
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    LongAdder count = new LongAdder();

    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status 状态
     * @param message 消息
     * @param args 列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message, final Object... args)
    {
       // final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getHostIp();

        //SpringUtils.getBean(SysLogininforServiceImpl.class).insertLogininfor(new SysLogininfor());
        return new TimerTask()
        {
            @Override
            public void run()
            {
                String address=ip;

                String os ="windows";
                // 获取客户端浏览器
                String browser ="goole";
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setLoginName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                logininfor.setStatus(Constants.SUCCESS);
                // 插入数据
                SpringUtils.getBean(SysLogininforServiceImpl.class).insertLogininfor(logininfor);
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                // 远程查询操作地点
                operLog.setOperLocation("");
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }

    /*public static TimerTask selectCountLogininfo(){
        return new TimerTask()
        {
            @Override
            public void run()
            {


                int count = SpringUtils.getBean(SysLogininforServiceImpl.class).selectLogininforCount();
            }
        };
    }*/






}