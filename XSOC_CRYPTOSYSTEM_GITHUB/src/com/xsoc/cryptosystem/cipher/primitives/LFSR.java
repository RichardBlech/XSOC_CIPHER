package com.xsoc.cryptosystem.cipher.primitives;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		LFSR.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 18, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Linear Feedback Shift Register (LFSR) - 
//* 				
//* 				Psuedo-Random Number Mutator for Long Integer Arrays
//* 				
//* 				@see:  https://en.wikipedia.org/wiki/Linear-feedback_shift_register
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
public abstract class LFSR {

	/**
	 * CORE ROUTINE - SHIFT - (LFSR) 
	 * ---------------------------------------------------------------------------------------
	 * This subroutine takes a psuedo-random (deterministic) segment of the nonLinearArray
	 * ---------------------------------------------------------------------------------------
	 * ISOLATE AND COMPARE RANDOMIZATION MECHANISM
	 * -------------------------------------------
	 * long s1 = (nonLinearArray[i+2] << 16);
	 * long s2 = (nonLinearArray[i] ^ s1);
	 * long s3 = (nonLinearArray[i+1] & 0xFFFF);
	 * long s4 = (nonLinearArray[i+3] ^ s3);
	 * long s5 += (s2 + s4);
	 * ---------------------------------------------------------------------------------------
	 * @param nonLinearArray
	 * @param i - pseudo random number position
	 * @return long
	*/
	public static long nextShift(long[] nonLinearArray, int i) {
		
		return (nonLinearArray[i] ^ nonLinearArray[i+2] << 16) + (nonLinearArray[i+3] ^ nonLinearArray[i+1] & 0xFFFF); // PRNG FROM A SINGLE ARRAY
	}
}
