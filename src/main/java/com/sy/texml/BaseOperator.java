package com.sy.texml;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseOperator {
	protected static SqlSessionFactory ssf;
	protected static Reader reader;
	static
	{
		try {
			reader = Resources.getResourceAsReader("mybatis.cfg.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
