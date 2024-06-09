package codeguru.zombiebird.gameworld;

import codeguru.zombiebird.gameobjects.Bird;
import codeguru.zombiebird.gameobjects.ScrollHandler;
import codeguru.zombiebird.helpers.AssetLoader;

public class GameWorld {
    private final Bird bird;

    private final ScrollHandler scroller;

    private boolean isAlive = true;


    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);

        if (isAlive && scroller.collides(bird)) {
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
