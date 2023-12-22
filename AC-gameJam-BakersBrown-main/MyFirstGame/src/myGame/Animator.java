package myGame;


/*
    So basically I created a new Thread just to animate the spaceship shot,
    the thread responsible to draw things on canvas and listen to keyboard events
    was getting stuck on executing the spaceship.shot(), therefore it was "listening to keyboard events",
    instead of drawing things on canvas, so I created a new Thread just to animate the shot.
    Go check your keyboard handler to see how I made the new Thread start running.
 */
public class Animator implements Runnable{

    private SpaceShip ship;

    public Animator(SpaceShip spaceShip) {
        ship = spaceShip;
    }

    public void animateSpaceShip() {
        ship.fire();
    }

    @Override
    public void run() {
        animateSpaceShip();
    }
}
