package demo.apiv1.exception;

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
