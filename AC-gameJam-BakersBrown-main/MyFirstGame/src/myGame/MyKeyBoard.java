
package myGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyBoard implements KeyboardHandler {

    SpaceShip spaceShip;
    Keyboard kb = new Keyboard(this);


    public MyKeyBoard(SpaceShip spaceShip){
        this.spaceShip = spaceShip;
    }
    public void handler() {
        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT -> spaceShip.getRectangle().translate(10, 0);
            case KeyboardEvent.KEY_LEFT -> spaceShip.getRectangle().translate(-10, 0);
            case KeyboardEvent.KEY_SPACE -> {
                Thread thread = new Thread(new Animator(spaceShip));
                thread.start();
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
