import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Constants.*;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final List<Sprite> sprites;
    private final Set<Integer> activeKeyCodes;
    private final Player player;

    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.GREEN);

        player = new Player();
        Missile missile = new Missile();
        sprites = new ArrayList<>(List.of(player, missile));

        activeKeyCodes = new HashSet<>();

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.handleActiveKeys(activeKeyCodes);

        for (Sprite sprite : sprites) {
            sprite.tick();
        }

        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for (Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        activeKeyCodes.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        activeKeyCodes.remove(e.getKeyCode());
    }
}
