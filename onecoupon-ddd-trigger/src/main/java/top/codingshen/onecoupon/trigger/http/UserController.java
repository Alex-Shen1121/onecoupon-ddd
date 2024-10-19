package top.codingshen.onecoupon.trigger.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.codingshen.onecoupon.api.IUserService;
import top.codingshen.onecoupon.api.response.Response;
import top.codingshen.onecoupon.types.context.UserContext;
import top.codingshen.onecoupon.types.exception.AbstractException;
import top.codingshen.onecoupon.types.exception.ClientException;

/**
 * @ClassName UserController
 * @Description UserController
 * @Author alex_shen
 * @Date 2024/10/20 - 02:23
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController implements IUserService {
    @GetMapping("/user")
    @Override
    public Response<Integer> getUserCount() {
        log.info(UserContext.getUserId());
        return Response.success(1);
    }

    @GetMapping("/user2")
    @Override
    public Response<Integer> getUserCount2() {
        try {
            int i = 1 / 0;
            return Response.success(1);
        } catch (AbstractException e) {
            throw new ClientException("客户端错误");
        }

    }
}
