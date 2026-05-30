import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class BaseShape implements Shape {
    public int x;
    public int y;
    private final Color color;
    private boolean selected = false;

    public BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void select() {
        selected = true;
    }

    @Override
    public void unSelect() {
        selected = false;
    }

    protected void enableSelectionStyle(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(Color.LIGHT_GRAY);
        float[] dashPattern = {2.0f};
        g2.setStroke(new BasicStroke(
                1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f,
                dashPattern,
                0.0f));
    }

    protected void disableSelectionStyle(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(color);
        g2.setStroke(new BasicStroke());
    }

    @Override
    public abstract void paint(Graphics graphics);
}
