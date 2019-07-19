package jsonParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrimaryComponent {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream(new File("test.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		
		String finishedGood=sheet.getRow(1).getCell(0).getStringCellValue();
		int x=0;
		ArrayList<Double> lis=new ArrayList<Double>();
        while (rowIterator.hasNext())
        {
        	rowIterator.next();
        	x++;
        	
        }
        int count=0;
        
        for(int i=1;i<=x;i++)
        {
        	//int a=0;
        	try
        	{
        	if(finishedGood==sheet.getRow(i).getCell(0).getStringCellValue())
        	{
        		count++;
        	finishedGood=sheet.getRow(i).getCell(0).getStringCellValue();
        	lis.add(sheet.getRow(i).getCell(3).getNumericCellValue());
        	}
        	else
        	{
        		double k;
        		k=Collections.max(lis);
        		String primaryComponent="";
        		
        		for(int m=i-count;m<i;m++)
        		{
        			if(k==sheet.getRow(m).getCell(3).getNumericCellValue())
        			{
        			primaryComponent=sheet.getRow(m).getCell(1).getStringCellValue();
        			break;
        			}
        			
        		}
        		
        		
        		sheet.getRow(i-count).createCell(4);
        		sheet.getRow(i-count).getCell(4).setCellValue(primaryComponent);
        		sheet.getRow(i-count).createCell(5);
        		if(sheet.getRow(i-count).getCell(2).getStringCellValue()==primaryComponent)
        		{
        			
            		sheet.getRow(i-count).getCell(5).setCellValue("TRUE");
        		}
        		else
        			sheet.getRow(i-count).getCell(5).setCellValue("FALSE");
        		
        		count=1;
        		lis.clear();
        		finishedGood=sheet.getRow(i).getCell(0).getStringCellValue();
        		lis.add(sheet.getRow(i).getCell(3).getNumericCellValue());
        		
        	}
        	
        	}
        	catch (Exception e)
        	{
        		System.out.println(i);
        		e.printStackTrace();
        	}

        	
        }
        FileOutputStream fos=new FileOutputStream("test.xlsx");
        workbook.write(fos);
        fos.close();
        file.close();
		
		
		
	}

}