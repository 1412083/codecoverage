package com.example.khangduyle.calculatorv2;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHANGDUYLE on 07/12/2017.
 */

public class readCSV {

    public final List<String[]> readCsv(String name) {
        List<String[]> questionList = new ArrayList<String[]>();


        try {
            InputStream csvStream = this.getClass().getClassLoader().getResourceAsStream(name);


            InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
            CSVReader csvReader = new CSVReader(csvStreamReader);
            String[] line;

            // throw away the header
            csvReader.readNext();

            while ((line = csvReader.readNext()) != null) {
                questionList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }
}
