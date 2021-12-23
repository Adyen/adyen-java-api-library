package com.adyen.model.nexo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;

import java.util.Objects;


public class SSC {

    protected String ssc;

    private static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public String getSsc() {
        return ssc;
    }
    
    public void setSsc(String ssc) {
        this.ssc = ssc;
    }

    public static Gson getPrettyPrintGson() {
        return PRETTY_PRINT_GSON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SSC that = (SSC) o;
        return Objects.equals(ssc, that.ssc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssc);
    }

    @Override
    public String toString() {
        return "ProtectedCardData{" +
                "ssc=" + ssc +
                '}';
    }
    

    
    public String toBase64() {
        String json = PRETTY_PRINT_GSON.toJson(this);
        return new String(Base64.encodeBase64(json.getBytes()));
    }

    public SSC fromBase64(byte[] jsonResponse) {
      return PRETTY_PRINT_GSON.fromJson(new String(Base64.decodeBase64(jsonResponse)), SSC.class);
    }
 
}

