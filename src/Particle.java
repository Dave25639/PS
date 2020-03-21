
import mayflower.Actor;

public class Particle extends Actor {
    double velocity;
    int timer;
    double acceleration;
    double distance;
    private int imageColor;
    private int oldColor;

    public Particle() {
        this.setImage("imgs/particle_0.png");
        this.velocity = 1.0D;
        this.acceleration = 0.25D;
        this.imageColor = 0;
        this.oldColor = 0;
        this.timer = 0;
        this.distance = 0.0D;
    }

    public void act() {
        this.distance = Math.sqrt(Math.pow((double)(500 - this.getX()), 2.0D) + Math.pow((double)(500 - this.getY()), 2.0D));
        this.turnTowards(500, 500);
        this.move(-((int)this.velocity));
        this.velocity += this.acceleration * this.distance / 15.0D;
        if (this.getX() < 0 || this.getX() > 1000 || this.getY() < 0 || this.getY() > 1000) {
            this.getWorld().removeObject(this);
        }

        ++this.timer;
        this.imageColor = (int)this.distance / 75;
        if (this.imageColor > 8) {
            this.imageColor = 8;
        }

        if (this.imageColor != this.oldColor) {
            this.setParticleImage();
            this.oldColor = this.imageColor;
        }

    }

    public void setParticleImage() {
        this.setImage("imgs/particle_" + this.imageColor + ".png");
    }
}

