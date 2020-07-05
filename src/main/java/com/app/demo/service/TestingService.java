package com.app.demo.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Service
public class TestingService {
    private int questionsCount = 0;
    private List<String> answers = Arrays.asList("a", "b", "c");
    private List<String[]> questions;

    public List<String> getAnswers() {
        return answers;
    }

    public List<String[]> getQuestions() {
        return questions;
    }

    public List<String[]> prepareQuestionsFromCSV() {
        try {
            ClassPathResource classPathResource = new ClassPathResource("/CSVTest.csv");
            InputStream inputStream = classPathResource.getInputStream();
            CSVParser parser = (new CSVParserBuilder()).withSeparator(';').build();
            CSVReader reader = (new CSVReaderBuilder(new InputStreamReader(inputStream))).withSkipLines(1).withCSVParser(parser).build();
            questions = reader.readAll();
            return questions;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showQuestionsFromRow(String[] row) {
        if (row == null || row.length < 4)
            throw new IllegalArgumentException("Array length < 4 or null");

        System.out.println(row[0]);
        System.out.println(row[1]);
        System.out.println(row[2]);
        System.out.println(row[3]);
        System.out.println("---------------------------------------------");
    }
}
