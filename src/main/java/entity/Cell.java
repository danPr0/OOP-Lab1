package entity;

import frame.MyFrame;
import service.TableService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static util.SizeOfElements.*;

public class Cell extends JButton implements ActionListener {
    private String expression = "";
    private Double result;
    private final String link;
    private final TableService tableService;
    private final JTextField mainInput;

    public Cell(int i, int j, MyFrame myFrame, JTextField mainInput, TableService tableService) {
        super();
        this.tableService = tableService;
        this.mainInput = mainInput;
        link = String.valueOf((char)(j + 65)) + (i + 1);

        setBounds(j * CELL_WIDTH + ROW_NAME_WIDTH, i * CELL_HEIGHT + MAIN_INPUT_HEIGHT + COLUMN_NAME_HEIGHT + MENU_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
        setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        addActionListener(this);
        myFrame.getContentPane().add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainInput.setText(expression);
        tableService.setCurrentCell(this);
        setBorder(BorderFactory.createLineBorder(Color.green, 1));
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setResult(Double result) {
        this.result = result;
        setResult(Double.toString(new BigDecimal(result).setScale(7, RoundingMode.HALF_DOWN).stripTrailingZeros().doubleValue()));
    }

    public void setResult(String text) {
        int expIndex = text.indexOf('E');
        if (expIndex == -1) {
            int dotIndex = text.indexOf('.');
            if (text.substring(dotIndex + 1).equals("0"))
                text = text.substring(0, dotIndex);
            else {
                text = text.substring(0, Math.min(9, text.length()));
            }
        }
        else {
            String exp = text.substring(expIndex);
            int leftLength = 9 - exp.length() - 2;
            int fracLength = Math.min(leftLength, text.substring(2, expIndex).length());
            text = text.substring(0, 2) + text.substring(2, 2 + fracLength) + exp;
        }

        setText(text);
    }

    public String getLink() {
        return link;
    }

    public Double getResult() {
        return result;
    }

    public void setSelected(boolean select) {
        if (select)
            setBorder(BorderFactory.createLineBorder(Color.green, 1));
        else setBorder(BorderFactory.createLineBorder(Color.gray, 1));
    }
}
