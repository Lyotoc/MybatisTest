package com.dao;

import com.Utils.MybatisUtils;
import com.pojo.user;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        final  SqlSession sqlsession = MybatisUtils.getSqlsession();//获取sqlsession对象
        usermapper usermapper =sqlsession.getMapper(usermapper.class);//获取通过sql语句得到的mapper对象
        List<user> userList = usermapper.getUserList();//获取user对象
        for (user user:userList) {
            System.out.println(user);
        }
        sqlsession.close();
    }
}
