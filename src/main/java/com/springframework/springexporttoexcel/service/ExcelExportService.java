package com.springframework.springexporttoexcel.service;

import com.springframework.springexporttoexcel.domain.Customer;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelExportService {
    private XSSFWorkbook workBook;
    private XSSFSheet sheet;
    private List<Customer> customerList;

    public ExcelExportService(List<Customer> customerList) {
        this.customerList = customerList;
        workBook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
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

    private void createHeaderRow(){
        sheet = workBook.createSheet("Customer Information");
        Row row = sheet.createRow(0);
        CellStyle style = workBook.createCellStyle();
        XSSFFont font = workBook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Customer Information",style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
        font.setFontHeightInPoints((short) 10);

        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row,0,"ID", style);
        createCell(row,1,"First Name", style);
        createCell(row,2,"Last Name", style);
        createCell(row,3,"Email", style);
        createCell(row,4,"Country", style);
        createCell(row,5,"State", style);
        createCell(row,6,"City", style);
        createCell(row,7,"Address", style);
    }

    private void writeCustomerData(){
        int rowCount = 2;
        CellStyle style = workBook.createCellStyle();
        XSSFFont font = workBook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Customer customer : customerList){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++,customer.getId(),style);
            createCell(row, columnCount++,customer.getFirstName(),style);
            createCell(row, columnCount++,customer.getLastName(),style);
            createCell(row, columnCount++,customer.getEmail(),style);
            createCell(row, columnCount++,customer.getAddress().getCountry(),style);
            createCell(row, columnCount++,customer.getAddress().getState(),style);
            createCell(row, columnCount++,customer.getAddress().getCity(),style);
            createCell(row, columnCount++,customer.getAddress().getAddress(),style);
        }
    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        createHeaderRow();
        writeCustomerData();
        ServletOutputStream outputStream = response.getOutputStream();
        workBook.write(outputStream);
        workBook.close();
        outputStream.close();
    }
}
