package codeguru.zombiebird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GameRenderer {
    private final GameWorld myWorld;
    private final OrthographicCamera cam = new OrthographicCamera();
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam.setToOrtho(true, 136, 204);
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
        Rectangle rect = myWorld.getRect();
        shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
        shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
        shapeRenderer.end();
    }
}
