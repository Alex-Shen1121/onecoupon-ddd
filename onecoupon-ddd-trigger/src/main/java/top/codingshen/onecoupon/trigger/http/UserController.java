package top.codingshen.onecoupon.trigger.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.codingshen.onecoupon.api.IUserService;
import top.codingshen.onecoupon.api.response.Response;
import top.codingshen.onecoupon.types.context.UserContext;

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
    public Response<Void> getUserCount() {
        log.info(UserContext.getUserId());
        return null;
    }
}
