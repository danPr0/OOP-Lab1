import entity.Cell;
import frame.MyFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.TableService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EvalTest {
    TableService tableService;
    List<List<Cell>> table;

    @BeforeEach
    public void beforeEach() {
        tableService = new TableService(new MyFrame(), 5, 5, 20, 20);
        table = tableService.getTable();
    }

    @Test
    public void test1() {
        Cell cell1 = table.get(0).get(0);
        Cell cell2 = table.get(1).get(1);

        cell1.setExpression("3^2");
        tableService.parseRecursion(cell1, cell1.getExpression());

        cell2.setExpression("inc(" + cell1.getLink() + ")");
        tableService.parseRecursion(cell2, cell2.getExpression());

        assertEquals(cell2.getResult(), 10);

        cell1.setExpression("2 * 3.3");
        tableService.parseRecursion(cell1, cell1.getExpression());

        assertEquals(cell2.getResult(), 7.6);
    }

    @Test
    public void test2() {
        Cell cell1 = table.get(0).get(0);
        Cell cell2 = table.get(1).get(1);
        Cell cell3 = table.get(2).get(2);
        Cell cell4 = table.get(3).get(3);

        cell1.setExpression("inc(" + cell2.getLink() + ")");
        tableService.parseRecursion(cell1, cell1.getExpression());

        cell2.setExpression(cell3.getLink() + "mod 5");
        tableService.parseRecursion(cell2, cell2.getExpression());

        cell3.setExpression("dec(" + cell4.getLink() + ")");
        tableService.parseRecursion(cell3, cell3.getExpression());

        cell4.setExpression("3^2");
        tableService.parseRecursion(cell4, cell4.getExpression());

        assertEquals(cell1.getResult(), 4);
        assertEquals(cell2.getResult(), 3);
        assertEquals(cell3.getResult(), 8);
        assertEquals(cell4.getResult(), 9);
    }

    @Test
    public void test3() {
        Cell cell1 = table.get(0).get(0);
        Cell cell2 = table.get(1).get(1);
        Cell cell3 = table.get(2).get(2);

        cell1.setExpression(cell2.getLink() + " * 2.5");
        tableService.parseRecursion(cell1, cell1.getExpression());

        cell2.setExpression(cell3.getLink() + "- 1");
        tableService.parseRecursion(cell2, cell2.getExpression());

        cell3.setExpression("-5 / 2");
        tableService.parseRecursion(cell3, cell3.getExpression());

        assertEquals(cell1.getResult(), -8.75);

        cell3.setExpression("");
        cell3.setResult((Double) null);
        tableService.getValues().remove(cell3.getLink());
        tableService.parseRecursion(cell3, cell3.getExpression());

        assertNull(cell1.getResult());
        assertNull(cell2.getResult());
        assertNull(cell3.getResult());
    }
}
