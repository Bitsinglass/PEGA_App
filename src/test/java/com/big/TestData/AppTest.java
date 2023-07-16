package com.big.TestData;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	public Object[] getDataFromExcel() {
	try {
	Fillo fillo = new Fillo();
	Object[][] object = null;
	Connection connection = fillo.getConnection("./TestData.xlsx");
	Recordset recordset = connection.executeQuery("SELECT * FROM Login");
	int numberOfRows = recordset.getCount();
	List<String> Col_count = recordset.getFieldNames();
	int noofcolumns=Col_count.size();
	System.out.println("Size: " + numberOfRows);
	int i = 0;
	object = new Object[numberOfRows][noofcolumns];
	while (recordset.next()) {
		for(int j=0;j<=noofcolumns;j++) {
			object[i][j] = recordset.getField("Username");
			System.out.println(object[i][j]);
		}
		i++;
	}
	recordset.close();
	connection.close();
	return object;
} catch (FilloException e) {
	e.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
}
return null;
}
}
