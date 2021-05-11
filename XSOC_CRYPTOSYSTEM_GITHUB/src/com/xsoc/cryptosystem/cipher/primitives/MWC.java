package com.xsoc.cryptosystem.cipher.primitives;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		MWC.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 18, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Multiply-with-Carry by George Marsaglia
//* 				
//* 				@see:  https://en.wikipedia.org/wiki/Multiply-with-carry_pseudorandom_number_generator
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
public abstract class MWC {
	
	/**
	 * ---------------------------------------------------------------------------------------
	 * CORE ROUTINE - MULTIPLY WITH CARRY - (LINEAR CONGRUENTIAL GENERATOR)
	 * ---------------------------------------------------------------------
	 * long part1 = (dsgVector[i] & 0xFFFF);
	 * long part2 = (dsgVector[i] >> 16);
	 * long part3 = (dynamicSeedArray[i] * part1);
	 * long part4 = (part3 + part2);
	 * long nextInteger = (part4 + 1);
	 * ---------------------------------------------------------------------------------------
	 * @param nonLinearArray
	 * @param dynamicSeedArray
	 * @param i - pseudo random position
	 * @return long
	*/
	public static long nextMWC(long[] nonLinearArray, long[] dynamicSeedArray, int i) {
		
		return (dynamicSeedArray[i] * (nonLinearArray[i] & 0xFFFF) + (nonLinearArray[i] >> 16)) + 1; 
	}
}
