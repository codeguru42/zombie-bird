package codeguru.zombiebird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import codeguru.zombiebird.gameworld.GameRenderer;
import codeguru.zombiebird.gameworld.GameWorld;

public class GameScreen implements Screen {
    private final GameWorld world = new GameWorld();
    private final GameRenderer renderer = new GameRenderer(world);

    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {
        Gdx.app.log("GameScreen", "dispose called");
    }
}
