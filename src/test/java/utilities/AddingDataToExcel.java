package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddingDataToExcel 
{
	public static FileInputStream fi; 
	public static FileOutputStream fo;
	public static String xlfile=System.getProperty("user.dir")+"\\testData\\Output.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	
	public static void writeToExcel(int rowIndex, int clmIndex,String result) throws IOException 
    {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		worksheet=workbook.getSheetAt(0);
        XSSFRow row = worksheet.getRow(rowIndex); // Get row at specified index
        if (row == null)
        row = worksheet.createRow(rowIndex); // Create row if it doesn't exist
        row.createCell(clmIndex).setCellValue(result); 
        fo=new FileOutputStream(xlfile);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
	
	
}
