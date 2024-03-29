import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingRectangles extends JFrame {

    /*

    @author quantam (https://github.com/Quantamyt)
    17th of March 2024 at 22:36

     */


    private int startX, startY, endX, endY;
    private boolean drawing;

    public DrawingRectangles() {
        setTitle("Draw Rectangles");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Canvas canvas = new Canvas();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                drawing = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawing = false;
                canvas.repaint();
            }
        });

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    endX = e.getX();
                    endY = e.getY();
                    canvas.repaint();
                }
            }
        });

        add(canvas);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawingRectangles::new);
    }

    class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (drawing) {
                int width = Math.abs(endX - startX);
                int height = Math.abs(endY - startY);
                int x = Math.min(startX, endX);
                int y = Math.min(startY, endY);
                g.drawRect(x, y, width, height);
            }
        }
    }
}
