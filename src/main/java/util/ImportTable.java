package util;

import frame.MyFrame;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import service.TableService;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportTable implements ActionListener {
    private final TableService tableService;
    private final MyFrame myFrame;

    public ImportTable(TableService tableService, MyFrame myFrame) {
        this.tableService = tableService;
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to import");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xls", "xls"));

        int userSelection = fileChooser.showOpenDialog(myFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                String fileName = selectedFile.getCanonicalPath();
                if (!fileName.endsWith(".xls")) {
                    selectedFile = new File(fileName + ".xls");
                }
                tableService.reformTable(getValues(selectedFile));
            } catch (IOException | BiffException exception) {
                exception.printStackTrace();
            }
        }
    }

    public List<List<entity.Cell>> getValues(File file) throws BiffException, IOException {
        List<List<entity.Cell>> table = new ArrayList<>();
        Workbook workBook = Workbook.getWorkbook(file);

        Sheet sheet = workBook.getSheet(workBook.getSheetNames()[0]);

        for (int row = 0; row < sheet.getRows(); row++) {
            List<entity.Cell> tableRow = new ArrayList<>();
            for (int column = 0; column < sheet.getColumns(); column++) {
                Cell cell = sheet.getCell(column, row);
                entity.Cell tableCell = new entity.Cell(row, column, myFrame, tableService.getMainInput(), tableService);
                tableCell.setExpression(cell.getContents());
                tableRow.add(tableCell);
            }
            table.add(tableRow);
        }

        return table;
    }
}
