package ui;

import gamestates.Gamestate;
import gamestates.Playing;
import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.URMButtons.URM_SIZE;

public class PauseOverlay {
    private Playing playing;

    private BufferedImage backgroundImg;
    private int bgX,bgY,bgW,bgH;
    private UrmButton menuB,replayB,unpauseB;

    public PauseOverlay(Playing playing){
        this.playing = playing;

        loadBackground();
        createUrmButtons();
    }

    private void createUrmButtons() {
        int menuX = (int)(313* Game.SCALE);
        int replayX = (int)(387*Game.SCALE);
        int unpauseX = (int)(462 * Game.SCALE);
        int bY = (int)(315 * Game.SCALE);

        menuB = new UrmButton(menuX, bY, URM_SIZE,URM_SIZE,0);
        replayB = new UrmButton(replayX, bY, URM_SIZE,URM_SIZE,1);
        unpauseB = new UrmButton(unpauseX, bY, URM_SIZE,URM_SIZE,2);
    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
        bgW = (int)(backgroundImg.getWidth() * Game.SCALE);
        bgH = (int)(backgroundImg.getHeight() * Game.SCALE);
        bgX = Game.GAME_WIDTH / 2 - bgW / 2;
        bgY = (int) (25 * Game.SCALE);
    }

    public void update(){
        menuB.update();
        replayB.update();
        unpauseB.update();

    }
    public void draw(Graphics g){
        g.drawImage(backgroundImg, bgX,bgY,bgW,bgH,null);
        //URMBUTTON
        menuB.draw(g);
        replayB.draw(g);
        unpauseB.draw(g);
    }

    public void mousePressed(MouseEvent e) {
        if(isIn(e,menuB))
            menuB.setMousePressed(true);
        else if(isIn(e,replayB))
            replayB.setMousePressed(true);
        else if(isIn(e,unpauseB))
            unpauseB.setMousePressed(true);
    }

    public void mouseReleased(MouseEvent e) {
        if(isIn(e, menuB)){
            if(menuB.isMousePressed()) {
                Gamestate.state = Gamestate.MENU;
                playing.unpauseGame();
            }
        }
        if(isIn(e, unpauseB)){
            if(unpauseB.isMousePressed())
                playing.unpauseGame();
        }
        if(isIn(e, replayB)){
            if(replayB.isMousePressed())
                System.out.println("Gay");
        }
        menuB.resetBools();
        replayB.resetBools();
        unpauseB.resetBools();
    }



    public void mouseMoved(MouseEvent e) {
        menuB.setMouseOver(false);
        replayB.setMouseOver(false);
        unpauseB.setMouseOver(false);

        if(isIn(e,menuB))
            menuB.setMouseOver(true);
        if(isIn(e,replayB))
            replayB.setMouseOver(true);
        if(isIn(e,unpauseB))
            unpauseB.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b){
        return b.getBounds().contains(e.getX(),e.getY());
    }
}
