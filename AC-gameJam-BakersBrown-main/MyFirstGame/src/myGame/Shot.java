package myGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Shot {

    private Rectangle rectangle;

    public Shot(int x, int y){
        this.rectangle = new Rectangle(x, y,5,5);
        rectangle.draw();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
