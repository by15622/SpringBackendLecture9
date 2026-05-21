package com.sprint.mission.springsecuritytokenjwt;


import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodingDecoding {

  public static void main(String[] args) {

    Encoder encoder = Base64.getEncoder();
    Decoder decoder = Base64.getDecoder();
    Encoder urlEncoder = Base64.getUrlEncoder();
    Decoder urlDecoder = Base64.getUrlDecoder();

    String plainText = "동해물과 백두산이 마르고 닳도록";
    byte[] plainTestToByteArr = plainText.getBytes();
    byte[] encodedArr = encoder.encode(plainTestToByteArr);
    byte[] urlEncodedArr = urlEncoder.encode(plainTestToByteArr);

    String encodedStr = new String(encodedArr);
    String urlEncodedStr = new String(urlEncodedArr);
    System.out.println("인코딩된 애국가(Base64)    = " + encodedStr);
    System.out.println("인코딩된 애국가(Base64URL) = " + urlEncodedStr);

    byte[] decodedArr = decoder.decode(encodedStr);
    byte[] urlDecodedArr = urlDecoder.decode(urlEncodedStr);

    String decodedStr = new String(decodedArr);
    String urlDecodedStr = new String(urlDecodedArr);
    System.out.println("다시 디코딩된 애국가            = " + decodedStr);
    System.out.println("다시 디코딩된 애국가(Base64URL) = " + urlDecodedStr);
  }

}
