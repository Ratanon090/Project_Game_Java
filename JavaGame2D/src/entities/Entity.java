package entities;

import main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {

    protected float x,y;
    protected int width, height;
    protected Rectangle2D.Float hitbox;
    protected float airSpeed;
    protected boolean inAir = false;
    protected int maxHealth = 10;
    protected int currentHealth = 3;
    protected int aniTick, aniIndex;
    protected Rectangle2D.Float attackBox;
    protected float walkSpeed = 1.5f;
    protected int state;
    public Entity(float x,float y,int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    protected void drawAttackBox(Graphics g, int xLvlOffset){
        g.setColor(Color.red);
        g.drawRect((int)attackBox.x - xLvlOffset,(int)attackBox.y,(int)attackBox.width,(int)attackBox.height);
    }
    protected void drawHitbox(Graphics g,int xLvlOffset ){
        //for debugging hitbox
        g.setColor(Color.PINK);
        g.drawRect((int)hitbox.x-xLvlOffset, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }

    protected void initHitBx(int width, int height) {
        hitbox = new Rectangle2D.Float(x,y,(int)(width* Game.SCALE),(int)(height*Game.SCALE));
    }
    public int getEnemyState(){
        return state;
    }
    public Rectangle2D.Float getHitbox(){
        return hitbox;
    }
    public int getAniIndex(){
        return aniIndex;
    }
}
