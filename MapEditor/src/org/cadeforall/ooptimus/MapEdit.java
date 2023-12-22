package org.cadeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapEdit {

    private Rectangle pen;
    private Rectangle rectangle;
    private MyKeyBoard myKeyBoard;

    public MapEdit(MyKeyBoard myKeyBoard){
        this.myKeyBoard = myKeyBoard;
        layout();
    }

    public void layout() {
        int v = 30;
        int v1 = 30;
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < v1; ++j) {

                this.rectangle = new Rectangle(v * i, v1 * j, 30, 30);
                rectangle.draw();
            }

        }
        pen();

    }

    public void pen() {
        this.pen = new Rectangle(0, 0, 30, 30);
        pen.setColor(Color.BLACK);
        pen.fill();

    }

    public Rectangle getPen() {
        return pen;
    }
}


