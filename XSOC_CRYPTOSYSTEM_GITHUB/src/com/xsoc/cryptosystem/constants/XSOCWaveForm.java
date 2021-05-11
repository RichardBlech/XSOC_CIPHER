package com.xsoc.cryptosystem.constants;
/********************************************************************************************
//* Copyright(c) 2021 XSOC Corp, Irvine, California, USA. All Rights Reserved.
//* Filename: 		XSOCWaveForm.java
//* Revision: 		1.0
//* Author: 		XSOC Corp
//* Created On: 	Mar 18, 2021
//* Modified by: 	
//* Modified On: 	
//* 				
//* Description:    Wave-Form Encryption - Accessors for Modulated Keyspace / bit-length
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

public abstract class XSOCWaveForm {
	
	public static enum Wave { 		WAVE_AMPLITUDE_1  	(1),	// 64 bit Long * BLOCK-SIZE[4]		* 2 BLOCKS =    512 bit Key Space]
									WAVE_AMPLITUDE_2  	(2),	// 64 bit Long * BLOCK-SIZE[8]		* 2 BLOCKS =  1,024 bit Key Space]
									WAVE_AMPLITUDE_3  	(3),	// 64 bit Long * BLOCK-SIZE[12]		* 2 BLOCKS =  1,536 bit Key Space]
									WAVE_AMPLITUDE_4  	(4),	// 64 bit Long * BLOCK-SIZE[16]		* 2 BLOCKS =  2,048 bit Key Space]
									WAVE_AMPLITUDE_5  	(5),	// 64 bit Long * BLOCK-SIZE[20]		* 2 BLOCKS =  2,560 bit Key Space]
									WAVE_AMPLITUDE_6  	(6),	// 64 bit Long * BLOCK-SIZE[24]		* 2 BLOCKS =  3,072 bit Key Space]
									WAVE_AMPLITUDE_7  	(7),	// 64 bit Long * BLOCK-SIZE[28]		* 2 BLOCKS =  3,584 bit Key Space]
									WAVE_AMPLITUDE_8  	(8),	// 64 bit Long * BLOCK-SIZE[32]		* 2 BLOCKS =  4,096 bit Key Space]
									WAVE_AMPLITUDE_9  	(9),	// 64 bit Long * BLOCK-SIZE[36]		* 2 BLOCKS =  4,608 bit Key Space]
									WAVE_AMPLITUDE_10  (10),	// 64 bit Long * BLOCK-SIZE[40]		* 2 BLOCKS =  5,120 bit Key Space]
									WAVE_AMPLITUDE_11  (11),	// 64 bit Long * BLOCK-SIZE[44]		* 2 BLOCKS =  5,632 bit Key Space]
									WAVE_AMPLITUDE_12  (12),	// 64 bit Long * BLOCK-SIZE[48]		* 2 BLOCKS =  6,144 bit Key Space]
									WAVE_AMPLITUDE_13  (13),	// 64 bit Long * BLOCK-SIZE[52]		* 2 BLOCKS =  6,656 bit Key Space]
									WAVE_AMPLITUDE_14  (14),	// 64 bit Long * BLOCK-SIZE[56]		* 2 BLOCKS =  7,168 bit Key Space]
									WAVE_AMPLITUDE_15  (15),	// 64 bit Long * BLOCK-SIZE[60]		* 2 BLOCKS =  7,680 bit Key Space]
									WAVE_AMPLITUDE_16  (16),	// 64 bit Long * BLOCK-SIZE[64]		* 2 BLOCKS =  8,192 bit Key Space]
									WAVE_AMPLITUDE_17  (17),	// 64 bit Long * BLOCK-SIZE[68]		* 2 BLOCKS =  8,704 bit Key Space]
									WAVE_AMPLITUDE_18  (18),	// 64 bit Long * BLOCK-SIZE[72]		* 2 BLOCKS =  9,216 bit Key Space]
									WAVE_AMPLITUDE_19  (19),	// 64 bit Long * BLOCK-SIZE[76]		* 2 BLOCKS =  9,728 bit Key Space]
									WAVE_AMPLITUDE_20  (20),	// 64 bit Long * BLOCK-SIZE[80]		* 2 BLOCKS = 10,240 bit Key Space]
									WAVE_AMPLITUDE_21  (21),	// 64 bit Long * BLOCK-SIZE[84]		* 2 BLOCKS = 10,752 bit Key Space]
									WAVE_AMPLITUDE_22  (22),	// 64 bit Long * BLOCK-SIZE[88]		* 2 BLOCKS = 11,264 bit Key Space]
									WAVE_AMPLITUDE_23  (23),	// 64 bit Long * BLOCK-SIZE[92]		* 2 BLOCKS = 11,776 bit Key Space]
									WAVE_AMPLITUDE_24  (24),	// 64 bit Long * BLOCK-SIZE[96]		* 2 BLOCKS = 12,288 bit Key Space]
									WAVE_AMPLITUDE_25  (25),	// 64 bit Long * BLOCK-SIZE[100]	* 2 BLOCKS = 12,800 bit Key Space]
									WAVE_AMPLITUDE_26  (26),	// 64 bit Long * BLOCK-SIZE[104]	* 2 BLOCKS = 13,312 bit Key Space]
									WAVE_AMPLITUDE_27  (27),	// 64 bit Long * BLOCK-SIZE[108]	* 2 BLOCKS = 13,824 bit Key Space]
									WAVE_AMPLITUDE_28  (28),	// 64 bit Long * BLOCK-SIZE[112]	* 2 BLOCKS = 14,336 bit Key Space]
									WAVE_AMPLITUDE_29  (29),	// 64 bit Long * BLOCK-SIZE[116]	* 2 BLOCKS = 14,848 bit Key Space]
									WAVE_AMPLITUDE_30  (30),	// 64 bit Long * BLOCK-SIZE[120]	* 2 BLOCKS = 15,360 bit Key Space]
									WAVE_AMPLITUDE_31  (31),	// 64 bit Long * BLOCK-SIZE[124]	* 2 BLOCKS = 15,872 bit Key Space]
									WAVE_AMPLITUDE_32  (32),	// 64 bit Long * BLOCK-SIZE[128]	* 2 BLOCKS = 16,384 bit Key Space]
									WAVE_AMPLITUDE_33  (33),	// 64 bit Long * BLOCK-SIZE[132]	* 2 BLOCKS = 16,896 bit Key Space]
									WAVE_AMPLITUDE_34  (34),	// 64 bit Long * BLOCK-SIZE[136]	* 2 BLOCKS = 17,408 bit Key Space]
									WAVE_AMPLITUDE_35  (35),	// 64 bit Long * BLOCK-SIZE[140]	* 2 BLOCKS = 17,920 bit Key Space]
									WAVE_AMPLITUDE_36  (36),	// 64 bit Long * BLOCK-SIZE[144]	* 2 BLOCKS = 18,432 bit Key Space]
									WAVE_AMPLITUDE_37  (37),	// 64 bit Long * BLOCK-SIZE[148]	* 2 BLOCKS = 18,944 bit Key Space]
									WAVE_AMPLITUDE_38  (38),	// 64 bit Long * BLOCK-SIZE[152]	* 2 BLOCKS = 19,456 bit Key Space]
									WAVE_AMPLITUDE_39  (39),	// 64 bit Long * BLOCK-SIZE[156]	* 2 BLOCKS = 19,968 bit Key Space]
									WAVE_AMPLITUDE_40  (40),	// 64 bit Long * BLOCK-SIZE[160]	* 2 BLOCKS = 20,480 bit Key Space]
									WAVE_AMPLITUDE_41  (41),	// 64 bit Long * BLOCK-SIZE[164]	* 2 BLOCKS = 20,992 bit Key Space]
									WAVE_AMPLITUDE_42  (42),	// 64 bit Long * BLOCK-SIZE[168]	* 2 BLOCKS = 21,504 bit Key Space]
									WAVE_AMPLITUDE_43  (43),	// 64 bit Long * BLOCK-SIZE[172]	* 2 BLOCKS = 22,016 bit Key Space]
									WAVE_AMPLITUDE_44  (44),	// 64 bit Long * BLOCK-SIZE[176]	* 2 BLOCKS = 22,528 bit Key Space]
									WAVE_AMPLITUDE_45  (45),	// 64 bit Long * BLOCK-SIZE[180]	* 2 BLOCKS = 23,040 bit Key Space]
									WAVE_AMPLITUDE_46  (46),	// 64 bit Long * BLOCK-SIZE[184]	* 2 BLOCKS = 23,552 bit Key Space]
									WAVE_AMPLITUDE_47  (47),	// 64 bit Long * BLOCK-SIZE[188]	* 2 BLOCKS = 24,064 bit Key Space]
									WAVE_AMPLITUDE_48  (48),	// 64 bit Long * BLOCK-SIZE[192]	* 2 BLOCKS = 24,576 bit Key Space]
									WAVE_AMPLITUDE_49  (49),	// 64 bit Long * BLOCK-SIZE[196]	* 2 BLOCKS = 25,088 bit Key Space]
									WAVE_AMPLITUDE_50  (50),	// 64 bit Long * BLOCK-SIZE[200]	* 2 BLOCKS = 25,600 bit Key Space]
									WAVE_AMPLITUDE_51  (51),	// 64 bit Long * BLOCK-SIZE[204]	* 2 BLOCKS = 26,112 bit Key Space]
									WAVE_AMPLITUDE_52  (52),	// 64 bit Long * BLOCK-SIZE[208]	* 2 BLOCKS = 26,624 bit Key Space]
									WAVE_AMPLITUDE_53  (53),	// 64 bit Long * BLOCK-SIZE[212]	* 2 BLOCKS = 27,136 bit Key Space]
									WAVE_AMPLITUDE_54  (54),	// 64 bit Long * BLOCK-SIZE[216]	* 2 BLOCKS = 27,648 bit Key Space]
									WAVE_AMPLITUDE_55  (55),	// 64 bit Long * BLOCK-SIZE[220]	* 2 BLOCKS = 28,160 bit Key Space]
									WAVE_AMPLITUDE_56  (56),	// 64 bit Long * BLOCK-SIZE[224]	* 2 BLOCKS = 28,672 bit Key Space]
									WAVE_AMPLITUDE_57  (57),	// 64 bit Long * BLOCK-SIZE[228]	* 2 BLOCKS = 29,184 bit Key Space]
									WAVE_AMPLITUDE_58  (58),	// 64 bit Long * BLOCK-SIZE[232]	* 2 BLOCKS = 29,696 bit Key Space]
									WAVE_AMPLITUDE_59  (59),	// 64 bit Long * BLOCK-SIZE[236]	* 2 BLOCKS = 30,208 bit Key Space]
									WAVE_AMPLITUDE_60  (60),	// 64 bit Long * BLOCK-SIZE[240]	* 2 BLOCKS = 30,720 bit Key Space]
									WAVE_AMPLITUDE_61  (61),	// 64 bit Long * BLOCK-SIZE[244]	* 2 BLOCKS = 31,232 bit Key Space]
									WAVE_AMPLITUDE_62  (62),	// 64 bit Long * BLOCK-SIZE[248]	* 2 BLOCKS = 31,744 bit Key Space]
									WAVE_AMPLITUDE_63  (63),	// 64 bit Long * BLOCK-SIZE[252]	* 2 BLOCKS = 32,256 bit Key Space]
									WAVE_AMPLITUDE_64  (64),	// 64 bit Long * BLOCK-SIZE[256]	* 2 BLOCKS = 32,768 bit Key Space]
									WAVE_AMPLITUDE_65  (65),	// 64 bit Long * BLOCK-SIZE[260]	* 2 BLOCKS = 33,280 bit Key Space]
									WAVE_AMPLITUDE_66  (66),	// 64 bit Long * BLOCK-SIZE[264]	* 2 BLOCKS = 33,792 bit Key Space]
									WAVE_AMPLITUDE_67  (67),	// 64 bit Long * BLOCK-SIZE[268]	* 2 BLOCKS = 34,304 bit Key Space]
									WAVE_AMPLITUDE_68  (68),	// 64 bit Long * BLOCK-SIZE[272]	* 2 BLOCKS = 34,816 bit Key Space]
									WAVE_AMPLITUDE_69  (69),	// 64 bit Long * BLOCK-SIZE[276]	* 2 BLOCKS = 35,328 bit Key Space]
									WAVE_AMPLITUDE_70  (70),	// 64 bit Long * BLOCK-SIZE[280]	* 2 BLOCKS = 35,840 bit Key Space]
									WAVE_AMPLITUDE_71  (71),	// 64 bit Long * BLOCK-SIZE[284]	* 2 BLOCKS = 36,352 bit Key Space]
									WAVE_AMPLITUDE_72  (72),	// 64 bit Long * BLOCK-SIZE[288]	* 2 BLOCKS = 36,864 bit Key Space]
									WAVE_AMPLITUDE_73  (73),	// 64 bit Long * BLOCK-SIZE[292]	* 2 BLOCKS = 37,376 bit Key Space]
									WAVE_AMPLITUDE_74  (74),	// 64 bit Long * BLOCK-SIZE[296]	* 2 BLOCKS = 37,888 bit Key Space]
									WAVE_AMPLITUDE_75  (75),	// 64 bit Long * BLOCK-SIZE[300]	* 2 BLOCKS = 38,400 bit Key Space]
									WAVE_AMPLITUDE_76  (76),	// 64 bit Long * BLOCK-SIZE[304]	* 2 BLOCKS = 38,912 bit Key Space]
									WAVE_AMPLITUDE_77  (77),	// 64 bit Long * BLOCK-SIZE[308]	* 2 BLOCKS = 39,424 bit Key Space]
									WAVE_AMPLITUDE_78  (78),	// 64 bit Long * BLOCK-SIZE[312]	* 2 BLOCKS = 39,936 bit Key Space]
									WAVE_AMPLITUDE_79  (79),	// 64 bit Long * BLOCK-SIZE[316]	* 2 BLOCKS = 40,448 bit Key Space]
									WAVE_AMPLITUDE_80  (80),	// 64 bit Long * BLOCK-SIZE[320]	* 2 BLOCKS = 40,960 bit Key Space]
									WAVE_AMPLITUDE_81  (81),	// 64 bit Long * BLOCK-SIZE[324]	* 2 BLOCKS = 41,472 bit Key Space]
									WAVE_AMPLITUDE_82  (82),	// 64 bit Long * BLOCK-SIZE[328]	* 2 BLOCKS = 41,984 bit Key Space]
									WAVE_AMPLITUDE_83  (83),	// 64 bit Long * BLOCK-SIZE[332]	* 2 BLOCKS = 42,496 bit Key Space]
									WAVE_AMPLITUDE_84  (84),	// 64 bit Long * BLOCK-SIZE[336]	* 2 BLOCKS = 43,008 bit Key Space]
									WAVE_AMPLITUDE_85  (85),	// 64 bit Long * BLOCK-SIZE[340]	* 2 BLOCKS = 43,520 bit Key Space]
									WAVE_AMPLITUDE_86  (86),	// 64 bit Long * BLOCK-SIZE[344]	* 2 BLOCKS = 44,032 bit Key Space]
									WAVE_AMPLITUDE_87  (87),	// 64 bit Long * BLOCK-SIZE[348]	* 2 BLOCKS = 44,544 bit Key Space]
									WAVE_AMPLITUDE_88  (88),	// 64 bit Long * BLOCK-SIZE[352]	* 2 BLOCKS = 45,056 bit Key Space]
									WAVE_AMPLITUDE_89  (89),	// 64 bit Long * BLOCK-SIZE[356]	* 2 BLOCKS = 45,568 bit Key Space]
									WAVE_AMPLITUDE_90  (90),	// 64 bit Long * BLOCK-SIZE[360]	* 2 BLOCKS = 46,080 bit Key Space]
									WAVE_AMPLITUDE_91  (91),	// 64 bit Long * BLOCK-SIZE[364]	* 2 BLOCKS = 46,592 bit Key Space]
									WAVE_AMPLITUDE_92  (92),	// 64 bit Long * BLOCK-SIZE[368]	* 2 BLOCKS = 47,104 bit Key Space]
									WAVE_AMPLITUDE_93  (93),	// 64 bit Long * BLOCK-SIZE[372]	* 2 BLOCKS = 47,616 bit Key Space]
									WAVE_AMPLITUDE_94  (94),	// 64 bit Long * BLOCK-SIZE[376]	* 2 BLOCKS = 48,128 bit Key Space]
									WAVE_AMPLITUDE_95  (95),	// 64 bit Long * BLOCK-SIZE[380]	* 2 BLOCKS = 48,640 bit Key Space]
									WAVE_AMPLITUDE_96  (96),	// 64 bit Long * BLOCK-SIZE[384]	* 2 BLOCKS = 49,152 bit Key Space]
									WAVE_AMPLITUDE_97  (97),	// 64 bit Long * BLOCK-SIZE[388]	* 2 BLOCKS = 49,664 bit Key Space]
									WAVE_AMPLITUDE_98  (98),	// 64 bit Long * BLOCK-SIZE[392]	* 2 BLOCKS = 50,176 bit Key Space]
									WAVE_AMPLITUDE_99  (99),	// 64 bit Long * BLOCK-SIZE[396]	* 2 BLOCKS = 50,688 bit Key Space]
									WAVE_AMPLITUDE_100(100);    // 64 bit Long * BLOCK-SIZE[400]	* 2 BLOCKS = 51,200 bit Key Space]
		
		
		private long[] dynamicSeedArray; 			// Dynamically generated TRNG array
		private long[] initialNonLinearArray; 		// Dynamically generated TRNG array
		
		private long[] dynamicSeedArrayMFA; 		// Dynamically generated TRNG array - MFA ADJUSTED
		private long[] initialNonLinearArrayMFA; 	// Dynamically generated TRNG array - MFA ADJUSTED
		
		private int amplitude;
		private String userKeyString;

		/**
		 * Enum Constructor - Utilizes the parameter (dynamic wave) amplitude to initiate TRNG keys
		 * @param startupTime
		*/
		private Wave(int amplitude) {
			this.amplitude = amplitude;
			
			this.dynamicSeedArray 		= new long[]{ 12345L, 12345L, 12345L, 12345L }; 	// CREATE YOUR CSRNG VECTOR HERE
			this.initialNonLinearArray 	= new long[]{ 12345L, 12345L, 12345L, 12345L }; 	// CREATE YOUR CSRNG VECTOR HERE
			
		}

		/**
		 * @return the dynamicSeedArray
		 */
		public long[] getDynamicSeedArray() {
			return dynamicSeedArray;
		}

		/**
		 * @return the initialNonLinearArray
		 */
		public long[] getInitialNonLinearArray() {
			return initialNonLinearArray;
		}

		/**
		 * @param initialNonLinearArray the initialNonLinearArray to set
		 */
		public void setInitialNonLinearArray(long[] initialNonLinearArray) {
			this.initialNonLinearArray = initialNonLinearArray;
		}

		/**
		 * @return the amplitude
		 */
		public int getAmplitude() {
			return amplitude;
		}
		
		/**
		 * @return the userKeyString
		 */
		public String getUserKeyString() {
			return userKeyString;
		}

		/**
		 * @param dynamicSeedArray the dynamicSeedArray to set
		 */
		public void setDynamicSeedArray(long[] dynamicSeedArray) {
			this.dynamicSeedArray = dynamicSeedArray;
		}

		/**
		 * @return the dynamicSeedArrayMFA
		 */
		public long[] getDynamicSeedArrayMFA() {
			return dynamicSeedArrayMFA;
		}

		/**
		 * @param dynamicSeedArrayMFA the dynamicSeedArrayMFA to set
		 */
		public void setDynamicSeedArrayMFA(long[] dynamicSeedArrayMFA) {
			this.dynamicSeedArrayMFA = dynamicSeedArrayMFA;
		}

		/**
		 * @return the initialNonLinearArrayMFA
		 */
		public long[] getInitialNonLinearArrayMFA() {
			return initialNonLinearArrayMFA;
		}

		/**
		 * @param initialNonLinearArrayMFA the initialNonLinearArrayMFA to set
		 */
		public void setInitialNonLinearArrayMFA(long[] initialNonLinearArrayMFA) {
			this.initialNonLinearArrayMFA = initialNonLinearArrayMFA;
		}
	};
}
