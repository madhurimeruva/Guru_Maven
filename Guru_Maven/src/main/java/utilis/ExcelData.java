package utilis;

public class ExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projectPath = System.getProperty("user.dir");

		ExcelUtilis excel = new ExcelUtilis(projectPath + "/excel/data.xlsx", "sheet1");

		excel.getRowCount();

		excel.getColumnCount();

		excel.getCellDataString(0, 0);

		excel.getCellDataNumber(2, 1);

	}

}
