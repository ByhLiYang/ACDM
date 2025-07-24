package com.hq.acdm.util.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jxls.common.Context;
import org.jxls.transform.poi.WritableCellValue;

/**
 * 自定义背景颜色单元格，根据单元格的值来显示
 * @author chendd
 */
public class MergeCellValue implements WritableCellValue {

	private String value;
	private Integer mergerRows;
	
	
	public MergeCellValue(String value , Integer mergerRows){
		this.value = value;
		this.mergerRows = mergerRows;
	}
	
	//报错的原因是由于当前单元格已经与下一行进行了合并
	@Override
	public Object writeToCell(Cell cell, Context context) {
		cell.setCellValue(value);
		if(mergerRows == null || mergerRows.intValue() <= 1){
			return cell;
		}
		int rowIndex = cell.getRowIndex();
		Sheet sheet = cell.getSheet();
		int cellIndex = cell.getColumnIndex();
		System.out.println(value);
		System.out.println("起始行号:"+rowIndex);
		System.out.println("终止行号:"+(rowIndex+ mergerRows.intValue()- 1));
		System.out.println("起始列号:"+cellIndex);
		System.out.println("终止列号:"+cellIndex);
		/*sheet.autoSizeColumn(cellIndex,true);
		int old=sheet.getColumnWidth(cellIndex);
		int news=value.getBytes().length*2*256;
		if(news>old)
		sheet.setColumnWidth(cellIndex,news);*/
		sheet.addMergedRegion(
				new CellRangeAddress(rowIndex , rowIndex+ mergerRows.intValue()- 1, cellIndex, cellIndex));
		return cell;
	}
	
}
