package pl.sda;

import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class BalanceReader {

    private static final String FILE_PATH = "C:\\Users\\Robert\\Downloads\\budzet_kowalskich.xls";


    BalanceData read() throws IOException, InvalidFormatException {

        BalanceData result = new BalanceData();

        try (InputStream inp = new FileInputStream(FILE_PATH)) { // try bez catch.
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0); // wybieram arkusz zero
            for (int i = 1; i < sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                BigDecimal income = getCellValue(row, 1);
                BigDecimal outcome = getCellValue(row, 3);



                System.out.println("Dochód: " + income);
                System.out.println("Wydatek: " + outcome);

                if (!income.equals(BigDecimal.ZERO))
                result.getIncomes().add(income);

                if(!outcome.equals(BigDecimal.ZERO))
                result.getOutcomes().add(outcome);
            }
        }
        return result;
    }


    private BigDecimal getCellValue(Row row, int columnNumber) {
        Cell cell = row.getCell(columnNumber);
        return !cell.toString().isEmpty() ?
                new BigDecimal(cell.toString()) : BigDecimal.ZERO;
    }

}