package com.yakovlev.game;

import com.badlogic.gdx.Game;
import com.yakovlev.game.screen.MenuScreen;

public class YADGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));

    }
}
