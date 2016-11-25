package com.adyen.enums;

public enum Environment {
	TEST {
		public String toString(){
			return "TEST";
		}
	},
	LIVE{
		public String toString(){
			return "LIVE";
		}
	}
}
