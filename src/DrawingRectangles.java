import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingRectangles extends JFrame {

    private int startX, startY, endX, endY;
    private boolean drawing;

    public DrawingRectangles() {
        setTitle("Draw Rectangles");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);








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
