package objects;


import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static utilz.Constants.ObjectConstants.*;

public class ObjectManager {
    private Playing playing;
    private BufferedImage[][] potionImgs;
    private ArrayList<Potion> potions;
    public ObjectManager(Playing playing){
        this.playing = playing;
        loadImgs();

    }
    public void checkObjectTouched(Rectangle2D.Float hitbox){
        for(Potion p:potions)
            if(p.isActive()){
                if(hitbox.intersects(p.getHitbox())) {
                    p.setActive(false);
                    applyEffectToPlayer(p);
                }
            }
    }
    public void applyEffectToPlayer(Potion p){
        if(p.getObjType() == FAKE_SALT)
            playing.getPlayer().changeHealth(FAKE_SALT_VALUE);
        else
            playing.setLevelCompleted(true);
    }
    public void checkObjectHit(Rectangle2D.Float hitbox){

    }
    public void loadObjects(Level newLevel) {
        potions = newLevel.getPotions();

    }
    private void loadImgs() {
        BufferedImage potionSprite = LoadSave.GetSpriteAtlas(LoadSave.POTION_ATLAS);
        potionImgs = new BufferedImage[2][1];
        for(int j=0;j<potionImgs.length;j++){
            for(int i=0;i<potionImgs[j].length;i++)
                potionImgs[j][i] = potionSprite.getSubimage(100*i,100*j,100,100);
        }
    }

    public void update(){
        for(Potion p: potions)
            if(p.isActive())
                p.update();

    }
    public void draw(Graphics g, int xLvlOffset){
        drawPotions(g,xLvlOffset);
    }

    private void drawPotions(Graphics g, int xLvlOffset) {
        for(Potion p: potions)
            if(p.isActive()){
                int type = 0;
                if(p.getObjType() == FAKE_SALT){
                    type = 0;
                }
                else if(p.getObjType() == REAL_SALT){
                    type = 1;
                }
                g.drawImage(potionImgs[type][p.getAniIndex()],(int)(p.getHitbox().x - p.getxDrawOffset() - xLvlOffset),
                        (int)(p.getHitbox().y-p.getyDrawOffset()),
                        SALT_WIDTH,
                        SALT_HEIGHT,null);
            }
    }


}
