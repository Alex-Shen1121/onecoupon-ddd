package top.codingshen.onecoupon.interceptor;

import cn.hutool.core.lang.UUID;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName LoggingInterceptor
 * @Description LoggingInterceptor
 * @Author alex_shen
 * @Date 2024/10/20 - 03:54
 */
@Slf4j
@Configuration
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String traceId = UUID.randomUUID().toString();
        MDC.put("trace-id", traceId);

        long startTime = System.currentTimeMillis();
        log.info("请求URI: {}", request.getRequestURI());
        log.info("请求类型: {}", request.getMethod());
        // 你可以根据需要记录更多的请求信息，如请求头、请求参数等

        response.addHeader("X-Trace-Id", traceId);
        request.setAttribute("startTime", startTime); // 将开始时间存储在请求属性中以便后面使用
        return true; // 继续处理请求
    }

    @Override
    public void postHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;
        log.info("响应时间：{} ms", duration);
    }
}
