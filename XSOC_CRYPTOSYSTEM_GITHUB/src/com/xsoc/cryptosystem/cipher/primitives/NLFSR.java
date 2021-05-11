package com.xsoc.cryptosystem.cipher.primitives;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		NLFSR.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 18, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Non-Linear Feedback Shift Register - Cryptographic Deterministic PRNG 
//* 				
//* 				@see:  https://en.wikipedia.org/wiki/Nonlinear-feedback_shift_register
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

public abstract class NLFSR {
	
	public static final int _BLOCK_SIZE = 4; // NLA VECTOR BLOCK LENGTH
	
	/**
	 * GENERATE A SINGLE [DETERMINISTIC] SCRAMBLED NUMBER FROM NLA VECTOR
	 * ---------------------------------------------------------------------------------------
	 * Used to create additive, subtractive, and associated blinding table structures, this
	 * function performs a single roll of the NLA vector
	 * ---------------------------------------------------------------------------------------
	 * @param Memory
	 * @return long
	 * @throws Exception
	*/
	public static long actuate(Memory memory) throws Exception {
		
		advance(memory);  			// SINGLE Advance the entire NonLinearArray to modify it's values (deterministically) with PRNG
		return pivot(memory);  		// PIVOT the advanced NonLinearArray to generate a deterministically consistent block segment
	}
	
	/**
	 * ADVANCE ("ROTATE") NEXT NLA VECTOR STATE - (MUTATOR)
	 * ---------------------------------------------------------------------------------------
	 * Apply psuedo-random number generation MWC to NLA vector
	 * ---------------------------------------------------------------------------------------
	 * @param Memory 
	 * @return int[]
	 * @throws Exception
	*/
	private static void advance(Memory memory) throws Exception {
		
		long[] nonLinearArray = memory.getNonLinearArray();
		
		for (int i = 0; i < nonLinearArray.length; i++) {
			nonLinearArray[i] = MWC.nextMWC(nonLinearArray, memory.getWaveform().getDynamicSeedArray(), i); // MULTIPLY WITH CARRY -> Mwc-256-X-X-A-64
		}
		
		memory.advance(); // INTERNAL SALT - COUNT STATE FOR STREAMING MEDIA POSITION SYNCHRONIZER
	}
	
	/**
	 * GENERATE A SINGLE [DETERMINISTIC] SCRAMBLED NUMBER FROM NLA VECTOR
	 * ---------------------------------------------------------------------------------------
	 * This is a blinding (not randomization) function that iterates across incremental 
	 * segments of the NLA to produce a "Deterministically Random" single value.
	 * ---------------------------------------------------------------------------------------
	 * @param Memory
	 * @return long
	 * @throws Exception
	*/
	private static long pivot(Memory memory) throws Exception {
		
		int turbo = 0;
		long next = 0;
		
		if (memory.getNonLinearArray().length > _BLOCK_SIZE) { // L2-CACHE TURBO VALUE FOR BOOST AT HIGHER WAVE AMPLITUDES
			
			turbo = memory.getTurbo() >= _BLOCK_SIZE ? (int)(memory.getTurbo() - _BLOCK_SIZE) : (int)(memory.getTurbo());
			next = LFSR.nextShift(memory.getNonLinearArray(), turbo);
			memory.setTurbo(((next & 0xFF) % (memory.getNonLinearArray().length)));
		}
		else {
			next = LFSR.nextShift(memory.getNonLinearArray(), turbo);
		}
		
		return next;
	}
}
