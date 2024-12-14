
import com.sun.opengl.util.FPSAnimator ;

import java.awt.*;
import javax.swing.*;
import javax.media.opengl.GLCanvas;


public class BounceBall extends JFrame {
    static FPSAnimator animator  ;
    GLCanvas glcanvas  = new GLCanvas();
    final private BallGLEventListener listener = new BallGLEventListener();

    public BounceBall() {
        super("Bounce Ball");
        animator = new FPSAnimator(glcanvas , 60) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        glcanvas.addMouseListener(listener);

        add(glcanvas, BorderLayout.CENTER);
        setSize(1400, 1000);
        glcanvas.setFocusable(true);
        centerWindow();
        setLocationRelativeTo(this);
        setVisible(true);

    }



    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = this.getSize();


        if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;


        this.setLocation (
                (screenSize.width  - frameSize.width ) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}



