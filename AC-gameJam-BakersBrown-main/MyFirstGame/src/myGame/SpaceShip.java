package myGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SpaceShip {

    private Rectangle rectangle;

    public SpaceShip() {
        this.rectangle = new Rectangle(20, 180, 20, 5);
    }

    public void fire() {
        Shot shot = new Shot(this.rectangle.getX(), this.rectangle.getY());

        for (int y = shot.getRectangle().getY(); y > -10; y = y - 10) {
            //shot.getRectangle().delete();
            shot.getRectangle().translate(0, -10);
            //shot.getRectangle().draw();
            CustomSleep.customSleep(50);
        }
    }

//    public void translate(int y, Shot shot){
//        if(y <=0){
//            return;
//        }
//        y = y-10;
//        shot.getRectangle().translate(0,-10);
//        translate(y,shot);
//    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
