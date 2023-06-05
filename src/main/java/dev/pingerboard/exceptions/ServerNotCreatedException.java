package dev.pingerboard.exceptions;

/**
 * @author a.zharov
 */
public class ServerNotCreatedException extends RuntimeException{

    public ServerNotCreatedException(String msg) {
        super(msg);
    }
}
