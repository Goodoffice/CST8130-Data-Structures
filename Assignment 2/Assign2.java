package Wenjing;

/**
 * File Name:       Assign2.java
 * Student Name:    Wenjing Wang
 * Course Name:     Data Structure
 * Lab Section:     300
 * Date:            2016-10-18
 * 
 * Purpose:         The class is the driver class for Assignment 2 - Bank Simulator 
 * 
 * Description:     It includes the main method and calls the bank menu. 
 */

public class Assign2 {
	public static void main(String[] args) {
		// Instantiates an Bank object and calls menu().
		Bank bank = new Bank();
		bank.menu();
	}
}
