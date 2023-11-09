package utilz;

import entities.Crabby;
import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoadSave {
    public static final String PLAYER_ATLAS = "final_sprite.png";
    public static final String LEVEL_ATLAS = "outside_sprites_3.png";
    public static final String MENU_BUTTONS = "button-atlas.png";
    public static final String MENU_BACKGROUND = "menu-background.png";
    public static final String CRABBY_SPRITE = "enemy_d.png";
    public static final String STATUS_BAR    = "status.png";
    public static final String COMPLETED_IMG = "completed_sprite.png";
    public static final String PAUSE_BACKGROUND = "pause_menu.png";
    public static final String URM_BUTTON = "urm_button.png";
    public static final String POTION_ATLAS = "salt_sprite.png";



    public static BufferedImage GetSpriteAtlas(String filename){
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + filename);

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
    public static BufferedImage[] GetAllLevels() {
        // Initialize a list to store the loaded images.
        List<BufferedImage> imageList = new ArrayList<>();

        for (int i = 1; ; i++) {
            // Construct the resource path for each image file.
            String resourcePath = "/lvls/" + i + ".png";

            // Try to open an InputStream for the resource.
            InputStream inputStream = LoadSave.class.getResourceAsStream(resourcePath);

            if (inputStream == null) {
                // No more images found, break the loop.
                break;
            }

            try {
                // Read the image from the InputStream.
                BufferedImage image = ImageIO.read(inputStream);
                imageList.add(image);
            } catch (IOException e) {
                // Handle any exceptions that occur during image reading.
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Handle any exceptions that occur when closing the stream.
                    e.printStackTrace();
                }
            }
        }

        // Convert the list of images to an array.
        BufferedImage[] images = imageList.toArray(new BufferedImage[0]);
        return images;
    }



}
