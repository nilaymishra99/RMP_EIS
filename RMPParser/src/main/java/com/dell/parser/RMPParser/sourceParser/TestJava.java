package com.dell.parser.RMPParser.sourceParser;

import java.io.FileNotFoundException;

public class TestJava {

	public TestJava() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RMPSourceParser  parse = new RMPSourceParser();
		
		try {
			parse.readExcel();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
