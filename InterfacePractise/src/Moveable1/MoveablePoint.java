package Moveable1;

public class MoveablePoint implements Moveable {
    private int x;  // x, y là tọa độ điểm
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MoveablePoint(int x, int y, int _xSpeed, int _ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = _xSpeed;
        this.ySpeed = _ySpeed;
    }

    @Override
    public void moveUp() {
        this.x += this.xSpeed;

    }

    @Override
    public void moveDown() {
        this.x -= this.xSpeed;
    }

    @Override
    public void moveLeft() {
        this.y -= this.ySpeed;
    }

    @Override
    public void moveRight() {
        this.y += this.ySpeed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}
