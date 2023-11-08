package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

public class GamePanel extends JPanel {
    private MouseInputs mouseinputs;
    private Game game;

    public GamePanel(Game game){
        mouseinputs = new MouseInputs(this);
        this.game = game;


        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
    }


    private void setPanelSize(){
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        System.out.println("size: "+GAME_WIDTH+" : "+GAME_HEIGHT);
        setMaximumSize(size);

    }
    public void updateGame(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}
