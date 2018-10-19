package com.dylan.common.exception;

/****
 * 403授权失败
 */
public class ServerDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServerDeniedException() {
    }

    public ServerDeniedException(String message) {
        super(message);
    }

    public ServerDeniedException(Throwable cause) {
        super(cause);
    }

    public ServerDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
