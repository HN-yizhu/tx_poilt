package com.poilt;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageHelper;

@SpringBootApplication
@MapperScan("com.poilt.mapper.*")
public class Application extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	public static void main(String[] args) {
		logger.info("springBoot 启动了");
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate;
    }
	
	/**
	 * 数据源
	 * @return
	 */
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
	
	/**
	 * 数据源session工厂
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource")DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mybatis/**/*Mapper.xml"));
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setCallSettersOnNulls(true);//空字段也返回,不然就会返回null
		bean.setConfiguration(configuration);
		// 分页插件
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        //<!-- 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 -->
        //<!-- 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 -->
        props.setProperty("reasonable", "false");//合理化
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
        // 添加插件
        bean.setPlugins(new Interceptor[] { pageHelper });
        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	/**
	 * 啊里druid数据源
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServlet(){
		ServletRegistrationBean druid = new ServletRegistrationBean();
		druid.setServlet(new StatViewServlet());
		druid.setUrlMappings(Arrays.asList("/druid/*"));
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("loginUsername", "admin");
		params.put("loginPassword", "admin");
		druid.setInitParameters(params);
		return druid;
	}

	@Bean
	public FilterRegistrationBean webStatFilter(){
		FilterRegistrationBean fitler = new FilterRegistrationBean();
		fitler.setFilter(new WebStatFilter());
		fitler.setUrlPatterns(Arrays.asList("/*"));
		fitler.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return fitler;
	}
}
