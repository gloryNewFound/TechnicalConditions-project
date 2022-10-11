package techconditions;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public abstract class XLSFileCreator {

    private static int rowNumber = 1;
    private static Sheet sheet;
    private static Workbook workbook = new HSSFWorkbook();

    private static String fileName;

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void createXLSXFile(String path){

        sheet = workbook.createSheet("Table");

        //To fill title of the fields for each column
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("№");
        sheet.setColumnWidth(0, 1000);
        row0.createCell(1).setCellValue("Файл");
        sheet.setColumnWidth(1, 7000);
        row0.createCell(2).setCellValue("Адрес");
        sheet.setColumnWidth(2, 10000);
        row0.createCell(3).setCellValue("Кадастр");
        sheet.setColumnWidth(3, 5000);
        row0.createCell(4).setCellValue("РЭС");
        sheet.setColumnWidth(4, 5000);
        row0.createCell(5).setCellValue("ФИО");
        sheet.setColumnWidth(5, 9000);
        row0.createCell(6).setCellValue("Номер договора");
        sheet.setColumnWidth(6, 7000);
        row0.createCell(7).setCellValue("Пункт 7.1");
        sheet.setColumnWidth(7, 5000);
        row0.createCell(8).setCellValue("Номинал автомата, А");
        sheet.setColumnWidth(8, 5000);
        row0.createCell(9).setCellValue("Тариф (из 10)");
        sheet.setColumnWidth(9, 3000);
        row0.createCell(10).setCellValue("Тариф (из 19)");
        sheet.setColumnWidth(10, 3000);
        row0.createCell(11).setCellValue("Фазность: ");
        sheet.setColumnWidth(11, 5000);
        row0.createCell(12).setCellValue("Тип включения");
        sheet.setColumnWidth(12, 5000);
        row0.createCell(13).setCellValue("Мощность, кВт");
        sheet.setColumnWidth(13, 3000);

        //To make width of each column according to the first cell content.
//        for (int i = 0; i < 12; i++) {
//            sheet.autoSizeColumn(i);
//        }

        //To create Excel file in the path directory
        Date date = new Date();
        fileName = "." + date.toString().replaceAll(" ", "_").replaceAll(":", "_") + "_table.xls";
        System.out.println(path + "\\" + fileName);
        try (FileOutputStream outputStream = new FileOutputStream(path + "\\" + fileName))
        {
            workbook.write(outputStream);
        } catch (IOException e) {
            System.out.println("Исключение в IOException: " + e.getStackTrace());
        }
    }

    public static void fillFields(TechConditionDocument document, String path) {
        Row row = sheet.createRow(rowNumber);

        row.createCell(0).setCellValue(document.getCounter());
        row.createCell(1).setCellValue(document.getFile());
        row.createCell(2).setCellValue(document.getAddressAndKadastr().getAddress());
        row.createCell(3).setCellValue(document.getAddressAndKadastr().getKadastr());
        row.createCell(4).setCellValue(document.getRes());
        row.createCell(5).setCellValue(document.getFullName());
        row.createCell(6).setCellValue(document.getNumberOfContract());
        row.createCell(7).setCellValue(document.getPointSevenOne());
        row.createCell(8).setCellValue(document.getAutomatCurrent());
        row.createCell(9).setCellValue(document.getTariffFrom10());
        row.createCell(10).setCellValue(document.getTariffFrom19());
        row.createCell(11).setCellValue(document.getPhase());
        row.createCell(12).setCellValue(document.getTypeOfInclusion());
        row.createCell(13).setCellValue(document.getPower());
        try (FileOutputStream outputStream = new FileOutputStream(path + "\\" + fileName))
        {
            workbook.write(outputStream);
        } catch (IOException e) {
            System.out.println("Исключение в IOException: " + e.getStackTrace());
        }
        rowNumber = ++rowNumber;
    }
}
