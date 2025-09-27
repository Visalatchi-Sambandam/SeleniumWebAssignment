package assignment.utils;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	 public static Object[][] getExcelData(String filePath, String sheetName) {
	        Object[][] data = null;

	        try (FileInputStream fis = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	         // each row returns 1 HashMap
	            data = new Object[rowCount - 1][1]; 

	         // start from row index 1 (row 0 = header)
	            for (int i = 1; i < rowCount; i++) {
	                XSSFRow row = sheet.getRow(i);
	                HashMap<String, String> map = new HashMap<>();

	             // iterate through all columns
	                for (int j = 0; j < colCount; j++) {
	                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
	                    String value = row.getCell(j).getStringCellValue();
	                    map.put(key, value);
	                }
	                //store hashmap in Object[][]
	                data[i - 1][0] = map;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }

}
