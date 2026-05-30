import java.awt.Graphics;
import java.awt.Color;

public class Dot extends BaseShape {
    private static final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return x > getX() - DOT_SIZE / 2 && x < getX() + DOT_SIZE / 2
                && y > getY() - DOT_SIZE / 2 && y < getY() + DOT_SIZE / 2;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getX() - 1, getY() - 1, getWidth(), getHeight());

        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }
    }
}