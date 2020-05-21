Students participated:
Aidan Myers, Andrew Lykken, Ali Alhaddad


EXECUTION
To run the game, I could not get the .jar file to compile correctly, the GUI kept getting messed up because of system settings. Instead, the main method is in Runner.Main, just run that and you
should be fine, it worked for me.
Included in the root folder is monopoly.bat, which runs the script the same as it would in an IDE, but again, the GUI does not look correct, for reasons unknown.

The game itself is pretty self-explanatory if you have ever played the board game before. I hope you have, because I would rather not type out all of the rules in here, they're online somewhere
if you need them.

Oh, also, some errors may appear in the console, but that should only happen because you used the GUI in a way it was not intended, but these errors do not affect
the game's execution and the code will run fine regardless of them.




Since there is a LOT of code, it is just easier to tell you where each required and optional part shows up so you can find it easily.
Required Parts

Math Operations on Primitives - logi.Player, line 57.
Boolean Expressions - spaces.PropertySpace, line 111.
Conditionals (switch) - cards.CommunityChestCard, line 76.
Conditionals (if) - cards.TitleCard, line 88.
Loops - util.ChanceCardScenarios, line 204.
Classes, Objects - most of the classes are instantiated somewhere in the code, so I don't think an example is necessary.
Related to the classes and objects, methods and attributes, how to create them and use them - Again, this is in most classes, but take a look at logi.Player to find most things.
Assigning References - spaces.PropertySpace, line 36.
Abstraction - Only the important things are shown on screen while playing.
Polymorphism - ui.PlayerUI, method popUp. (lines 169, 181, 192).
Inheritance - Most classes inherit from the JPanel class to allow for GUI, but all of the classes in package spaces extend the abstract class Card.
Encapsulation - Many, many classes that are just poured into the main code, user doesn't have to worry about any of it.
Arrays - logi.Board, line 23.
ArrayLists - logi.Player, line 15.

Optional parts

Primitives - logi.Player, line 13.
Strings - logi.Player, line 12.
The key word, static - ui.PlayerUI, all over the place in that class.
Pass by Value & Object Reference, spaces.PropertySpace, line 31.
Overloaded methods - ui.PlayerUI, method popUp. (lines 169, 181, 192).