# ldts-project-assignment-g0102

Our game will consist of a version of the famous 80’s game “Space Invaders”, with our own spin on it. The player will control a tiny ship fighting against big aliens to save the planet Earth from being conquered. To succeed the player must clear the rows of aliens in 5 different stages, where the aliens will become stronger with each iteration.

## Gameplay Demo

![ldts -Animated Image (Small)](https://user-images.githubusercontent.com/38360936/150397236-15317323-be3e-4f9f-966e-ffc20a0658ea.gif)

![Screenshot from 2022-01-20 12-44-18](https://user-images.githubusercontent.com/79020867/150419296-67580af2-33e7-4281-8740-d99461822cd2.png) ![Screenshot from 2022-01-20 12-42-57](https://user-images.githubusercontent.com/79020867/150419072-23875cd9-d4ed-4d0e-a655-9d5accab32b9.png)

## Implemented Features

### Ship

* **Character Movement** – The ship will move using the left and right arrows to go to the desired place. If an arrow is pressed continuously the ship will move faster to that direction. Collisions are implemented for the ship to remain bounded to the screen and not disappear.


* **Health** – The game will have the player starting with three lives, on every hit taken by the player, he will lose one life, when it reaches zero the game will conclude with a loss. If the player levels up after clearing a stage, and had taken any damage, he will regain 1 life.


* **Shotting** – To win the game, the ship will need to kill all the Aliens, with a bullet that will be shot by pressing the Spacebar. The bullet will be shot upwards from the ship’s position and will rise until it either hits an Alien or hits the top of the screen.


### Alien

* **Mob Movement** – In the beginning of every level the Aliens will start in the top left corner and will all move in sync to the rightmost boundary, then they will move down a position and go to the leftmost one, making this pattern until there are no more aliens or they reach the bottom of the screen, or the player loses all his lives.


* **Proximity detector** – In order to keep the Aliens on the screen a method was added to know if the alien is close to the boundary’s or not.


* **Shotting** – To make it a fair challenge, the first level will start with the group of aliens only being able to have three bullets at the same time and from level to level it will increment by two bullets. The positions from where the bullets can be fired will be randomized throughout the remaining aliens so that when there are only a few lefts there will most likely be a barrage of bullets making it a little harder for the player to win.


### Bullet

* **Movement** – For the bullet to rise a method was implemented that will increment the position of the bullet on its y axis every refresh, the same was made for the aliens to be able to shoot back at the player, but in reverse, where the position of the bullet will be decremented on its y axis.


### Wall

* **Wall** – There are two walls displayed during gameplay, one at the top and one at the bottom, the one at the bottom works as a scoring range for the aliens, if during the game they are able to reach it, a game over will ensue. The wall at the top works as a dead zone for the players bullets, upon contacting the wall they will be cleared out of the game.


### Information

* **Stats** – The information for the score, player health, level, number of bullets for both the player and the aliens are stored here. If the player takes damage, his health will be updated here, same goes for every other stat when their flags for update are triggered by a call. For the amount of bullets (player and aliens) and for the player to regain health back, a level up is required. The drawing on the game board of all stats is also dictated here, except for the amount of bullets for the alien, which don’t have any visible indication besides the actual amount of bullets being fired by the them.


### Position

* **Global positioning** – The constructor for positioning all elements on the board is stored here.


## Planed features

### Sound

* **Sound** – Auditory feedback of the player shooting bullets and when getting damaged, a jingle when the game starts and when the player either wins or loses will also be implemented. There are also plans to have a song playing in the background during the main gameplay loop.


### Other

* **Barriers** – Barriers for the player to hide behind in order to dodge incoming attacks, the amount of barriers would decrease with subsequent level ups.


* **Retry** – Implementation of a retry feature is planned, this would work if either the player won or lost, taking him back to the main gameplay loop.


## Design

### Architectural Pattern

To run our game, we decided to implement the MVC (Model-View-Controller) design pattern, with the following divisions.
* **Model (data)** – Stores all the different components of every class in use.
* **View (gui)** – Handles the graphical interface that represents the game.
* **Controller (controller)** – Receives input from the user and processes all the changes that occur from it.

Our game has a MVC module for:
* MainMenu
* MenuBoard
* MenuLoss
* MenuWin

By using this design pattern, we were able to achieve the following, high cohesion, low coupling amongst models, views or controllers and ease of modification.

### Game mode

Our game flows linearly between the MainMenu and MenuBoard (and consequent viewers) then depending on the result you are either taken to the MenuWin or MenuLoss.
Unfortunately, we couldn’t implement a retry functionality from the MenuLoss due to complications with the threads to make the game run all by itself without input.

### Graphics

We had some difficulties when drawing the sprites, since we had to divide the aliens in four, having us make sure the size of all the elements checked out. After wards, when enabling the new made fonts for all the elements we wanted, the game would draw every other font that we hadn’t tampered with as a white rectangle, this was fixed by merging our font with the Square font and remaking all the sprites again.

### Input 

Depending on the game state, different keyboard inputs were required, so for each Menu and its varying states we implemented their own controls, making it easier to add new actions to different stages.

### Code Smells and Refactoring

When using BetterCodeHub to analyze our code, we receive two code smells that can’t realistically be modified. The first one involves separate concerns in modules, because our class position receives a lot more than 10 incoming calls, since almost all the classes in the package data use the position class to know where they are placed at any one point. The second smell involves all our code being developed in the same component src, we don’t really recognize it as an actual smell since its inside the main component, and we have all our code separated throughout different packages.

### Testing

While testing our code we consulted the professor of the Labs and concluded that we didn’t need to test graphical parts of the code since it was lanterna’s job to make sure it worked. We tested every single data class and our Board to make sure everything was working in the code. 


## Self evaluation

up202006059 Diogo Almeida - 33%
up202005954 Carlos Souza - 34%
up201506449 Rafael Morgado - 33%


## UML diagram

![Uml_Diagram](https://user-images.githubusercontent.com/38360936/150384992-9f92a4bb-2221-435f-9d6e-286b53b9850c.png)
