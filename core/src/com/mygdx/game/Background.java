package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {

     class Star {
         Vector2 position;
         float speed;
         public Star () {
             position = new Vector2(MathUtils.random(0, 1280), MathUtils.random(0, 720));
             speed = MathUtils.random(0.5f, 3.0f);
         }

         public void update() {
             position.x =- speed;
             if (position.x < -20){
                 position.x = 1280;
                 position.y = MathUtils.random(0, 720);
                 speed = MathUtils.random(0.5f, 3.0f);
             }
         }
     }

    Texture texture;

    public Background() {
        texture = new Texture("bg.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);

    }

    public void update() {

    }
}
