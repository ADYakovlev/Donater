package com.yakovlev.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.yakovlev.game.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    SpriteBatch batch;
    Texture img;
    Vector2 pos;
    Vector2 n = new Vector2(0,0);
    Vector2 destination;
    float SPEED = 2f;
    double rad;
    boolean up;
    boolean down;
    boolean right;
    boolean left;


    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("do.png");
        pos = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 19 || keycode == 51) up = true;
        if (keycode == 20 || keycode == 47) down = true;
        if (keycode == 21 || keycode == 29) left = true;
        if (keycode == 22 || keycode == 32) right = true;
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == 19 || keycode == 51) up = false;
        if (keycode == 20 || keycode == 47) down = false;
        if (keycode == 21 || keycode == 29) left = false;
        if (keycode == 22 || keycode == 32) right = false;
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        destination = new Vector2((screenX-img.getWidth()/2),Gdx.graphics.getHeight()-screenY-(img.getHeight()/2));
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        destination.set((screenX-img.getWidth()/2),Gdx.graphics.getHeight()-screenY-(img.getHeight()/2));
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        destination.set((screenX-img.getWidth()/2),Gdx.graphics.getHeight()-screenY-(img.getHeight()/2));
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1f, 1f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (up) pos.y = pos.y + SPEED;
        if (down) pos.y = pos.y - SPEED;
        if (right) pos.x = pos.x + SPEED;
        if (left) pos.x = pos.x - SPEED;
        if(destination!=null)n.set(destination.cpy().sub(pos).nor());
        if(destination!=null)rad = Math.sqrt((destination.x-pos.x)*(destination.x-pos.x)+(destination.y-pos.y)*(destination.y-pos.y));
        if(n!=null&&rad>1)pos.add(n);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }
}
