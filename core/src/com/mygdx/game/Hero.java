package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    Vector2 position;
    Texture texture;
    float speed;
    int fireCounter;
    int fireRate;

    public Hero() {
        position = new Vector2(100, 328);
        texture = new Texture("ship64.png");
        speed = 10.0f;
        fireCounter = 0;
        fireRate = 8;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            fireCounter++;
            if (fireCounter >= fireRate) {
                fireCounter = 0;
                fire();
            }
        }

        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() < position.x + 32) {
                position.x -= speed;
            }
            if (Gdx.input.getX() > position.x + 32) {
                position.x += speed;
            }

            if (720 - Gdx.input.getY() < position.y + 32) {
                position.y -= speed;
            }
            if (720 - Gdx.input.getY() > position.y + 32) {
                position.y += speed;
            }
        }

        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > 1216) {
            position.x = 1216;
        }
        if (position.y < -64) {
            position.y = 720;
        }
        if (position.y > 720) {
            position.y = -64;
        }
    }

    public void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].active) {
                MyGdxGame.bullets[i].activate(position.x + 48, position.y + 32);
                break;
            }
        }
    }
}