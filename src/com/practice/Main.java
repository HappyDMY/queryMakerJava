package com.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main<Static> {

	public static void main(String[] args)  {
//	    String fileName1 = "E:\\NCS\\신안산대\\SECTION_CD.txt";
//		getSectinoQuery(fileName1);
//
//	    String fileName2 = "E:\\NCS\\신안산대\\SUB_SECTION_CD.txt";
//		getSubSectinoQuery(fileName2);

	    String fileName3 = "E:\\NCS\\신안산대\\ncsComptUnitNos.txt";
		getExtraQeury(fileName3);

	}
	public Main(){}

    public static void getSubSectinoQuery(String fileName) {
	    File file = new File(fileName);
	    //입력 스트림 생성
	    BufferedReader filereader = null;
	    try {
		    filereader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));


		    StringBuilder textSb = new StringBuilder();
		    int singleCh = 0;
		    while ((singleCh = filereader.read()) != -1) {
//				System.out.print((char)singleCh);
			    textSb.append((char) singleCh);
		    }
		    filereader.close();

		    List<String> rowDataList = new ArrayList();
		    rowDataList = Arrays.asList(textSb.toString().replace("\r", "").split("\n"));
		    String data = "";


		    System.out.println("--세분류 insert해야할 목록 조회 쿼리------------");



		    for (Object line : rowDataList) {
			    String a = line.toString().substring(0,2);
			    String b = line.toString().substring(2,4);
			    String c = line.toString().substring(4,6);
			    String d = line.toString().substring(6,8);

			    if (rowDataList.indexOf(line)==rowDataList.size()-1){
				    System.out.println("SELECT * FROM NCBT040 WHERE NCS_DIV='N'AND CATEGORY_CD='"+a+"' AND DIVISION_CD='"+b+"' AND SECTION_CD='"+c+"' AND SUB_SECTION_CD='"+d+"'");

			    }else{
				    System.out.println("SELECT * FROM NCBT040 WHERE NCS_DIV='N'AND CATEGORY_CD='"+a+"' AND DIVISION_CD='"+b+"' AND SECTION_CD='"+c+"' AND SUB_SECTION_CD='"+d+"' UNION ALL");
			    }



		    }

	    } catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }

	}

    public static void getSectinoQuery(String fileName) {
		File file = new File(fileName);
		//입력 스트림 생성
		BufferedReader filereader = null;
		try {
			filereader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));


			StringBuilder textSb = new StringBuilder();
			int singleCh = 0;
			while ((singleCh = filereader.read()) != -1) {
//				System.out.print((char)singleCh);
				textSb.append((char) singleCh);
			}
			filereader.close();

			List<String> rowDataList = new ArrayList();
			rowDataList = Arrays.asList(textSb.toString().replace("\r", "").split("\n"));
			String data = "";

			System.out.println("--소분류 insert해야할 목록 조회 쿼리------------");



			for (Object line : rowDataList) {
				String a = line.toString().substring(0,2);
				String b = line.toString().substring(2,4);
				String c = line.toString().substring(4,6);

				if (rowDataList.indexOf(line)==rowDataList.size()-1){
					System.out.println("SELECT * FROM NCBT030 WHERE NCS_DIV='N'AND CATEGORY_CD='"+a+"' AND DIVISION_CD='"+b+"' AND SECTION_CD='"+c+"'");

				}else{
					System.out.println("SELECT * FROM NCBT030 WHERE NCS_DIV='N'AND CATEGORY_CD='"+a+"' AND DIVISION_CD='"+b+"' AND SECTION_CD='"+c+"' UNION ALL");
				}



			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


    public static void getExtraQeury(String fileName) {
		File file = new File(fileName);
		//입력 스트림 생성
		BufferedReader filereader = null;
		try {
			filereader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));


			StringBuilder textSb = new StringBuilder();
			int singleCh = 0;
			while ((singleCh = filereader.read()) != -1) {
//				System.out.print((char)singleCh);
				textSb.append((char) singleCh);
			}
			filereader.close();

			List<String> rowDataList = new ArrayList();
			rowDataList = Arrays.asList(textSb.toString().replace("\r", "").split("\n"));
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

			for (Object tbnm :tb){
				System.out.println("-- insert해야할 ["+tbnm+"] 목록 조회 쿼리------------");
				System.out.println("SELECT * FROM "+tbnm+" WHERE NCS_DIV='N' AND COMPT_UNIT_NO IN (");
				for (Object line : rowDataList) {

					if (rowDataList.indexOf(line)==rowDataList.size()-1){
						System.out.print("'"+line+"'");
					}else if(rowDataList.indexOf(line)==700) {
						System.out.println("'"+line+"'");
						System.out.print(") or COMPT_UNIT_NO IN (");

					}else{
						System.out.print("'"+line+"', ");
					}

				}
				System.out.println(");");
				System.out.println();
			}



		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}