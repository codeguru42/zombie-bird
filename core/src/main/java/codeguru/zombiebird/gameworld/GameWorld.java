package codeguru.zombiebird.gameworld;

import codeguru.zombiebird.gameobjects.Bird;
import codeguru.zombiebird.gameobjects.ScrollHandler;

public class GameWorld {
    private final Bird bird;

    private final ScrollHandler scroller;


    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
