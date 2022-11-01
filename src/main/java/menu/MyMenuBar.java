package menu;

import frame.MyFrame;
import service.TableService;
import util.ImportTable;
import util.SaveTable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static util.SizeOfElements.*;

public class MyMenuBar extends JMenuBar implements ActionListener {
    private final MyFrame myFrame;
    private final TableService tableService;
    private final JMenuItem help;

    public MyMenuBar(MyFrame myFrame, TableService tableService) {
        super();
        this.myFrame = myFrame;
        this.tableService = tableService;

        setBounds(0, 0, MENU_WIDTH, MENU_HEIGHT);
        JMenu file = new JMenu("File");
        JMenu reference = new JMenu("Reference");
        JMenu table = new JMenu("Table");

        JMenuItem addColumn = new JMenuItem("Add column");
        addColumn.addActionListener((e) -> tableService.addColumn());
        JMenuItem addRow = new JMenuItem("Add row");
        addRow.addActionListener((e) -> tableService.addRow());
        JMenuItem removeColumn = new JMenuItem("Remove column");
        removeColumn.addActionListener((e) -> tableService.removeLastColumn());
        JMenuItem removeRow = new JMenuItem("Remove row");
        removeRow.addActionListener((e) -> tableService.removeLastRow());

        JMenuItem saveAs = createSaveAsItem();
        JMenuItem importAs = createImportAsItem();
        help = createHelpItem();
        JMenuItem aboutProgram = createAboutProgramItem();

        file.add(saveAs);
        file.add(importAs);
        reference.add(help);
        reference.add(aboutProgram);

        table.add(addColumn);
        table.add(addRow);
        table.add(removeColumn);
        table.add(removeRow);

        add(file);
        add(reference);
        add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog infoFrame = new JDialog(myFrame, Dialog.ModalityType.DOCUMENT_MODAL);
        infoFrame.setBounds(350,200,400,200);
        infoFrame.setLayout(null);
        infoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l=new JLabel();
        l.setBounds(15,10,370,180);
        l.setFont(new Font("Arial", Font.PLAIN, 12));
        l.setVerticalAlignment(SwingConstants.TOP);

        if (e.getSource() == help) {
            l.setText("<html><p>   Оператори : +, -, *, /, mod(остача від ділення), dіv(ціло численне ділення), ^(возведення в степінь), іnc(інкремент), dec(декремент)<p><br/>" +
                    "<p>Константи : pi(PI), e(E)<p><br/>" +
                    "<p>Посилання на клітинки : Буква(стовпчик)Цифра(ряд) (напр. А4)<p></html>");
        }
        else  l.setText("<html>Програма надає функціонал додавання форм для<br/>" +
                "введення, обробки та збереження електронних таблиць.</html>");
        infoFrame.add(l);
        infoFrame.setVisible(true);
    }

    private JMenuItem createSaveAsItem() {
        JMenuItem result = new JMenuItem("Save as");
//        result.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        result.setIconTextGap(0);
        result.addActionListener(new SaveTable(tableService, myFrame));

        return result;
    }

    private JMenuItem createImportAsItem() {
        JMenuItem result = new JMenuItem("Import as");
//        result.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        result.setIconTextGap(0);
        result.addActionListener(new ImportTable(tableService, myFrame));

        return result;
    }

    private JMenuItem createHelpItem() {
//        JMenuItem result = new JMenuItem("Help                 ");
        JMenuItem result = new JMenuItem("Help");
//        result.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        result.setIconTextGap(0);
        result.addActionListener(this);

        return result;
    }

    private JMenuItem createAboutProgramItem() {
        JMenuItem result = new JMenuItem("About program");
//        result.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        result.setIconTextGap(0);
        result.addActionListener(this);

        return result;
    }
}
