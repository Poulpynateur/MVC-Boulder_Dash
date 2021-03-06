# MVC-Boulder_Dash

Copy of the Boulder dash game, made with Java (Swing and AWT).

![preview](https://github.com/Poulpynateur/MVC-Boulder_Dash/blob/master/preview.PNG)

## DONE

### Base

* MVC structure
* Class implementation
* Asset loading (sprites)
* Rendering

### Gameplay

* Map editor
* Movement and physic (including collision)
* Different objects behaviors

### Render

* Tile rendering : window is refresh at every update

## TODO

* Creating the missing game objects (exit, bomb, ...)
* Add game over
* Finish player animation
* Correct ROCK bugs

## TO IMPROVE

In addition to Swing/AWT (Java FX ?) and the MVC pattern that are constraints :
* Inputs management (improve fluidity)
* Model : actual objects are hard to maintain and are not scalable (*reduce class coupling, generalize, assure the separation of queries from updates*)
* Main loop
