package myGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.geom.RectangularShape;

public class Destroyables {

    private Color color = Color.CYAN;
    private Rectangle rectangle;

    public Destroyables(){
        int x = (int)(20 + Math.random() * 940);
        int y = (int)(20 + Math.random() * 30);
        this.rectangle = new Rectangle(x ,y ,5,10);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
