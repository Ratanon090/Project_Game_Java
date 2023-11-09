package objects;

import main.Game;

public class Potion extends GameObject{

    public Potion(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        initHitBx(7,14);
        xDrawOffset = (int)(14* Game.SCALE);
        yDrawOffset = (int)(18*Game.SCALE);
    }

    public void update(){
        updateAnimationTick();
    }
}
