/*
 * Copyright (C) 2016 Youngmin ybs5050@psu.edu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author Youngmin ybs5050@psu.edu
 */
public class CipherHandler {
        private static String plainText; 
        private static String encryptText = "";
        private static String decryptText = "";
        private static String keyText;
        private static int keySum = 0;
        private static String[] splitted; 
        public CipherHandler(String str, String key){
            CipherHandler.plainText = str;
            CipherHandler.keyText = key;
        }
        public static void encrypt(){
            keySum = 0;
            for(int i = 0; i < keyText.length(); i++){
                keySum += (int)keyText.charAt(i);
            }
            CipherHandler.splitted = stringSplitter(plainText,5);
            for(int a = 0; a < splitted.length; a++){
                int tempConverted = Integer.valueOf(splitted[a]) + (keySum);
                splitted[a] = Integer.toString(tempConverted);
            }
            for (String splitted1 : splitted) {
                encryptText += splitted1;
            }
        }
        public static void decrypt(){
            keySum = 0;
            for(int i = 0; i < keyText.length(); i++){
                keySum += (int)keyText.charAt(i);
            }
            CipherHandler.splitted = stringSplitter(plainText,5);
            for(int a = 0; a < splitted.length; a++){
                int tempConverted = Integer.valueOf(splitted[a]) - (keySum);
                splitted[a] = Integer.toString(tempConverted);
            }
            for (String splitted1 : splitted) {
                decryptText += splitted1;
            }
        }
        private static String[] stringSplitter(String s, int interval) {
            String[] result = new String[s.length()/interval];
            int j = 0;
            int lastIndex = result.length - 1;
            for (int i = 0; i < lastIndex; i++) {
                result[i] = s.substring(j, j + interval);
                j += interval;
            } //Add the last bit
            result[lastIndex] = s.substring(j);
            return result;
        }
        public String returnEncrypted(){
            return encryptText;
        }
        public String returnDecrypted(){
            return decryptText;
        }
}