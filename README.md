# Problem Statement

Create a snake and ladder application.

The application should take as input:

- Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.

- Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.

- Number of players (p) followed by p lines each containing a name.

After taking these inputs, you should print all the moves in the form of the current player name followed by a random number between 1 to 6 denoting the die roll and the initial and final position based on the move.
Format: <player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>

When someone wins the game, print that the player won the game.
Format: <player_name> wins the game

# My Solution

## Models

The entities that are involved in the design are:

- Snakes
- Ladders
- Board
- Players
- Dice

### 1) Snakes
To store the start and end position of snakes.

int start;

int end;

### 2) Ladders
To store the start and end position of snakes.

int start;

int end;

### 3) Player
To store the name and id of players;

String name;

String id;


### 4) Board
Contains the position of snakes and ladders, and the position of players on the board.

List<Snakes> snakes;
  
List<Ladders> ladders;
  
Map<String,Integer> playerPosition;


## Services


Now I have all the models I need to play a game. To replicate the process of playing a game, I created to services which will be used to talk to the models and to each other.

- DiceServie
- SnakesAndLadderService

### 1) DiceService
Generates a random integer number between 1 and 6.

### 2) SnakesAndLadderService
It be the orchestrator of the entire game.

- Now I have the board with snakes and ladders on it, and initial position of players set as 0.
- I have used a queue to iterate through the players.
- When a player rolls a dice, that position is checked for snakes and ladders, and the final position of player is calculated.
- This process is continued until a player wins.


