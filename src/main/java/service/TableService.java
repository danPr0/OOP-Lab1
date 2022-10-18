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
import java.util.HashMap;
import java.util.Map;

import static util.SizeOfElements.*;

public class TableService implements ActionListener {
    private final Cell[][] table;
    private final int noOfRows, noOfColumns;
    private final Map<String, Double> values = new HashMap<>();
    private final MyFrame myFrame;
    private Cell currentCell;
    private JTextField mainInput;
    private JLabel infoLabel;

    public TableService(MyFrame myFrame, int n, int m) {
        this.myFrame = myFrame;
        this.noOfRows = n;
        this.noOfColumns = m;
        table = new Cell[n][m];

        createMainInput();
        createInfoLabel();
        createHeaderRow(m);
        createHeaderColumn(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = new Cell(i, j, myFrame, mainInput, this);
            }
        }

        currentCell = table[0][0];
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
        parseRecursion(currentCell, mainInput.getText());
    }

    private void parseRecursion(Cell cell, String expression) {
        try {
            parse(cell.getLink() + " = " + expression);
            if (values.containsKey(cell.getLink())) {
                values.forEach((k, v) -> {
                    Cell curCell = table[k.charAt(1) - 49][k.charAt(0) - 65];
                    if (curCell.getExpression().contains(cell.getLink())) {
                        if (cell.getExpression().contains(curCell.getLink())) {
                            parse(cell.getLink() + " = " + cell.getExpression().replace(curCell.getLink(), "???"));
                        }
                        else parseRecursion(curCell, curCell.getExpression());
                    }
                });
                cell.setResult(values.get(cell.getLink()));
            }
        }
        catch (IllegalArgumentException exception) {
            System.out.println("sts");
            if (exception.getMessage() == null)
                mainInput.setText("Невідомі вхідні дані");
            else mainInput.setText(exception.getMessage());
            cell.setResult("?");
        }
    }

    private void parse(String input) {
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
        mainInput.setBounds(70,MENU_HEIGHT, MAIN_INPUT_WIDTH, MAIN_INPUT_HEIGHT);
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
        for(int i = 0; i < n; i++) {
            JLabel rowName = new JLabel(String.valueOf(i + 1));
            rowName.setBounds(0, MAIN_INPUT_HEIGHT + COLUMN_NAME_HEIGHT + i * ROW_NAME_HEIGHT + MENU_HEIGHT, ROW_NAME_WIDTH, ROW_NAME_HEIGHT);
            rowName.setHorizontalAlignment(SwingConstants.CENTER);
            rowName.setBackground(Color.white);
            rowName.setOpaque(true);
            rowName.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            myFrame.getContentPane().add(rowName);
        }
    }

    private void createHeaderRow(int m) {
        for(int i = 0; i < m; i++) {
            JLabel columnName = new JLabel(String.valueOf((char) (65 + i)));
            columnName.setBounds(ROW_NAME_WIDTH + i * COLUMN_NAME_WIDTH, MAIN_INPUT_HEIGHT + MENU_HEIGHT, COLUMN_NAME_WIDTH, COLUMN_NAME_HEIGHT);
            columnName.setHorizontalAlignment(SwingConstants.CENTER);
            columnName.setLayout(null);
            columnName.setVisible(true);
            columnName.setBackground(Color.white);
            columnName.setOpaque(true);
            columnName.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            myFrame.getContentPane().add(columnName);
        }
    }

    public Cell[][] getTable() {
        return table;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }
}
