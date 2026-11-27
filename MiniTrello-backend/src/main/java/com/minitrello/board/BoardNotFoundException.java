package com.minitrello.board;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException(Long id) {

        super("Id " + id + " cannot be found" );
    }
}
