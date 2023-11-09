package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
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
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}
