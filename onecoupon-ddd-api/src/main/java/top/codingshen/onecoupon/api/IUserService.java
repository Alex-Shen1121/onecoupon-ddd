package top.codingshen.onecoupon.api;

import top.codingshen.onecoupon.api.response.Response;

/**
 * @ClassName IUserService
 * @Description IUserService
 * @Author alex_shen
 * @Date 2024/10/20 - 02:22
 */
public interface IUserService {
    Response<Void> getUserCount();
}
