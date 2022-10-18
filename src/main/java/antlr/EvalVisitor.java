package antlr;

import java.util.Map;

public class EvalVisitor extends CalculatorBaseVisitor<Double> {
    private final Map<String, Double> values;

    public EvalVisitor(Map<String, Double> values) {
        this.values = values;
    }

    @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Double visitAssign(CalculatorParser.AssignContext ctx) {
        String var = ctx.VARIABLE().getText();
        Double value = visit(ctx.expression());
        values.put(var, value);
        return value;
    }

    @Override public Double visitDIV(CalculatorParser.DIVContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        if (right == 0) {
            System.err.println("division by zero at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getCharPositionInLine());
            throw new IllegalArgumentException("Ділення на нуль");
        }
        return left / right;
    }

    @Override
    public Double visitINT_DIV(CalculatorParser.INT_DIVContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        if (right == 0) {
            System.err.println("int division by zero at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getCharPositionInLine());
            throw new IllegalArgumentException("Ділення на нуль");
        }
        double resultDiv = left / right;
        return resultDiv - resultDiv % 1;
    }

    @Override public Double visitADD(CalculatorParser.ADDContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        return left + right;
    }

    @Override public Double visitVariable(CalculatorParser.VariableContext ctx) {
        String id = ctx.VARIABLE().getText();
        if (!values.containsKey(id)) {
            System.err.println("Using a variable without assignment at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getCharPositionInLine());
            throw new IllegalArgumentException("Невідома змінна");
        }
        return values.get(id);
    }

    @Override public Double visitMOD(CalculatorParser.MODContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        if (right == 0) {
            System.err.println("mod division by zero at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getCharPositionInLine());
            throw new IllegalArgumentException("Ділення з остачею на нуль");
        }
        return left % right;
    }

    @Override public Double visitMUL(CalculatorParser.MULContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        return left * right;
    }

    @Override public Double visitParents(CalculatorParser.ParentsContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitOperand(CalculatorParser.OperandContext ctx) {
        return Double.valueOf(ctx.OPERAND().getText());
    }

    @Override public Double visitMINUS(CalculatorParser.MINUSContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        return left - right;
    }

    @Override
    public Double visitPOW(CalculatorParser.POWContext ctx) {
        Double left = visit(ctx.expression(0));
        Double right = visit(ctx.expression(1));
        return Math.pow(left, right);
    }

    @Override
    public Double visitDEC(CalculatorParser.DECContext ctx) {
        Double value = visit(ctx.expression());
        return value - 1;
    }

    @Override
    public Double visitINC(CalculatorParser.INCContext ctx) {
        Double value = visit(ctx.expression());
        return value + 1;
    }

    @Override
    public Double visitE(CalculatorParser.EContext ctx) {
        return Math.E;
    }

    @Override
    public Double visitPI(CalculatorParser.PIContext ctx) {
        return Math.PI;
    }

    @Override
    public Double visitCycle(CalculatorParser.CycleContext ctx) {
        System.err.println("Cycle at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getCharPositionInLine());
        throw new IllegalArgumentException("Цикл");
    }
}
