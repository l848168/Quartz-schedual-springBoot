package com.zjs.del.config.mybatis;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 
 * @author LIWH
 * @date 2018年06月13日下午15:54:01
 */
@Configuration
@MapperScan(basePackages = {"com.zjs.del.mapper"})
public class MybatisConfig {

	/**
	 * 创建数据源
	 * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisConfig.class);
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Interceptor[] list={pageHelper(dataSource)};
		sessionFactory.setPlugins(list);
		return sessionFactory.getObject();
	}

	/**
	 * 分页插件
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PageHelper pageHelper(DataSource dataSource) {
		LOGGER.info("注册MyBatis分页插件PageHelper");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("pageSizeZero","true");
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
