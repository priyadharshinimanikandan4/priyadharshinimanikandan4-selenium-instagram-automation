package instagram.instagram;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Object[][] readd(String Location)
    {
    	Object[][] f = null;
    	try {
    		FileInputStream fis = new FileInputStream("src/test/java/testdata/" + Location + ".xlsx");   		Workbook w = new XSSFWorkbook(fis);
    		Sheet s = w.getSheetAt(0);
    		int r = s.getPhysicalNumberOfRows();
    		int c = s.getRow(0).getPhysicalNumberOfCells();
    		
    		f = new Object[r-1][c];
    		
    		for(int i = 1;i<r;i++) {
    			for(int j = 0;j<c;j++) {
    				f[i-1][j] = s.getRow(i).getCell(j).toString();
    			}
    		}
    	}
    		
    		catch(Exception e) {
    			e.printStackTrace();
    		}
  		
    	
    	return f;
    }
}
