package com.dell.opentext.rmp.parser;

import java.io.FileNotFoundException;

public class TestCode {

	public TestCode() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SourceParser source = new SourceParser();
		System.out.println("calling source parser class");
		try {
			source.readExcel();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Test Code");
		}
	}

}
