package codeguru.zombiebird.gameworld;

import com.badlogic.gdx.Gdx;

public class GameRenderer {
    private final GameWorld myWorld;

    public GameRenderer(GameWorld world) {
        myWorld = world;
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");
    }
}
