package top.codingshen.onecoupon.types.exception;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import top.codingshen.onecoupon.types.errorCode.IErrorCode;

import java.util.Optional;

/**
 * @ClassName AbstractException
 * @Description 异常抽象类
 * @Author alex_shen
 * @Date 2024/10/19 - 02:15
 */
@Getter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.isBlank(message) ? message : null).orElse(errorCode.message());
    }

}
