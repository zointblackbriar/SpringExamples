package com.tudresden.springapp.annotationprocessor;

public class MASPropertyBuild {

	    private int age;

	    private String name;

	    public int getAge() {
	        return age;
	    }

	    @MASProperty
	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getName() {
	        return name;
	    }

	    @MASProperty
	    public void setName(String name) {
	        this.name = name;
	    }

}

public static void main(String[] args) {
	System.out.println("hello spring service");
}
