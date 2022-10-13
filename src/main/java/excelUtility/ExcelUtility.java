package excelUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static int getColumnNumber(Sheet sheet, String columnName) {
		Row rowobj = sheet.getRow(0);
		int columnnumber = -1;
		int currentCellNumber = rowobj.getLastCellNum();
		for (int j = 0; j <= currentCellNumber; j++) {
			Cell cellobj = rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String columnData = cellobj.getStringCellValue();
			if (columnData.equals(columnName)) {
				columnnumber = j;
			}
		}
		return columnnumber;
	}

	public static int getRowNumbers(Sheet sheetobj, String testcaseId) {
		int columnnum = getColumnNumber(sheetobj, "TcId");
		int countRow = sheetobj.getLastRowNum();
		int rowNumber = -1;
		for (int i = 0; i <= countRow; i++) {
			Row rowobj = sheetobj.getRow(i);
			Cell cellData = rowobj.getCell(columnnum, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cellData.getStringCellValue().equals(testcaseId)) {
				rowNumber = i;
			}
		}
		return rowNumber;
	}

	public static Map<String, String> getTestCaseData(String filePath, String testCaseId) throws IOException {
		ExcelUtility exceldata = new ExcelUtility();
		InputStream fis = new FileInputStream(filePath);
		Workbook workbookObj = null;
		String[] path = filePath.split("\\.");
		String fileExe = path[1];
		if (fileExe.equalsIgnoreCase("xlsx")) {
			workbookObj = new XSSFWorkbook(fis);
		} else if (fileExe.equalsIgnoreCase("xls")) {
			workbookObj = new HSSFWorkbook(fis);
		}
		Sheet sheetobj = workbookObj.getSheet("TestData");
		Map<String, String> dataMap = new HashMap<String, String>();
		int rowNumber = getRowNumbers(sheetobj, testCaseId);
		int columnnum = getColumnNumber(sheetobj, "DataName1");
		Row rowObj = sheetobj.getRow(rowNumber);
		int cellNumber = rowObj.getLastCellNum();
		for (int i = columnnum; i <= cellNumber - 1; i = i + 2) {
			Cell cellData = rowObj.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			Cell cellValue = rowObj.getCell(i + 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String dataname = cellData.getStringCellValue();
			String datavalue = cellValue.getStringCellValue();

			dataMap.put(dataname, datavalue);

		}
		return dataMap;
	}

	public static void main(String[] args) throws IOException {
		getTestCaseData("src\\test\\resources\\data\\VtigerTestCase.xlsx", "TCID_002ValidateCreatenewMarketingLead");

		
		
	}
}
