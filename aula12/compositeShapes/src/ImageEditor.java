import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ImageEditor {
    private final EditorCanvas canvas;
    private final CompoundShape allShapes = new CompoundShape();
    private CompoundShape selectedShapes = new CompoundShape();

    public ImageEditor() {
        JFrame frame = new JFrame("Composite Pattern Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        canvas = new EditorCanvas();
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(createControlPanel(), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void loadShapes() {
        allShapes.add(
                new Circle(110, 110, Color.RED, 50),
                new Dot(160, 160, Color.RED),
                new Dot(80, 80, Color.GREEN),
                new Rectangle(250, 250, Color.BLUE, 100, 100),
                new CompoundShape(
                        new Circle(500, 300, Color.BLACK, 100),
                        new Dot(480, 250, Color.BLACK),
                        new Dot(520, 350, Color.BLACK),
                        new Rectangle(450, 200, Color.BLACK, 120, 160)));
        canvas.repaint();
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton selectAllButton = new JButton("Select All");
        JButton unselectAllButton = new JButton("Unselect All");

        selectAllButton.addActionListener(event -> {
            allShapes.select();
            selectedShapes = allShapes;
            canvas.repaint();
        });

        unselectAllButton.addActionListener(event -> {
            allShapes.unSelect();
            selectedShapes = new CompoundShape();
            canvas.repaint();
        });

        panel.add(selectAllButton);
        panel.add(unselectAllButton);
        return panel;
    }

    private class EditorCanvas extends Canvas {
        private static final long serialVersionUID = 1L;

        private int lastX;
        private int lastY;

        EditorCanvas() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    lastX = e.getX();
                    lastY = e.getY();

                    if (!allShapes.selectChildAt(e.getX(), e.getY())) {
                        allShapes.unSelect();
                        selectedShapes = new CompoundShape();
                    } else {
                        selectedShapes = new CompoundShape();
                        selectedShapes.add(allShapes);
                    }
                    repaint();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    int deltaX = e.getX() - lastX;
                    int deltaY = e.getY() - lastY;

                    if (selectedShapes != null) {
                        selectedShapes.move(deltaX, deltaY);
                        repaint();
                    }

                    lastX = e.getX();
                    lastY = e.getY();
                }
            });
        }

        @Override
        public void paint(Graphics graphics) {
            allShapes.paint(graphics);
        }
    }
}
