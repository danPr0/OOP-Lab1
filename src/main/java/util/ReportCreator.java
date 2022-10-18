package util;

import frame.MyFrame;
import jxl.CellType;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import entity.Cell;
import service.TableService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ReportCreator implements ActionListener {
    private final TableService tableService;
    private final MyFrame myFrame;

    public ReportCreator(TableService tableService, MyFrame myFrame) {
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

        Cell[][] table = tableService.getTable();
        int n = tableService.getNoOfRows();
        int m = tableService.getNoOfColumns();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                try {
                    if (!table[i][j].getExpression().isEmpty())
                        sheet.addCell(new jxl.write.Formula(j, i, table[i][j].getExpression()));
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
