package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws IOException {

		File src = new File("C:\\javaprac\\Guru_Maven\\excel\\data.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		int sheetCount = wb.getNumberOfSheets();

		System.out.println("Number of sheets present are :" + sheetCount);

		XSSFRow row = sheet.getRow(0);

		int rowCount = sheet.getLastRowNum();

		System.out.println("Total number of rows present are: " + rowCount);

		int colCount = row.getLastCellNum();

		System.out.println("Total number of columns present are :" + colCount);

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {

				String data = sheet.getRow(i).getCell(j).getStringCellValue();

				System.out.print(data + " || ");
			}
			System.out.println();
		}
	}

}
