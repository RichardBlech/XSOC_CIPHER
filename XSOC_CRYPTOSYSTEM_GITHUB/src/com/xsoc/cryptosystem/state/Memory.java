package com.xsoc.cryptosystem.state;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		Memory.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 19, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Ephemeral / volatile memory state of singular encryption or decryption
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
import java.security.MessageDigest;
import com.xsoc.cryptosystem.constants.XSOCWaveForm.Wave;

public class Memory implements java.io.Serializable {
	
	private static final long serialVersionUID = -3404078473294943476L;

	private Wave waveform; 					// Waveform amplitude encrypted input
	
	private byte[] header; 					// Dynamically generated XSOC Header
	private long[] nonLinearArray;			// Dynamically generated "nonLinearArray" (DYNAMIC LENGTH ROTATING CSRNG VECTOR)
	private int[] sbox; 					// Dynamically generated substitution table
	
	private long turbo; 					// Dynamically generated NLFSR - turbo boosts higher wave amplitude for optimized consumption of NLA Vector
	
	private long salt; 						// Internal State / SALT
	private long spin; 						// Internal State / SPIN
	
	private long hmacBlockCount; 			// Block counter for HMAC Signature
	
	private MessageDigest md; 				// Message digester for HMAC
	private byte[] hmacSignature; 			// HMAC SIGNATURE - IF SIGNED
	
	private boolean hmacSignatureParsed; 	// Status flag to determine whether or not an HMAC signature was parsed
	private boolean initializationRound; 	// Status flag to determine whether or not this is a first-round in continuous streaming mode
	private boolean keyGenerated; 			// Key material generated - 1X / JOB
	
	/**
	 * Increment the SALT counter value
	 * @return void
	*/
	public void advance() {
		this.salt++;
	}
	
	public void spin() {
		this.spin++;
	}
	
	/**
	 * Increment the HMAC block count
	 * @return void
	*/
	public void next() {
		this.hmacBlockCount++;
	}
	
	/**** **** **** **** **** **** **** **** **** **** **** **** **** **** **** **** **** ****/
	/**** GETTERS AND SETTERS (AUTO-GENERATED) BELOW THIS LINE  							 */
	/**** **** **** **** **** **** **** **** **** **** **** **** **** **** **** **** **** ****/
	
	/**
	 * @return the waveform
	 */
	public Wave getWaveform() {
		return waveform;
	}

	/**
	 * @param waveform the waveform to set
	 */
	public void setWaveform(Wave waveform) {
		this.waveform = waveform;
	}

	/**
	 * @return the header
	 */
	public byte[] getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(byte[] header) {
		this.header = header;
	}

	/**
	 * @return the nonLinearArray
	 */
	public long[] getNonLinearArray() {
		return nonLinearArray;
	}

	/**
	 * @param nonLinearArray the nonLinearArray to set
	 */
	public void setNonLinearArray(long[] nonLinearArray) {
		this.nonLinearArray = nonLinearArray;
	}

	/**
	 * @return the sbox
	 */
	public int[] getSbox() {
		return sbox;
	}

	/**
	 * @param sbox the sbox to set
	 */
	public void setSbox(int[] sbox) {
		this.sbox = sbox;
	}

	/**
	 * @return the turbo
	 */
	public long getTurbo() {
		return turbo;
	}

	/**
	 * @param turbo the turbo to set
	 */
	public void setTurbo(long turbo) {
		this.turbo = turbo;
	}

	/**
	 * @return the salt
	 */
	public long getSalt() {
		return salt;
	}

	/**
	 * @return the spin
	 */
	public long getSpin() {
		return spin;
	}

	/**
	 * @return the md
	 */
	public MessageDigest getMd() {
		return md;
	}

	/**
	 * @param md the md to set
	 */
	public void setMd(MessageDigest md) {
		this.md = md;
	}

	/**
	 * @return the hmacSignatureParsed
	 */
	public boolean isHmacSignatureParsed() {
		return hmacSignatureParsed;
	}

	/**
	 * @param hmacSignatureParsed the hmacSignatureParsed to set
	 */
	public void setHmacSignatureParsed(boolean hmacSignatureParsed) {
		this.hmacSignatureParsed = hmacSignatureParsed;
	}

	/**
	 * @return the initializationRound
	 */
	public boolean isInitializationRound() {
		return initializationRound;
	}

	/**
	 * @param initializationRound the initializationRound to set
	 */
	public void setInitializationRound(boolean initializationRound) {
		this.initializationRound = initializationRound;
	}
	
	/**
	 * @return the hmacSignature
	 */
	public byte[] getHmacSignature() {
		return hmacSignature;
	}

	/**
	 * @param hmacSignature the hmacSignature to set
	 */
	public void setHmacSignature(byte[] hmacSignature) {
		this.hmacSignature = hmacSignature;
	}

	/**
	 * @return the hmacBlockCount
	 */
	public long getHmacBlockCount() {
		return hmacBlockCount;
	}

	/**
	 * @return the keyGenerated
	 */
	public boolean isKeyGenerated() {
		return keyGenerated;
	}

	/**
	 * @param keyGenerated the keyGenerated to set
	 */
	public void setKeyGenerated(boolean keyGenerated) {
		this.keyGenerated = keyGenerated;
	}
}
