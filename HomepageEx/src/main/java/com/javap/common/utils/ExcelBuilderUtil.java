package com.javap.common.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

@SuppressWarnings("deprecation")
public class ExcelBuilderUtil extends AbstractExcelView {
	protected Log log = LogFactory.getLog(ExcelBuilderUtil.class);
	
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String,Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		// get data model with is passed by the spring container
		List<Map<String, Object>> list = (List<Map<String,Object>>)model.get("list");

		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Board List");
		sheet.setDefaultColumnWidth(15);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		// create a header row
		HSSFRow header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("번호");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("제목");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("히트수");
		header.getCell(2).setCellStyle(style);
		
		header.createCell(3).setCellValue("작성일");
		header.getCell(3).setCellStyle(style);
		
		// create data rows
		int rowCount = 1;
		
		for(Map<String, Object> record : list){
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue((int)record.get("IDX"));
			aRow.createCell(1).setCellValue((String)record.get("TITLE"));
			aRow.createCell(2).setCellValue((int)record.get("HIT_CNT"));
			aRow.createCell(3).setCellValue(record.get("CREATE_DTM").toString());
		}
	}
}