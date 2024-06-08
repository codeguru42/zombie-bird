package codeguru.zombiebird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class ZombieBirdGame extends Game {

    @Override
    public void create() {
        Gdx.app.log("ZombieBirdGame", "created");
        setScreen(new GameScreen());
    }
}
