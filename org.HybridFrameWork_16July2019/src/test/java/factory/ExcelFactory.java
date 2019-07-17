/**
 * 
 */
package factory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lenovo
 *
 */
public class ExcelFactory {

	FileInputStream fis;

	XSSFWorkbook wb;

	public ExcelFactory() {

		String path = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";

		File src = new File(path);

		try {
			fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println("Unable to load excel data");

			System.out.println(e.getMessage());

		}

	}

	public int getRows(String sheetname) {

		int rows = wb.getSheet(sheetname).getPhysicalNumberOfRows();

		return rows;
	}

	public int getColumns(String sheetname) {

		int columns = wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();

		return columns;
	}
	
	public String getData(String sheetname, int row, int column){
		
		XSSFCell cell = wb.getSheet(sheetname).getRow(row).getCell(column);
		
		DataFormatter df = new DataFormatter();
		
		String data = df.formatCellValue(cell);
		
		return data;
		
	}
	
}
