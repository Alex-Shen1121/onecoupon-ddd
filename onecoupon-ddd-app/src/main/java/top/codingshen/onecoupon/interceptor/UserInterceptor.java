package top.codingshen.onecoupon.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.codingshen.onecoupon.types.context.UserContext;
import top.codingshen.onecoupon.types.context.UserInfoDTO;

/**
 * @ClassName UserInterceptor
 * @Description 用户配置类
 * @Author alex_shen
 * @Date 2024/10/19 - 19:59
 */
@Configuration
public class UserInterceptor implements WebMvcConfigurer {

    /**
     * 配置用户传输拦截器
     */
    @Bean
    public UserTransmitInterceptor userTransmitInterceptor() {
        return new UserTransmitInterceptor();
    }

    /**
     * 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userTransmitInterceptor())
                .addPathPatterns("/**");
    }

    static class UserTransmitInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, Object handler) throws Exception {
            UserInfoDTO userInfoDTO = new UserInfoDTO("100012345", "shency", 1000501L);
            UserContext.set(userInfoDTO);
            return true;
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            UserContext.remove();
        }
    }
}
