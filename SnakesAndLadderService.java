package SnakesAndLadder;

import java.util.*;

public class SnakesAndLadderService {
	private Board board;
	private Queue<Player> players;
	
	private static final int BOARD_SIZE=100;
	
	
	public SnakesAndLadderService()
	{
		board=new Board(BOARD_SIZE);
		players=new LinkedList<>();
	}
	
	public void setPlayers(List<Player> players)
	{
		Map<String,Integer> playerPosition=new HashMap<>();
		
		for(Player itr:players)
		{
			this.players.add(itr);
			playerPosition.put(itr.getId(),0);
		}
		
		board.setPlayerPosition(playerPosition);
	}
	
	public void setLadders(List<Ladders> ladders)
	{
		board.setLadders(ladders);
	}
	
	public void setSnakes(List<Snakes> snakes)
	{
		board.setSnakes(snakes);
	}
	
	private int movePlayer(Player currPlayer)
	{
		int currPosition=board.getPlayerPosition().get(currPlayer.getId());
		int diceRoll=DiceService.roll();
		
		int newPosition=currPosition+diceRoll;
		
		if(newPosition>board.getSize())
			return currPosition;
		
		int finalPosition=newPosition;
		while(true)
		{
			for(Snakes itr:board.getSnakes())
			{
				if(finalPosition==itr.getStart())
					finalPosition=itr.getEnd();
			}
			
			for(Ladders itr:board.getLadders())
			{
				if(finalPosition==itr.getStart())
					finalPosition=itr.getEnd();
			}
			
			if(finalPosition==newPosition)
				break;
			
			newPosition=finalPosition;
		}
		
		System.out.println(currPlayer.getName()+" rolled a "+diceRoll+" and moved from "+currPosition+" to position "+finalPosition);
		
		board.getPlayerPosition().put(currPlayer.getId(), finalPosition);
		
		return finalPosition;
	}
	
	public void startGame()
	{
		while(true)
		{
			Player currentPlayer=players.remove();
			int positionAfterRoll=movePlayer(currentPlayer);
			
			if(positionAfterRoll==board.getSize())
			{
				System.out.println(currentPlayer.getName()+ " has won!");
				return;
			}
			
			players.add(currentPlayer);
		}
	}
}
