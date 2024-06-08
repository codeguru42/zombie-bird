package codeguru.zombiebird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import codeguru.zombiebird.gameobjects.Bird;
import codeguru.zombiebird.helpers.AssetLoader;

public class GameRenderer {
    private final GameWorld myWorld;
    private final OrthographicCamera cam = new OrthographicCamera();
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();

    private final SpriteBatch batcher = new SpriteBatch();
    private final int gameHeight;
    private final int midPointY;

    private Bird bird;

    private TextureRegion bg, grass;

    private Animation<TextureRegion> birdAnimation;

    private TextureRegion birdMid, birdDown, birdUp;

    private TextureRegion skullUp, skullDown, bar;

    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        myWorld = world;
        cam.setToOrtho(true, 136, 204);
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer.setProjectionMatrix(cam.combined);

        initGameObjects();
        initAssets();
    }

    private void initGameObjects() {
        bird = myWorld.getBird();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        // Draw background
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        shapeRenderer.end();

        batcher.begin();

        batcher.disableBlending();
        batcher.draw(bg, 0, midPointY + 23, 136, 43);
        batcher.enableBlending();

        if (bird.shouldntFlap()) {
            batcher.draw(
                birdMid,
                bird.getX(),
                bird.getY(),
                bird.getWidth() / 2.0f,
                bird.getHeight() / 2.0f,
                bird.getWidth(),
                bird.getHeight(),
                1,
                1,
                bird.getRotation()
            );
        } else {
            batcher.draw(
                birdAnimation.getKeyFrame(runTime),
                bird.getX(),
                bird.getY(),
                bird.getWidth() / 2.0f,
                bird.getHeight() / 2.0f,
                bird.getWidth(),
                bird.getHeight(),
                1,
                1,
                bird.getRotation()
            );
        }

        batcher.end();
    }
}
