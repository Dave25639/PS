
import mayflower.MayflowerImage;
import mayflower.World;

public class ParticleStage extends World {
    private double angle = 0.0D;
    private int yOscillation = 0;
    private boolean inc = false;
    private boolean xinc = true;
    private int xOscillation = 200;
    private int timer = 0;
    private int xtimer = 0;
    private int etimer = 0;
    private double largeAngle = 0.0D;
    private int squareAngle = 0;

    public ParticleStage() {
        this.setBackground(new MayflowerImage("imgs/black.png"));
    }

    public void act() {
        this.xOscillation = (int)(100.0D * Math.cos(this.largeAngle));
        this.yOscillation = (int)(100.0D * Math.sin(this.largeAngle));
        this.largeAngle += 0.25D;
        ++this.squareAngle;

        for(int i = 360; i > 0; i -= 36) {
            this.angle = i * Math.PI / 180 + (Math.random()*15);
            addObject(new Particle(), (int)(100*Math.cos(angle)+750), (int)(100*Math.sin(angle)+250));
        }
        //addObject(new Particle(), (int)(Math.random()*500)+250, (int)(Math.random()*500)+250);
        ++this.etimer;
    }

    public void drawSquare(int centerX, int centerY, int radius, double angleOffset) {
        System.out.println("drawSquare() Called");
        int L = radius * 2;
        this.drawLine((int)((double)centerX + (double)(L) * Math.sin(angleOffset)), (int)((double)centerY + (double)(L) * Math.cos(angleOffset)), (int)((double)centerX - (double)(L) * Math.cos(angleOffset)), (int)((double)centerY + (double)(0 * L) * Math.sin(angleOffset)));
        this.drawLine((int)((double)centerX - (double)(L) * Math.cos(angleOffset)), (int)((double)centerY + (double)(L) * Math.sin(angleOffset)), (int)((double)centerX - (double)(L) * Math.sin(angleOffset)), (int)((double)centerY - (double)(0 * L) * Math.cos(angleOffset)));
        this.drawLine((int)((double)centerX - (double)(L) * Math.sin(angleOffset)), (int)((double)centerY - (double)(L) * Math.cos(angleOffset)), (int)((double)centerX + (double)(L) * Math.cos(angleOffset)), (int)((double)centerY - (double)(0 * L) * Math.sin(angleOffset)));
        this.drawLine((int)((double)centerX + (double)(L) * Math.cos(angleOffset)), (int)((double)centerY - (double)(L) * Math.sin(angleOffset)), (int)((double)centerX + (double)(L) * Math.sin(angleOffset)), (int)((double)centerY + (double)(0 * L) * Math.cos(angleOffset)));
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        System.out.println("drawLine() Called");
        int distance = (int)Math.sqrt(Math.pow((double)(endX - startX), 2.0D) + Math.pow((double)(endY - startY), 2.0D));

        for(int i = 10; i > 0; --i) {
            int stepSize = distance / i;
            Particle p = new Particle();
            this.addObject(p, startX, startY);
            p.turnTowards(endX, endY);
            p.move(stepSize);
        }

    }
}


