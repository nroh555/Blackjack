# Blackjack

Created a AI based Blackjack game whereby there will be 4 players. The players are yourself, 2 AI bots and a dealer. I implemented the different strategies for the dealer and the AI bots using the Strategy and Factory design patterns in Java. 

The two AI bots have three different strategies. 

• Random - The Bot randomly chooses the action HOLD and HIT and it randomly bets between 1 and 100 chips
(inclusive). 

• LowRisk - It “holds"" if the current hand has a score of at least 17, “hits” otherwise. It bets from 10 to 50
chips (inclusive).

• HighRisk - It “holds"" if the current hand has a score of at least 19, “hits” otherwise. It bets from 50 to 100
chips (inclusive)

The dealer then has two different strategies.

• Target the Highest Bidder - The Dealer wants to win the player with the highest bet.

• Target the Top Winner - The Dealer wants to win the player that has the most net wins after every round.

I then performed unit testing  by writing test cases using JUnit testing framework. Below are some images for one round of the game as output to the console. 

![image](https://github.com/nroh555/Blackjack/assets/100507962/a96d2ecc-a1f4-4933-9e68-4e8e8d990c99)
![image](https://github.com/nroh555/Blackjack/assets/100507962/25e9690b-26d0-4fb8-9e25-f5382e6bbea8)
![image](https://github.com/nroh555/Blackjack/assets/100507962/261b1652-9d5e-44d3-b5d4-e4de4badd320)



