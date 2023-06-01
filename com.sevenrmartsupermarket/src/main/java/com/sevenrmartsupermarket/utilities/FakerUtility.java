
package com.sevenrmartsupermarket.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
static Faker faker = new Faker();

public static String getFullName() {
	
	String name = faker.name().fullName();
	return name;
	
}
}
