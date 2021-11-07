package com.shang.springsecuritydemo.security.config;

import com.shang.springsecuritydemo.security.filter.CustomizeUsernamePasswordAuthenticationFilter;
import com.shang.springsecuritydemo.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //登录成功处理逻辑
    @Autowired
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
    //登录失败处理逻辑
    @Autowired
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;
    //权限拒绝处理逻辑
    @Autowired
    CustomizeAccessDeniedHandler accessDeniedHandler;
    //匿名用户访问无权限资源时的异常
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    //会话失效(账号被挤下线)处理逻辑
    @Autowired
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    //登出成功处理逻辑
    @Autowired
    CustomizeLogoutSuccessHandler logoutSuccessHandler;
    //访问决策管理器
    @Autowired
    CustomizeAccessDecisionManager accessDecisionManager;
    //实现权限拦截
    @Autowired
    CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;
    @Autowired
    private CustomizeAbstractSecurityInterceptor securityInterceptor;
    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    /**
     * 密码加密方式
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义用户名密码鉴定，支持json格式传入的用户名密码
     * {@link WebSecurityConfig#configure(HttpSecurity)} 配置方法里用到这个bean
     * @throws Exception
     */
    @Bean
    CustomizeUsernamePasswordAuthenticationFilter customizeUsernamePasswordAuthenticationFilter() throws Exception {
        CustomizeUsernamePasswordAuthenticationFilter filter = new CustomizeUsernamePasswordAuthenticationFilter();
        // 登录成功以及登录失败的处理器由下面configure()方法里移动到这里，否则不生效（不生效原因是因为这个自定义的过滤器会先于默认的过滤器执行）
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    // 配置跨域访问资源
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");  //spring boot2.4.0版本之后使用这个配置
//        corsConfiguration.addAllowedOrigin("*");	//spring boot2.4.0版本之前使用这个   同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
        corsConfiguration.addAllowedMethod("*");	//允许的请求方法，PSOT、GET等
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
        return source;
    }

    /**
     * 配置自己系统实现的用户认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource()) // 配置跨域问题
                .and()
                .csrf().disable();
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                        return o;
                    }
                })
                //登出
                .and()
                    .logout()
                    .permitAll()//允许所有用户
                    .logoutSuccessHandler(logoutSuccessHandler)//登出成功处理逻辑
                    .deleteCookies("JSESSIONID")//登出之后删除cookie
                //登入
                .and()
                    .formLogin()
                    .permitAll()//允许所有用户
                    /** 下面配置了自定义的用户名密码校验，所以此处两个处理器不生效了 {@link WebSecurityConfig#customizeUsernamePasswordAuthenticationFilter()} */
//                    .successHandler(authenticationSuccessHandler)//登录成功处理逻辑
//                    .failureHandler(authenticationFailureHandler)//登录失败处理逻辑
                //异常处理(权限拒绝、登录失效等)
                .and()
                    .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler)//权限拒绝处理逻辑
                    .authenticationEntryPoint(authenticationEntryPoint)//匿名用户访问无权限资源时的异常处理
                //会话管理
                .and()
                    .sessionManagement()
                    .maximumSessions(1)//同一账号同时登录最大用户数
                    .expiredSessionStrategy(sessionInformationExpiredStrategy);//会话失效(账号被挤下线)处理逻辑
        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
        http.addFilterAt(customizeUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
