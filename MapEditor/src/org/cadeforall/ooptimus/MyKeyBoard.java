package org.cadeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;


public class MyKeyBoard implements KeyboardHandler {

    private Keyboard keyboard;
    private MapEdit layout;
    ArrayList<Rectangle> rectangleList = new ArrayList<>();



    public void handler() {

        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(clear);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(load);


    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT : layout.getPen().translate(30, 0);
            break;
            case KeyboardEvent.KEY_LEFT : layout.getPen().translate(-30, 0);
            break;
            case KeyboardEvent.KEY_UP : layout.getPen().translate(0, -30);
            break;
            case KeyboardEvent.KEY_DOWN : layout.getPen().translate(0, 30);
            break;
            case KeyboardEvent.KEY_SPACE : {

                Rectangle rectangle = new Rectangle(layout.getPen().getX(), layout.getPen().getY(), 30, 30);

                rectangle.setColor(Color.BLUE); rectangle.fill();

                if(rectangleList.contains(rectangle)) {
                    rectangleList.remove(rectangle);
                }else rectangleList.add(rectangle);


            }

            break;




        }

    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setLayout(MapEdit layout) {
        this.layout = layout;
    }


}




