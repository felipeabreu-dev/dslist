package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true) //Indica para o Spring que esse método deve seguir os padrões de uma Transação e parâmetro readOnly indica que não utilizaremos esse método para escrever
	public List<GameMinDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		
		return list.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
		Game game = gameRepository.findById(id).get();
		
		return new GameDTO(game);
	}
	
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}
}
