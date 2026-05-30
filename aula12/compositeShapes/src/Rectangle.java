import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends BaseShape {
    private final int width;
    private final int height;

    public Rectangle(int x, int y, Color color, int width, int height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return x >= getX() && x <= getX() + getWidth()
                && y >= getY() && y <= getY() + getHeight();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());

        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 2, getHeight() + 2);
            disableSelectionStyle(graphics);
        }
    }
}
