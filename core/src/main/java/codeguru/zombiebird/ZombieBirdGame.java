package codeguru.zombiebird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import codeguru.zombiebird.helpers.AssetLoader;

public class ZombieBirdGame extends Game {

    @Override
    public void create() {
        Gdx.app.log("ZombieBirdGame", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
