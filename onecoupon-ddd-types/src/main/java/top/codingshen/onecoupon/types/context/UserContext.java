package top.codingshen.onecoupon.types.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @ClassName UserContext
 * @Description 用户上下文
 * @Author alex_shen
 * @Date 2024/10/19 - 19:49
 */
public class UserContext {

    private static final ThreadLocal<UserInfoDTO> USER_THREAD_LOCAL = new TransmittableThreadLocal<>();

    /**
     * 设置当前线程的用户信息。
     *
     * @param user 用户信息对象，包含用户的各种信息。
     */
    public static void set(UserInfoDTO user) {
        USER_THREAD_LOCAL.set(user);
    }

    /**
     * 获取当前线程绑定的用户ID。
     *
     * @return 返回当前线程绑定的用户ID，如果当前线程没有绑定用户信息，则返回null。
     */
    public static String getUserId() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return userInfoDTO.getUserId();
    }

    /**
     * 获取当前线程绑定的用户名。
     *
     * @return 返回当前线程绑定的用户名，如果当前线程没有绑定用户信息，则返回null。
     */
    public static String getUserName() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return userInfoDTO.getUserName();
    }

    /**
     * 获取当前线程的租户ID
     *
     * @return 返回当前线程的租户ID，类型为Long
     */
    public static Long getTenantId() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return userInfoDTO.getTenantId();
    }

    /**
     * 移除当前线程的线程局部变量中的用户信息
     */
    public static void remove() {
        USER_THREAD_LOCAL.remove();
    }

}
