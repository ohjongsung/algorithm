package io.ohjongsung.algorithm.ctci.phase03.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-26
 * Description :
 */
public class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException() {
        super("Queue Underflow!!");
    }
}
