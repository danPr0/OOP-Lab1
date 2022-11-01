package service;

import antlr.CalculatorErrorListener;
import antlr.CalculatorLexer;
import antlr.CalculatorParser;
import antlr.EvalVisitor;
import entity.Cell;
import frame.MyFrame;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.SizeOfElements.*;

public class TableService implements ActionListener {
    private List<List<Cell>> table;
    private final int maxNoOfRows, maxNoOfColumns;
    private final Map<String, Double> values = new HashMap<>();
    private final MyFrame myFrame;
    private Cell currentCell;
    private JTextField mainInput;
    private JLabel infoLabel;
    private List<JLabel> headerRow, headerColumn;

    public TableService(MyFrame myFrame, int n, int m, int maxNoOfRows, int maxNoOfColumns) {
        this.myFrame = myFrame;
        this.maxNoOfRows = maxNoOfRows;
        this.maxNoOfColumns = maxNoOfColumns;
        table = new ArrayList<>();

        createMainInput();
        createInfoLabel();
        createHeaderRow(m);
        createHeaderColumn(n);

        for (int i = 0; i < n; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < m; j++)
                row.add(new Cell(i, j, myFrame, mainInput, this));
            table.add(row);
        }

        currentCell = table.get(0).get(0);
        currentCell.setSelected(true);
        currentCell.requestFocus();
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell.setSelected(false);
        this.currentCell = currentCell;
        infoLabel.setText(currentCell.getLink());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        mainInput.transferFocus();
        currentCell.setExpression(mainInput.getText());
//        currentCell.setSelected(false);
        currentCell.requestFocus();

        if (mainInput.getText().isBlank()) {
            currentCell.setResult((Double) null);
            currentCell.setResult("");
            values.remove(currentCell.getLink());
        }
        parseRecursion(currentCell, mainInput.getText());
    }

    private void parseRecursion(Cell cell, String expression) {
        try {
            if (!expression.isBlank())
                parse(cell.getLink() + " = " + expression);
            for (List<Cell> row : table) {
                for (Cell curCell : row) {
                    if (curCell.getExpression().contains(cell.getLink())) {

                        if (cell.getExpression().contains(curCell.getLink())) {
                            parse(cell.getLink() + " = " + cell.getExpression().replace(curCell.getLink(), "???"));
                        }
                        else parseRecursion(curCell, curCell.getExpression());
                    }
                }
            }
            if (!expression.isBlank())
                cell.setResult(values.get(cell.getLink()));
        } catch (IllegalArgumentException exception) {
            if (exception.getMessage() == null)
                mainInput.setText("Невідомі вхідні дані");
            else mainInput.setText(exception.getMessage());
            cell.setResult("?");
        }
    }

    public void reformTable(List<List<Cell>> table) {
        for (List<Cell> row : this.table)
            for (Cell curCell : row)
                myFrame.remove(curCell);

        for (List<Cell> row : table)
            for (Cell curCell : row)
                myFrame.add(curCell);

        this.table = table;
        for (List<Cell> row : table)
            for (Cell curCell : row)
                parseRecursion(curCell, curCell.getExpression());

        myFrame.repaint();

        currentCell = table.get(0).get(0);
        currentCell.setSelected(true);
        currentCell.requestFocus();
    }

    public void removeLastColumn() {
        if (table.get(0).size() == 1)
            return;

        for (List<Cell> row : table) {
            Cell cell = row.get(row.size() - 1);
            row.remove(cell);
            myFrame.remove(cell);
        }

        for (JLabel columnName : headerRow)
            myFrame.remove(columnName);
        createHeaderRow(table.get(0).size());

        myFrame.repaint();
    }

    public void removeLastRow() {
        if (table.size() == 1)
            return;

        List<Cell> lastRow = table.get(table.size() - 1);
        for (Cell cell : lastRow)
            myFrame.remove(cell);
        table.remove(lastRow);

        for (JLabel rowName : headerColumn)
            myFrame.remove(rowName);
        createHeaderColumn(table.size());

        myFrame.repaint();
    }

    public void addColumn() {
        if (table.get(0).size() == maxNoOfColumns)
            return;

        for (List<Cell> row : table) {
            Cell cell = new Cell(table.indexOf(row), row.size(), myFrame, mainInput, this);
            row.add(cell);
            myFrame.add(cell);
        }

        for (JLabel columnName : headerRow)
            myFrame.remove(columnName);
        createHeaderRow(table.get(0).size());

        myFrame.repaint();
    }

    public void addRow() {
        if (table.size() == maxNoOfRows)
            return;

        List<Cell> row = new ArrayList<>();
        for (int i = 0; i < table.get(0).size(); i++) {
            Cell cell = new Cell(table.size(), i, myFrame, mainInput, this);
            row.add(cell);
            myFrame.add(cell);
        }
        table.add(row);

        for (JLabel rowName : headerColumn)
            myFrame.remove(rowName);
        createHeaderColumn(table.size());

        myFrame.repaint();
    }

    public void parse(String input) {
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        CalculatorErrorListener errorListener = new CalculatorErrorListener();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.program();
        EvalVisitor eval = new EvalVisitor(values);
        eval.visit(tree);
    }

    private void createMainInput() {
        mainInput = new JTextField();
        mainInput.setBounds(70, MENU_HEIGHT, Toolkit.getDefaultToolkit().getScreenSize().width - 70, MAIN_INPUT_HEIGHT);
        mainInput.addActionListener(this);
        myFrame.getContentPane().add(mainInput);
    }

    private void createInfoLabel() {
        infoLabel = new JLabel("A1");
        infoLabel.setBounds(0, MENU_HEIGHT, 25, 25);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBackground(Color.white);
        infoLabel.setOpaque(true);
        myFrame.getContentPane().add(infoLabel);
    }

    private void createHeaderColumn(int n) {
        headerColumn = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            JLabel rowName = new JLabel(String.valueOf(i + 1));
            rowName.setBounds(0, MAIN_INPUT_HEIGHT + COLUMN_NAME_HEIGHT + i * ROW_NAME_HEIGHT + MENU_HEIGHT, ROW_NAME_WIDTH, ROW_NAME_HEIGHT);
            rowName.setHorizontalAlignment(SwingConstants.CENTER);
            rowName.setBackground(Color.white);
            rowName.setOpaque(true);
            rowName.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

            headerColumn.add(rowName);
            myFrame.getContentPane().add(rowName);
        }
    }

    private void createHeaderRow(int m) {
        headerRow = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            JLabel columnName = new JLabel(String.valueOf((char) (65 + i)));
            columnName.setBounds(ROW_NAME_WIDTH + i * COLUMN_NAME_WIDTH, MAIN_INPUT_HEIGHT + MENU_HEIGHT, COLUMN_NAME_WIDTH, COLUMN_NAME_HEIGHT);
            columnName.setHorizontalAlignment(SwingConstants.CENTER);
            columnName.setLayout(null);
            columnName.setVisible(true);
            columnName.setBackground(Color.white);
            columnName.setOpaque(true);
            columnName.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

            headerRow.add(columnName);
            myFrame.getContentPane().add(columnName);
        }
    }

    public List<List<Cell>> getTable() {
        return table;
    }

    public JTextField getMainInput() {
        return mainInput;
    }
}
