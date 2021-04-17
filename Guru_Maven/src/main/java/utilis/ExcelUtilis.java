package utilis;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilis {

	static XSSFWorkbook workbook;

	static XSSFSheet sheet;

	public ExcelUtilis(String excelPath, String sheetName) {
		try {

			workbook = new XSSFWorkbook(excelPath);

			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 *
	 * getRowCount();
	 *
	 * getCellDataString(0, 1);
	 *
	 * getCellDataNumber(1, 1); }
	 */

	public static int getRowCount() {

		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();

			System.out.println("Total Number of rows: " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return rowCount;

	}

	public static int getColumnCount() {

		int colCount = 0;

		XSSFRow row = sheet.getRow(0);
		colCount = row.getLastCellNum();

		System.out.println("Number of columns:" + colCount);

		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {

		String cellData = null;
		try {

			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			// System.out.println("The data on the cell is: " + cellData);

		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return cellData;
	}

	public static double getCellDataNumber(int rowNum, int colNum) {

		double cellDataNum = 0;

		try {

			cellDataNum = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

			System.out.println("The data on the cell 1 is: " + cellDataNum);

		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return cellDataNum;

	}
}
