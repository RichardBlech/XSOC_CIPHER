package com.xsoc.cryptosystem.cipher.primitives;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		XORSHIFT128.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 18, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Implementation of XorShift 128 Plus+ - 
//* 				
//* 				@see:  https://en.wikipedia.org/wiki/Xorshift
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

public abstract class XORSHIFT128 {
	
	/**
	 * Xorshift128plus
	 * @param long[] nonLinearArray
	 * @return int
	*/
	public static int xorShift128P(long[] nonLinearArray) {
		
		long x = nonLinearArray[0];
		long y = nonLinearArray[1];
		
		nonLinearArray[0] = y;
		x ^= x << 23; 			// a
		x ^= x >>> 17; 			// b
		x ^= y ^ (y >>> 26); 	// c
		nonLinearArray[1] = x;
		
		return (int)((x + y) & 0xFF);
	}
	
	/**
	 * Xorshift128plus
	 * @param Memory
	 * @return int
	*/
	public static int xorShift128p(Memory memory) {
		memory.spin();
		return xorShift128P(memory.getNonLinearArray());
	}
}
