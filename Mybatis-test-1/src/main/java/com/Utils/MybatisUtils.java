package com.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
public class MybatisUtils {
    //声明SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {//获取sqlsessionfactory对象
            String resource = "mybatis-config.xml";//SQL连接配置文件的位置
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    // 你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlsession(){
     return sqlSessionFactory.openSession();
    }
}

