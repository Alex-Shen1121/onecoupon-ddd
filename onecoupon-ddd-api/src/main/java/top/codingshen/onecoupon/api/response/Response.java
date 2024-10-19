package top.codingshen.onecoupon.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 7000723935764546321L;

    private String code;
    private String info;
    private T data;

    /**
     * 正确返回码
     */
    public static final String SUCCESS_CODE = "0";

    /**
     * 正确返回信息
     */
    public static final String SUCCESS_INFO = "调用成功";

    /**
     * 默认错误返回码
     */
    public static final String FAIL_CODE = "-1";

    /**
     * 默认错误返回信息
     */
    public static final String FAIL_INFO = "未知异常";

    /**
     * 构造带返回数据的成功响应
     */
    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .code(SUCCESS_CODE)
                .info(SUCCESS_INFO)
                .data(data)
                .build();
    }


    /**
     * 构造成功响应
     */
    public static Response<Void> success() {
        return new Response<Void>();
    }

    /**
     * 构建服务端失败响应
     */
    public static Response<Void> failure() {
        return Response.<Void>builder()
                .code(FAIL_CODE)
                .info(FAIL_INFO)
                .build();
    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     */
    public static Response<Void> failure(String errorCode, String errorMessage) {
        return Response.<Void>builder()
                .code(errorCode)
                .info(errorMessage)
                .build();
    }
}
