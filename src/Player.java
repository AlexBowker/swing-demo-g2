import java.awt.event.KeyEvent;
import java.util.Set;

import static utils.Constants.*;

public class Player extends Sprite {
    private double dx;
    private double dy;

    public Player() {
        super(PLAYER_IMAGE_PATH, 0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public void tick() {
        getPos().translate((int)dx, (int)dy);

        getPos().x = Math.clamp(getPos().x, 0, BOARD_WIDTH - PLAYER_WIDTH);
        getPos().y = Math.clamp(getPos().y, 0, BOARD_HEIGHT - PLAYER_HEIGHT);
    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {
        dx = 0;
        dy = 0;

        if (activeKeyCodes.contains(KeyEvent.VK_UP)) {
            dy -= PLAYER_SPEED;
        }
        if (activeKeyCodes.contains(KeyEvent.VK_DOWN)) {
            dy += PLAYER_SPEED;
        }
        if (activeKeyCodes.contains(KeyEvent.VK_LEFT)) {
            dx -= PLAYER_SPEED;
        }
        if (activeKeyCodes.contains(KeyEvent.VK_RIGHT)) {
            dx += PLAYER_SPEED;
        }

        if (dx != 0 && dy != 0) {
            dx /= Math.sqrt(2);
            dy /= Math.sqrt(2);
        }
    }
}
