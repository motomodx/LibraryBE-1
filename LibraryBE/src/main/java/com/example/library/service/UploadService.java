package com.example.library.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.model.BookTabStruct;

import com.example.library.repository.excelReadRepo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
@Service
public class UploadService {
	
	@Autowired
	excelReadRepo ExcelRead; 
	
	public List<BookTabStruct> readBooksData() throws IOException {
		return ExcelRead.bookReader();
	}

	public void excelUpdateService(BookTabStruct obj) throws IOException {
		System.out.println("InsideexcelUpdateService ");
		ExcelRead.excelUpdater(obj);
	}
	
	
	 
	/*public static List<Map<String, String>> upload() throws Exception{
		// TODO Auto-generated method stub
		String filePath ="C:\\excelPath";
		MultipartFile file = filePath. ;
		Path tempDir = Files.createTempDirectory("");
		
		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
		
		file.transferTo(tempFile);
		
		Workbook workbook = WorkbookFactory.create(tempFile);
		
		Sheet sheet = workbook.getSheetAt(0);
		Supplier<Stream<Row>> rowStreamSupplier = uploadUtil.getRowStreamSupplier(sheet);
		
		Row headerRow = rowStreamSupplier.get().findFirst().get();
		
		List<String> headerCells = StreamSupport.stream(headerRow.spliterator(), false)
				                   .map(Cell::getStringCellValue)
				                   .collect(Collectors.toList());
		
		int colCount = headerCells.size();
		
		System.out.println(headerCells);
		
		return rowStreamSupplier.get().map(row -> {
			
			//Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);
			
			List<String> cellList = StreamSupport.stream(row.spliterator(),false).map(Cell::getStringCellValue)
					                  .collect(Collectors.toList());
		
			 return IntStream.range(0 , colCount).boxed()
					                       .collect(Collectors
					                    		   .toMap(index -> headerCells.get(index) , index -> cellList.get(index)));
			              
			
			 
		}).collect(Collectors.toList());
		
	}
*/
/*	public static JsonObject getExcelDataAsJsonObject(File excelFile) {

	    JsonObject sheetsJsonObject = new JsonObject();
	    Workbook workbook = null;

	    try {
	        workbook = new XSSFWorkbook(excelFile);
	    } catch (InvalidFormatException | IOException e) {
	        TestLogUtils.logErrorMessage(
	                "ExcelUtils -> getExcelDataAsJsonObject() :: Exception thrown constructing XSSFWorkbook from provided excel file.  InvalidFormatException | IOException => "
	                        + TestLogUtils.convertStackTraceToString(e));
	    }

	    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

	        JsonArray sheetArray = new JsonArray();
	        ArrayList<String> columnNames = new ArrayList<String>();
	        Sheet sheet = workbook.getSheetAt(i);
	        Iterator<Row> sheetIterator = sheet.iterator();

	        while (sheetIterator.hasNext()) {

	            Row currentRow = sheetIterator.next();
	            JsonObject jsonObject = new JsonObject();

	            if (currentRow.getRowNum() != 0) {

	                for (int j = 0; j < columnNames.size(); j++) {

	                    if (currentRow.getCell(j) != null) {
	                        if (currentRow.getCell(j).getCellTypeEnum() == CellType.STRING) {
	                            jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getStringCellValue());
	                        } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.NUMERIC) {
	                            jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getNumericCellValue());
	                        } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.BOOLEAN) {
	                            jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getBooleanCellValue());
	                        } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.BLANK) {
	                            jsonObject.addProperty(columnNames.get(j), "");
	                        }
	                    } else {
	                        jsonObject.addProperty(columnNames.get(j), "");
	                    }

	                }

	                sheetArray.add(jsonObject);

	            } else {
	                // store column names
	                for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
	                    columnNames.add(currentRow.getCell(k).getStringCellValue());
	                }
	            }

	        }

	        sheetsJsonObject.add(workbook.getSheetName(i), sheetArray);

	    }

	    return sheetsJsonObject;

	}
private static void collect(Collector<Object, ?, List<Object>> list) {
	// TODO Auto-generated method stub
	
}*/

}
