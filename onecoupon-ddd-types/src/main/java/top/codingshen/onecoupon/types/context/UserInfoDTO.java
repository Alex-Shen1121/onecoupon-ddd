package top.codingshen.onecoupon.types.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserInfoDTO
 * @Description 登入用户信息
 * @Author alex_shen
 * @Date 2024/10/19 - 19:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    /**
     * 用户 ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 商户 ID
     */
    private Long tenantId;
}
