package com.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\NCS_ncsClCdsForQuery.txt");
        //입력 스트림 생성
        BufferedReader filereader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));

        StringBuilder textSb = new StringBuilder();
        int singleCh = 0;
        while ((singleCh = filereader.read()) != -1) {
//				System.out.print((char)singleCh);
            textSb.append((char) singleCh);
        }
        filereader.close();


        List<String> NCS_ncsClCds = new ArrayList();
        NCS_ncsClCds = Arrays.asList(textSb.toString().replace("\r", "").split("\n"));
//			Map jsonResutl = api.getResult("0201020103_18v2");
        String data = "";


        List tb = new ArrayList();

        tb.add("NCBT100");
        tb.add("NCBT110");
        tb.add("NCBT115");
        tb.add("NCBT110");
        tb.add("NCBT120");
        tb.add("NCBT130");
        tb.add("NCBT140");
        tb.add("NCBT150");
        tb.add("NCBT160");
        tb.add("NCBT170");
        tb.add("NCBT180");

        for (Object line : NCS_ncsClCds) {
            for (Object table : tb) {
                data = line.toString().trim();
//				System.out.println("SELECT * FROM " + table + " WHERE COMPT_UNIT_NO='" + data + "';");
                System.out.println("Delete FROM " + table + " WHERE COMPT_UNIT_NO='" + data + "';");
            }
            System.out.println();

//        }
//
//        for (Object table : tb) {
//            System.out.println("Delete FROM " + table + " WHERE COMPT_UNIT_NO in(");
//            for (Object line : NCS_ncsClCds) {
//                data = line.toString().trim();
//				System.out.println("'data',");
//            }
//
//            System.out.println(")");
//            System.out.println();

        }

    }
}