package cn.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {
	@Test
	public void test1() throws FileNotFoundException, IOException {
		String path = "F:\\java\\就业\\11、物流BOS系统\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.println(cell.getStringCellValue());
			}
		}
		
	}
}
