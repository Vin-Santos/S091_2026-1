import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
    private final List<Shape> children = new ArrayList<>();

    public CompoundShape(Shape... shapes) {
        super(0, 0, Color.BLACK);
        children.addAll(Arrays.asList(shapes));
    }

    public void add(Shape... shapes) {
        children.addAll(Arrays.asList(shapes));
    }

    public void remove(Shape shape) {
        children.remove(shape);
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.isEmpty()) {
            return 0;
        }

        int x = children.get(0).getX();
        for (Shape child : children) {
            x = Math.min(x, child.getX());
        }
        return x;
    }

    @Override
    public int getY() {
        if (children.isEmpty()) {
            return 0;
        }

        int y = children.get(0).getY();
        for (Shape child : children) {
            y = Math.min(y, child.getY());
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxX = 0;
        for (Shape child : children) {
            maxX = Math.max(maxX, child.getX() + child.getWidth());
        }
        return maxX - getX();
    }

    @Override
    public int getHeight() {
        int maxY = 0;
        for (Shape child : children) {
            maxY = Math.max(maxY, child.getY() + child.getHeight());
        }
        return maxY - getY();
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void select() {
        super.select();
        for (Shape child : children) {
            child.select();
        }
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : children) {
            child.unSelect();
        }
    }

    public boolean selectChildAt(int x, int y) {
        for (int i = children.size() - 1; i >= 0; i--) {
            Shape child = children.get(i);
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        for (Shape child : children) {
            child.paint(graphics);
        }

        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }
    }
}