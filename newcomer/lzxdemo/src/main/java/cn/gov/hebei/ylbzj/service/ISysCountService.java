package cn.gov.hebei.ylbzj.service;

/**
 *
 * @author liuzx
 */
public interface ISysCountService
{
    /**
     * 更新计数
     *
     */
    public void updateCount(long count);

    /**
     * 访问计数
     *
     */
    public int selectCount();


}