package com.devsuperior.dslist.dto;

import java.util.Objects;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {
	Long id;
	String name;
	
	public GameListDTO() {
	}

	public GameListDTO(GameList gameList) {
		this.id = gameList.getId();
		this.name = gameList.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameListDTO other = (GameListDTO) obj;
		return Objects.equals(id, other.id);
	}
}
