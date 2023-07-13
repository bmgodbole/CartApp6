package com.bg.model;

import java.sql.Date;
import java.util.Objects;

public class A {
private int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof A))
		return false;
	A other = (A) obj;
	return id == other.id;
}


public static void main(String[] args) {
String str="2015-03-31";
Date date=Date.valueOf(str);//converting string into sql date.
System.out.println(date);
}
}

