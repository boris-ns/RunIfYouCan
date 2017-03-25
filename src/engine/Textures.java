package engine;

import java.awt.image.BufferedImage;
/**
 * Created by boris on 11/11/16.
 */

// Klasa koja predstavlja skup svih tekstura
public class Textures
{
    private SpriteSheet playerSheet, blockSheet;
    private BufferedImage player = null, blocks = null;

                                                        // Ovo 2 promeni, to zapravo predstavlja koliko tiles-a ima za igraca
    public BufferedImage[] playerTiles = new BufferedImage[2];	// Niz textura Player-a

    public Textures()
    {
        BufferedImageLoader loader = new BufferedImageLoader();

        // Ucitavanje velikih slika
        player = loader.loadImage("/player.png");
        blocks = loader.loadImage("/blocks.png");

        // Smestanje velikih slika u SpriteSheet
        playerSheet = new SpriteSheet(player);
        blockSheet = new SpriteSheet(blocks);

        getTextures();
    }

    // Uzimanje malih(pojedinacnih) textura iz velikih slika
    private void getTextures()
    {
        // PRIMER
        //blockTiles[0] = blockSheet.grabImage(1, 1, 32, 32);
    }
}