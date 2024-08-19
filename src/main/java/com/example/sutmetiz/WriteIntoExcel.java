package com.example.sutmetiz;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

public class WriteIntoExcel {
    public void writeIntoExcel(String path, Map<Integer, String> nomenclature, Map<Integer, String> nomenclatureQuantity, Map<Integer, String> result,Map<String, Integer> itogo ) throws FileNotFoundException, IOException {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 9000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Номенклатура");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Кол-во");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("СУТ и метизы");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        int i = 1;
        while (i <= nomenclature.size()) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(nomenclature.get(i));
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(nomenclatureQuantity.get(i));
            cell.setCellStyle(style);
            if(result.containsKey(i)){
                cell = row.createCell(2);
                cell.setCellValue(result.get(i));
                cell.setCellStyle(style);
            }
            i++;
        }
        for (Map.Entry<String, Integer> entry : itogo.entrySet()) {
            if (!Pattern.compile("Соединители необходимо посчитать в позиции.*").matcher(entry.getKey()).find()) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(entry.getKey());
                cell.setCellStyle(style);
                cell = row.createCell(1);
                cell.setCellValue(entry.getValue());
                cell.setCellStyle(style);
                i++;}
        }

        for (Map.Entry<String, Integer> entry : itogo.entrySet()) {
            if (Pattern.compile("Соединители необходимо посчитать в позиции.*").matcher(entry.getKey()).find()) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
            cell.setCellValue(entry.getKey());
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(entry.getValue());
            cell.setCellStyle(style);
            i++;}
        }

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
