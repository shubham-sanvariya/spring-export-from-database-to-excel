package com.springframework.springexporttoexcel.service;

import com.springframework.springexporttoexcel.domain.Customer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelExportService {
    private XSSFWorkbook workBook;
    private XSSFSheet sheet;
    private List<Customer> customerList;

    public ExcelExportService(List<Customer> customerList) {
        this.customerList = customerList;
        workBook = new XSSFWorkbook();
    }

    private void createCells(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if (value instanceof Double){
            cell.setCellValue((Double) value);
        }else if (value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long){
            cell.setCellValue((Long) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
