package com.xsoc.cryptosystem.cipher.primitives;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		SBOX.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 18, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Substitution Table - Invertible
//* 				
//* 				@see:  https://en.wikipedia.org/wiki/S-box
//* 				
//* 				
//* ******************************************************************************************
//* 
//* 				SOFTWARE LICENSE AGREEMENT:
//* 				--------------------------------------------------------------------------
//* 				Licensed under the Apache License, Version 2.0 (the "License");
//* 				you may not use this file except in compliance with the License.
//* 				You may obtain a copy of the License at
//* 
//*    					https://www.apache.org/licenses/LICENSE-2.0
//* 
//* 				Unless required by applicable law or agreed to in writing, software
//* 				distributed under the License is distributed on an "AS IS" BASIS,
//* 				WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//* 				See the License for the specific language governing permissions and
//* 				limitations under the License.
//* 
//* ******************************************************************************************
//* 
//* 				LEGAL WARNING:
//* 				--------------------------------------------------------------------------
//* 				NOTICE:  ALL INFORMATION CONTAINED HEREIN IS, AND REMAINS THE PROPERTY OF
//* 				XSOC CORP.  THE INTELLECTUAL AND TECHNICAL CONCEPTS CONTAINED HEREIN
//* 				ARE PROPRIETARY TO XSOC CORP AND MAY BE COVERED BY U.S. AND FOREIGN
//* 				PATENTS, PATENTS IN PROCESS, AND ARE PROTECTED BY TRADE SECRET OR COPYRIGHT LAW.
//* 				
//* 				DISSEMINATION OF THIS INFORMATION OR REPRODUCTION OF THIS MATERIAL IS STRICTLY
//* 				FORBIDDEN UNLESS PRIOR WRITTEN PERMISSION IS OBTAINED FROM XSOC CORP.
//* 
//* ******************************************************************************************
//* 
//* 				COMMODITY CLASSIFICATION : UNITED STATES DEPARTMENT OF COMMERCE
//* 				--------------------------------------------------------------------------
//* 				THIS ENCRYPTION ITEM PROVIDING AN OPEN CRYPTOGRAPHIC INTERFACE IS AUTHORIZED
//* 				FOR LICENSE EXCEPTION ENC UNDER SECTIONS 740.17 (A) AND (B)(2) OF THE EXPORT
//* 				ADMINISTRATION REGULATIONS (EAR). 
//* 
//* 				UNITED STATES DEPARTMENT OF COMMERCE
//* 				BUREAU OF INDUSTRY AND SECURITY 
//* 				WASHINGTON, D.C. 20230
//* 
//* 				BIS/EA/STC/IT
//* 
/********************************************************************************************/
import com.xsoc.cryptosystem.state.Memory;

public abstract class SBOX {
	
	private static final int _SBOX_PERIOD = 256;
	
	/**
	 * S-BOX - Generate Cryptographic SBOX 
	 * -----------------------------------------------------------------------------------------
	 * This creates a 256 length table with an inverted arrangement of integers w/out duplicates
	 * -----------------------------------------------------------------------------------------
	 * @param Memory memory - The stateful meta-data for an encryption job
	 * @param boolean encrypt - switch determine if encryption or decryption setup
	 * @return Memory
	 * @throws Exception
	*/
	public static Memory init(Memory memory, boolean encrypt) throws Exception {
		
		int[] sbox = new int[_SBOX_PERIOD];
		
		// INITIALIZE DIRECT ASCENDING TABLE STRUCTURE
		for (int i = 0; i < sbox.length; i++) {
			sbox[i] = i;
		}
		
		// EXECUTE FISHER-YATES SHUFFLE AGAINST FROM NLA VECTOR (MUTATES NLA VECTOR IN PROCESS) SO THAT SBOX VALUES ARE "DETERMINISTIC" PRNG
		for (int i = 0; i < sbox.length; i++) {
			int r = (int)(NLFSR.actuate(memory) % (sbox.length - i));
			int j = i + r;
			
			int a = sbox[j & 0xFF];
			sbox[j & 0xFF] = sbox[i];
			
			sbox[i] = a;
		}
		
		memory.setSbox(encrypt ? sbox : flip(sbox)); // INVERT FOR DECRYPTION
		
		return memory;
	}
	
	/**
	 * SBOX - Invert (flip) the SBOX for decryption mode
	 * -----------------------------------------------------------------------------------------
	 * This creates a 256 length table with an inverted arrangement of integers w/out duplicates
	 * -----------------------------------------------------------------------------------------
	 * @return int[]
	 * @throws Exception
	*/
	private static int[] flip(int[] originalSubstitutionTable) throws Exception {
		
		int[] flipped = new int[originalSubstitutionTable.length];
		
		for (int i = 0; i < originalSubstitutionTable.length; i++) {
			int originalValueAtI = originalSubstitutionTable[i];  		// Example:  i = 0. original Value At i = 75
			flipped[originalValueAtI] = i; 								// copy the value from the position that corresponds with the original value at I
		}
		
		return flipped;
	}
}
