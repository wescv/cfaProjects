package myGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.beans.EventHandler;

public class Game {

    SpaceShip spaceShip = new SpaceShip();
    Destroyables[] destroyables = new Destroyables[20];
    MyKeyBoard kb = new MyKeyBoard(spaceShip);

    public void init() {
        Rectangle backGround = new Rectangle(0, 0, 1000, 200);
        backGround.draw();
        createDestroyables();
        spaceShip.getRectangle().draw();
        //spaceShip.fire();
        kb.handler();
    }

    private void createDestroyables() {
        int i = 0;
        while (i < 20) {
            destroyables[i] = new Destroyables();
            destroyables[i].getRectangle().draw();
            i++;
        }
    }
}
