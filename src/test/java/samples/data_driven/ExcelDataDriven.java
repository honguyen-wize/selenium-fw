package samples.data_driven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelDataDriven {

    @DataProvider
    public Object[] getData() throws IOException {

        String dataSheetName = "testdata";
        String testDataName = "Purchase";
        int testcaseColum = 0;

        ArrayList<String> getDataFromExcel = getDataFromExcel(dataSheetName, testDataName, testcaseColum);
        return getDataFromExcel.toArray();
    }

    @Test (dataProvider = "getData")
    public void testExcelDataDriven(String data){
        System.out.println(data);
    }

    public static ArrayList<String> getDataFromExcel(String dataSheetName, String testcaseName, int testcaseColum) throws IOException {
        ArrayList<String> testdata = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("src/test/java/samples/data_driven/demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet datasheet = null;

        // get right sheet
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(dataSheetName)) {
                datasheet = workbook.getSheetAt(i);
                break;
            }
        }

        // get data of the found row
        Iterator<Row> rows = datasheet.iterator();// sheet is collection of rows
        while (rows.hasNext()) {
            Row r = rows.next();
            if (r.getCell(testcaseColum).getStringCellValue().equalsIgnoreCase(testcaseName)) {

                //Found the test case row => pull all the data of that row and feed into test
                Iterator<Cell> cv = r.cellIterator();
                while (cv.hasNext()) {
                    Cell c = cv.next();
                    testdata.add(c.getStringCellValue().toString());
                }
            }
        }

        return testdata;
    }

//        public static void main(String[] arg) throws IOException {
//        String dataSheetName = "testdata";
//        String testDataName = "Purchase";
//        int testcaseColum = 0;
//        // ArrayList<String> data = getData(dataSheetName, testDataName);
//        ArrayList<String> getDataFromExcel = getDataFromExcel(dataSheetName, testDataName, testcaseColum);
//    }

//    public static ArrayList<String> getData(String dataSheetName, String testcaseName) throws IOException {
//
//        ArrayList<String> a = new ArrayList<String>();
//
//        FileInputStream fis = new FileInputStream("src/test/java/samples/data_driven/demodata.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//
//        int sheets = workbook.getNumberOfSheets();
//        for (int i = 0; i < sheets; i++) {
//            if (workbook.getSheetName(i).equalsIgnoreCase(dataSheetName)) {
//                XSSFSheet sheet = workbook.getSheetAt(i);
//                //Identify Testcases column by scanning the entire 1st row
//
//                Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
//                Row firstrow = rows.next();
//                Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
//                int k = 0;
//                int coloumn = 0;
//                while (ce.hasNext()) {
//                    Cell value = ce.next();
//
//                    if (value.getStringCellValue().equalsIgnoreCase(testcaseName)) {
//                        coloumn = k;
//
//                    }
//
//                    k++;
//                }
//                System.out.println(coloumn);
//
//                ////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
//                while (rows.hasNext()) {
//
//                    Row r = rows.next();
//
//                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
//
//                        ////after you grab purchase testcase row = pull all the data of that row and feed into test
//                        Iterator<Cell> cv = r.cellIterator();
//                        while (cv.hasNext()) {
//                            Cell c = cv.next();
//                            a.add(c.getStringCellValue().toString());
//                        }
//                    }
//                }
//            }
//        }
//
//        return a;
//    }
}
