package frame;

import javax.swing.*;
import java.awt.*;

import menu.MyMenuBar;
import service.TableService;
import static util.SizeOfElements.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        super();

        setPreferredSize(new Dimension(WINDOW_WIDTH + 15, WINDOW_HEIGHT + 38));
        getContentPane().setBackground(new Color(64, 64, 64));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        TableService tableService = new TableService(this, 5, 5, 20, 20);

        MyMenuBar menu = new MyMenuBar(this, tableService);
        getContentPane().add(menu);

//        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
