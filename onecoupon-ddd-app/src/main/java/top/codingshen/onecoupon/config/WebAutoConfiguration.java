package top.codingshen.onecoupon.config;

import org.springframework.context.annotation.Bean;
import top.codingshen.onecoupon.handler.GlobalExceptionHandler;

public class WebAutoConfiguration {

    /**
     * 构建全局异常拦截器组件 Bean
     */
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
