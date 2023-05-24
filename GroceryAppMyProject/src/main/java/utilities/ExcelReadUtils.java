package utilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtils {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;

	public static String read(String sheetname,int i, int j) {
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\excel.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {

			throw new RuntimeException("enable to read test data file");
		}

		ws = wb.getSheet(sheetname);
		Row r = ws.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();

	}

}
