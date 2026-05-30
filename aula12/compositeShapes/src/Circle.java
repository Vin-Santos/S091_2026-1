import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Dot {
    private final int radius;

    public Circle(int x, int y, Color color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        int xDiff = x - getX();
        int yDiff = y - getY();
        return xDiff * xDiff + yDiff * yDiff <= radius * radius;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(getX() - radius, getY() - radius, getWidth(), getHeight());

        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawOval(getX() - radius, getY() - radius, getWidth(), getHeight());
            disableSelectionStyle(graphics);
        }
    }
}