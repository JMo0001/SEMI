package kh.semi.common.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			session = factory.openSession(autoCommit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
