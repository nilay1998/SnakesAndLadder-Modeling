package SnakesAndLadder;

import java.util.*;

public class Board 
{
	private int size;
	private List<Snakes> snakes;
	private List<Ladders> ladders;
	private Map<String,Integer> playerPosition;
	
	public Board(int size)
	{
		this.size=size;
		snakes=new ArrayList<>();
		ladders=new ArrayList<>();
		playerPosition=new HashMap<>();
	}
	
	public int getSize() {
		return size;
	}
	
	public void setPlayerPosition(Map<String,Integer> playerPosition) {
		this.playerPosition=playerPosition;
	}
	
	public Map<String,Integer> getPlayerPosition(){
		return playerPosition;
	}
	
	public void setSnakes(List<Snakes> snakes) {
		this.snakes=snakes;
	}
	
	public void setLadders(List<Ladders> ladders) {
		this.ladders=ladders;
	}
	
	public List<Snakes> getSnakes(){
		return snakes;
	}
	
	public List<Ladders> getLadders(){
		return ladders;
	}
}
