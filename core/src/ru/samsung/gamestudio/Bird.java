package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {

    private int x, y;
    private int width, height;

    private int speed;
    private int jumpHeight;
    private final int maxHeightOfJump = 200;
    private boolean jump;

    private int frameCounter;
    private Texture[] framesArray;

    public Bird(int x, int y, int speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        frameCounter = 0;

        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
    }

    public void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }

    public void draw(Batch batch) {
        int frameMultiplier = 10;

        batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);

        frameCounter++;
        if (frameCounter == framesArray.length * frameMultiplier) {
            frameCounter = 0;
        }
    }

    public void dispose() {
        for (Texture texture : framesArray) {
            texture.dispose();
        }
    }
}
