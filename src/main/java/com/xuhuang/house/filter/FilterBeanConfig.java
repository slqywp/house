package com.xuhuang.house.filter;

import com.google.common.collect.Lists;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterBeanConfig
{
    @Bean
    public FilterRegistrationBean logFilter()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new LogFilter());
        bean.setUrlPatterns(Lists.newArrayList("*"));
        return bean;
    }

}
