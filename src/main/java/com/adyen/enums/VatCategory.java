package com.adyen.enums;

public enum VatCategory {
    HIGH {
        public String toString(){
            return "High";
        }
    },
    LOW {
        public String toString(){
            return "Low";
        }
    },
    NONE {
        public String toString(){
            return "None";
        }
    }
}
