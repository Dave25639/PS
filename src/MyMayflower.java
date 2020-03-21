import mayflower.Mayflower;
import mayflower.World;

public class MyMayflower extends Mayflower {
    public MyMayflower() {
        super("ParticleEngine", 1000, 1000);
    }

    public void init() {
        Mayflower.setFullScreen(false);
        World w = new ParticleStage();
        Mayflower.setWorld(w);
    }
}

