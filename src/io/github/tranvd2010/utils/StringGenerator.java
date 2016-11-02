/**
 *StringGenerator.java
 *
 * @author Viet Dung Tran (tranvd2010@gmail.com)
 *
 * created on 23.03.2015
 */
package io.github.tranvd2010.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StringGenerator {

	private IGenerator igenerator;
	private int length;
	
	private boolean isErlaut = false;
	
	private Character[] specialCharacters;
	
	private List<Character> listCharacters = new ArrayList<Character>();

	private final static Random random = new Random();
	private final static Character[] NUMBERS = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9' };
	private final static Character[] SPECIAL_CHARS_FULL = { '!', '"', '#', '$',
			'%', '&', '\'', '(', ')', '*', '+', '-', '.', '/', ':', ';', '<',
			'=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}',
			'~', '}', ';' };

	public StringGenerator() {

	}

	public StringGenerator(final IGenerator igenerator, final int length,
			final boolean isLowerCaseCharacters,
			final boolean isUpperCaseCharacters, final boolean isNumeric,
			final boolean isSpecialCharacters,
			final Character... specialCharacters ) {

		this.igenerator = igenerator;
		this.length = length;
		
		this.isErlaut = (specialCharacters.length != 0);
		
		this.specialCharacters = (this.isErlaut) ?  specialCharacters :SPECIAL_CHARS_FULL ;
		
		//get mot lan cho do ton tai nguyen
		this.getListChars( isLowerCaseCharacters,isUpperCaseCharacters, isNumeric, isSpecialCharacters);
		
	}
	
	/**
	 * @param isLowerCaseCharacters
	 * @param isUpperCaseCharacters
	 * @param isNumeric
	 * @param isSpecialCharacters
	 * @return
	 */
	private void getListChars(boolean isLowerCaseCharacters,
			boolean isUpperCaseCharacters, boolean isNumeric,
			boolean isSpecialCharacters) {
		

		if (isLowerCaseCharacters) {
			for (char ch = 'a'; ch <= 'z'; ch++)
				this.listCharacters.add(ch);
		}

		if (isUpperCaseCharacters) {
			for (char ch = 'A'; ch <= 'Z'; ch++)
				this.listCharacters.add(ch);
		}

		if (isNumeric)
			Collections.addAll(this.listCharacters, NUMBERS);

		if (isSpecialCharacters || this.isErlaut ) {
			Collections.addAll(this.listCharacters, specialCharacters);
		}
		
	}

	/**
	 * 
	 */
	public void run(){
		
		String randomString = generateString( vermischen(this.listCharacters));
		igenerator.addRows(randomString);
	}

	/**
	 * 
	 * @param listCharacters
	 * @return
	 */
	private List<Character> vermischen(final List<Character> listCharacters){
		
		List<Character> newList = new ArrayList<Character>();
		List<Character> temList = new ArrayList<Character>(listCharacters);
		
		while (!temList.isEmpty()) {
			
            int index = (int)(Math.random() * temList.size());
            
            newList.add(temList.get(index));
            temList.remove(index);
        }
		
		return newList;
	}

	/**
	 * @param listCharacters
	 * @return
	 */
	private String generateString(final List<Character> listChars) {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < this.length; i++) {
			int index = random.nextInt(listChars.size());
			stringBuilder.append(listChars.get(index));
		}

		return stringBuilder.toString();
	}
}
