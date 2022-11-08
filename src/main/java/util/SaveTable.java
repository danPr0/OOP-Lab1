package util;

import entity.Cell;
import frame.MyFrame;
import jxl.Workbook;
import jxl.write.*;
import service.TableService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaveTable implements ActionListener {
    private final TableService tableService;
    private final MyFrame myFrame;

    public SaveTable(TableService tableService, MyFrame myFrame) {
        this.tableService = tableService;
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(myFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                String fileName = selectedFile.getCanonicalPath();
                if (!fileName.endsWith(".xls")) {
                    selectedFile = new File(fileName + ".xls");
                }
                createXls(selectedFile);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void createXls(File file) throws IOException {
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        WritableSheet sheet = workbook.createSheet("Report", 0);

        List<List<Cell>> table = tableService.getTable();

        for (List<Cell> row : table) {
            for (Cell curCell : row) {
                try {
                    if (!curCell.getExpression().isBlank())
                        sheet.addCell(new Label(row.indexOf(curCell), table.indexOf(row), curCell.getExpression()));
//                    if (curCell.getResult() != null)
//                        sheet.addCell(new jxl.write.Number(row.indexOf(curCell), table.indexOf(row), curCell.getResult()));
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }

        workbook.write();
        try {
            workbook.close();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
