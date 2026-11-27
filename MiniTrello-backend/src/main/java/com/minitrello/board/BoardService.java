package com.minitrello.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository repository;


    @Transactional(readOnly = true)
    public List<BoardResponse> findAll(  ){
        return  repository.findAllByOrderByCreatedAtDesc().stream().map(BoardResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public BoardResponse findById( Long id ) throws BoardNotFoundException{
        return BoardResponse.from( repository.findById( id).orElseThrow( () -> new BoardNotFoundException(id)) );
    }

    public BoardResponse create(BoardRequest request){
        Board board = new Board();
        board.setName(request.name());
        board.setDescription(request.description());
        board = repository.save(board);

        return BoardResponse.from(board);
    }

    public BoardResponse update(Long id, BoardRequest request) {
        Board board = repository.findById( id).orElseThrow( () -> new BoardNotFoundException(id));
        board.setName(request.name());
        board.setDescription(request.description());

        return BoardResponse.from(board);
    }

    public void delete(Long id){
        repository.delete(repository.findById( id).orElseThrow( () -> new BoardNotFoundException(id)));
    }
}
