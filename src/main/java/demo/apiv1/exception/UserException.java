package demo.apiv1.exception;

/**
 * TODO
 *  1. UserException 테스트하기
 */
public class UserException extends Exception {
    private final int ERR_CODE;

    public UserException(String msg, int errorCode){
        super(msg);
        ERR_CODE=errorCode;
    }

    public int getErrCode(){
        return ERR_CODE;
    }
}
