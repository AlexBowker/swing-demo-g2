import static utils.Constants.*;

public class Missile extends Sprite {

    public Missile() {
        super(MISSILE_IMAGE_PATH, 0, 0, MISSILE_WIDTH, MISSILE_HEIGHT);
        getPos().x = BOARD_WIDTH - MISSILE_WIDTH;
        getPos().y = 0;
    }

    @Override
    public void tick() {
        getPos().x -= MISSILE_SPEED;
    }
}
