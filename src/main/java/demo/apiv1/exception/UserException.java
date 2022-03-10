package demo.apiv1.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *  1. UserException 테스트하기
 */
@Slf4j
public class UserException extends Exception {
    private final int ERR_CODE;

    public UserException(String msg, int errorCode){
        super(msg);
        ERR_CODE=errorCode;
        log.warn("MESSAGE = {}", msg);
        log.warn("ERR_CODE = {}", ERR_CODE);
    }

    public int getErrCode(){
        return ERR_CODE;
    }
}
