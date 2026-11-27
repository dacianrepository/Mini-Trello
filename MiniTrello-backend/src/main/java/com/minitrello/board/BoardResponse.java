package com.minitrello.board;

import java.time.Instant;

public record BoardResponse(Long id, String name, String description, Instant createdAt) {
    public static BoardResponse from(Board board){
        return new BoardResponse(board.getId(), board.getName(), board.getDescription(), board.getCreatedAt());
    }

}
