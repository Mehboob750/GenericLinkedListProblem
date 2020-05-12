package com.genericsexample;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile <T extends Comparable>{
        final String PATH="sample.csv";
        LinkedList linkedList = new LinkedList();
        public List<String []> read() throws Exception{
            List<String[]> list=null;
            try {
                Reader reader = Files.newBufferedReader(Paths.get(PATH));
                list = new ArrayList<>();
                CSVReader csvReader = new CSVReader(reader);
                String records[];
                while ((records = csvReader.readNext()) != null) {
                    list.add(records);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return list;
        }

        public LinkedList copyToLinkedList(List<String[]> list){
            for(String [] string: list){
                for (String element:string){
                    linkedList.insert(element);
                }
            }
            return linkedList;
        }

    public String searchElement(Object data) throws Exception {
            if((linkedList.search(data))==true) {
                linkedList.remove(data);
                writeIntoCSV();
                return "Search and Deleted";
            }else {
                linkedList.insert(data);
                writeIntoCSV();
                return "Added and Saved";
            }
    }

    public void writeIntoCSV()throws Exception{
        List<String[] > list= new ArrayList<String[]>();
        CSVWriter csvWriter = new CSVWriter(new FileWriter("sample1.csv"));
        for(int iterator = 1;iterator<linkedList.listSize()-1;iterator++) {
            String content=(String) this.linkedList.getElement(iterator);
            String[] string=content.split(" ");
            list.add(string);
        }
        for(String[] element :list) {
            csvWriter.writeNext(element);
        }
        csvWriter.close();
    }
}

