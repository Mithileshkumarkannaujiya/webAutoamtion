package excelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil {

	public static void getAllData(String filePath, String sheetName) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		Sheet sheetObj = workBook.getSheet(sheetName);
		Row rowObj = sheetObj.getRow(1);
		int cellNum = rowObj.getLastCellNum();
		for (int i = 0; i <= cellNum - 1; i++) {
			Cell cellObj = rowObj.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String cellDataValue = cellObj.getStringCellValue();
			System.out.println(cellDataValue);
		}
	}

	public Map<String, String> getTestcase(String filePath, String testCaseId) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		Sheet sheetObj = workBook.getSheet("TestData");
		int rowNumber = getRowNumber(sheetObj, testCaseId);
		Map<String, String> dataMap = new HashMap<String, String>();
		int columnNumber = getColumnNumberByColumnName(sheetObj, "DataName1");
		Row rowObj = sheetObj.getRow(rowNumber);
		int cellCount = rowObj.getLastCellNum();
		for (int i = columnNumber; i <= cellCount - 1; i = i + 2) {
			Cell cellDataKey = rowObj.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			Cell cellDataValue = rowObj.getCell(i + 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String key = cellDataKey.getStringCellValue();
			String value = cellDataValue.getStringCellValue();
			dataMap.put(key, value);
		}
		return dataMap;

	}

	public int getColumnNumberByColumnName(Sheet sheet, String columnName) {

		Row rowObj = sheet.getRow(0);
		int cellCount = rowObj.getLastCellNum();
		int cellNumber = -1;
		for (int i = 0; i <= cellCount - 1; i++) {
			Cell cellObj = rowObj.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cellObj.getStringCellValue().equalsIgnoreCase(columnName)) {
				cellNumber = i;
			}
		}
		return cellNumber;
	}

	public int getRowNumber(Sheet sheet, String rowName) {
		int columnNum = getColumnNumberByColumnName(sheet, "TcId");
		int rowCount = sheet.getLastRowNum();
		int rowNumber = -1;
		for (int i = 0; i <= rowCount; i++) {
			Row rowObj = sheet.getRow(i);
			Cell cellObj = rowObj.getCell(columnNum);
			String roData = cellObj.getStringCellValue();
			if (cellObj.getStringCellValue().equalsIgnoreCase(rowName)) {
				rowNumber = i;
			}
		}
		return rowNumber;
	}

	public static void main(String[] args) throws IOException {
		ExcelDataUtil data =new ExcelDataUtil();
		InputStream inputStream = new FileInputStream("src\\test\\resources\\data\\VtigerTestCase.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		Sheet sheetObj = workBook.getSheet("TestData");
		int num =data.getRowNumber(sheetObj,"TCID_003_To_validate_deletingthefunctionalityofmarkting Lead");
//		System.out.println(num);
		
int datacln=data.getColumnNumberByColumnName(sheetObj, "DataName2");
		
		System.out.println(datacln);
		
		int datacl=data.getColumnNumberByColumnName(sheetObj, "DataValue3");
		System.out.println(datacl);
	}
	
}