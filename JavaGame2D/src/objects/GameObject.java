package objects;

import main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static utilz.Constants.ANI_SPEED;
import static utilz.Constants.ObjectConstants.*;

public class GameObject {

    protected int x,y, objType;
    protected Rectangle2D.Float hitbox;
    protected boolean doAnimation, active = true;
    protected int aniTick, aniIndex;
    protected int xDrawOffset, yDrawOffset;

    public GameObject(int x,int y,int objType){
        this.x = x;
        this.y = y;
        this.objType = objType;
    }
    protected void updateAnimationTick(){
        aniTick++;
        if(aniTick >= ANI_SPEED){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(objType)){
                aniIndex = 0;

            }
        }
    }

    public int getObjType() {
        return objType;
    }


    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }


    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }


    public int getxDrawOffset() {
        return xDrawOffset;
    }


    public int getyDrawOffset() {
        return yDrawOffset;
    }
    public int getAniIndex(){
        return aniIndex;
    }


    public void reset(){
        aniIndex = 0;
        aniTick = 0;
        active = true;

        doAnimation = true;
    }
    protected void initHitBx(int width, int height) {
        hitbox = new Rectangle2D.Float(x,y,(int)(width* Game.SCALE),(int)(height*Game.SCALE));
    }
    public void drawHitbox(Graphics g, int xLvlOffset ){
        g.setColor(Color.PINK);
        g.drawRect((int)hitbox.x-xLvlOffset, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }
    public void setAnimaton(boolean doAnimation){
        this.doAnimation = doAnimation;
    }
}
