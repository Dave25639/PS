import mayflower.Actor;

public class NewParticle extends Actor {
    private int speedX;
    private int speedY;
    private int speedZ;
    private int lastX;
    private int lastY;
    private int tempX;
    private int tempY;
    private double distance;
    private double acceleration;
    private int accelTimer;
    private double angle;

    public NewParticle(double a) {
        this.setImage("imgs/particle_0.png");
        this.angle = a;
        this.speedX = (int)(25.0D * Math.cos(a));
        this.speedY = (int)(25.0D * Math.sin(a));
        this.speedZ = 1;
        this.lastX = this.speedX + 500;
        this.lastY = this.speedY + 500;
        this.accelTimer = 0;
    }

    public void act() {
        if (this.getX() < 0 || this.getX() > 1000 || this.getY() < 0 || this.getY() > 1000) {
            this.getWorld().removeObject(this);
        }

        if (this.accelTimer >= 10) {
            ++this.speedZ;
            this.accelTimer = 0;
        }

        this.tempX = this.lastX + this.speedX * this.speedZ / 100;
        this.tempY = this.lastY + this.speedY * this.speedZ / 100;
        this.setLocation((double)this.tempX, (double)this.tempY);
        this.lastX = this.getX();
        this.lastY = this.getY();
        ++this.accelTimer;
    }
}
