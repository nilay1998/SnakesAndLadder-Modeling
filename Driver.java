package SnakesAndLadder;

import java.util.*;

public class Driver 
{
	public static void main(String args[])
	{
		SnakesAndLadderService service=new SnakesAndLadderService();
		
		List<Player> players=new ArrayList<>();
		List<Snakes> snakes=new ArrayList<>();
		List<Ladders> ladders=new ArrayList<>();
		
		service.setPlayers(players);
		service.setLadders(ladders);
		service.setSnakes(snakes);
		
		service.startGame();
	}
}
