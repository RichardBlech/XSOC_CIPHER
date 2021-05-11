package com.xsoc.cryptosystem.cipher.primitives.core.inner;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		XSOCEncryptionCore.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 17, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    XSOC ENCRYPTION CORE ALGORITHM - WAVE-FORM VARIABLE STRENGTH ENCRYPTION
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
import com.xsoc.cryptosystem.cipher.primitives.BLOCK;
import com.xsoc.cryptosystem.cipher.primitives.XORSHIFT128;
import com.xsoc.cryptosystem.state.Memory;

public abstract class XSOCEncryptionCore {
	
	/**
	 * ENCRYPT VARIABLE SIZED BLOCK OF DATA 
	 * --------------------------------------------------------------------------
	 * This function is the inner-core of encryption for XSOC.  Input parameters 
	 * include dynamic / variable length array of cleartext as an input, as well
	 * as the current memory ("state") of the encryption job.  
	 * 
	 * Operating byte-by-byte on the input array, the overall action exhibited by
	 * this encryption function is that of a STREAM CIPHER.  Padding and fixed-
	 * size key materials are not required for this function.  
	 * 
	 * Data blinding occurs in three [3] phases:
	 * 
	 * [1] Permute a byte of cleartext with a PRNG of 128-bit period. 							// Characteristic of a STREAM filter
	 * [2] XOR the updated byte of ciphertext with a random byte of key material. 				// Characteristic of a STREAM cipher
	 * [3] Permute the same byte of ciphertext with the inversion of an S-BOX block.  			// Characteristic of a BLOCK cipher
	 * 
	 * --------------------------------------------------------------------------
	 * @param byte[] input - cleartext of variable length
	 * @param Memory m - the application state with non-linear array of key material
	 * @return byte[] - ciphertext (encrypted)
	 * @throws Exception
	*/
	public static byte[] encrypt(byte[] input, Memory m) throws Exception {
		
		byte[] block = BLOCK.next(m, input.length);
		
		int i = 0;
		int outputbyte = -1;
		byte[] output = new byte[input.length];
		
		for (byte inputbyte : input) {

			byte keybyte = block[i]; 															// CSPRNG Deterministic Random Key Byte
			
			outputbyte = (int) (inputbyte + XORSHIFT128.xorShift128p(m)); 						// Blind with 128bit period obfuscation (N'X Time Complexity)
			outputbyte = (int) (outputbyte ^ keybyte); 											// XOR - XSOC Core Cipher
			outputbyte = (int) m.getSbox()[(outputbyte & 0xFF)]; 								// SBOX
			
			output[i++] = (byte)outputbyte;
		}
		
		return output;
	}
}
