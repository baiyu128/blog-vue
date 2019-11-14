package cn.baiyu.tumoserver;

import cn.baiyu.common.utils.PasswordHelper;
import cn.baiyu.system.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordHelperTest {

    @Autowired
    private PasswordHelper passwordHelper;

    @Test
    public void encryptPassword() {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setUsername("baiyu");
        sysUser.setPassword("123456");
        sysUser.setSalt("536a51359841754df6bbab57d24d2128");
        passwordHelper.encryptPassword(sysUser);
        System.out.println(sysUser.getPassword()); // c0daa18ce0c74153ce060325cb4d1a04
    }
}