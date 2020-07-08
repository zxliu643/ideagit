package cn.gov.hebei.ylbzj;


import cn.gov.hebei.ylbzj.domain.SysLogininfor;
import cn.gov.hebei.ylbzj.dao.SysLogininforMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysLogininforMapperTests {


    @Autowired
    private SysLogininforMapper logininforMapper;

    @Test
    public void insertTest(){

        logininforMapper.insertLogininfor(new SysLogininfor());
    }

}
