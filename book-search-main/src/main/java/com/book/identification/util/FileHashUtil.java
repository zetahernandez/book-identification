// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class FileHashUtil {

    
    public static String getFileMD5(File file) {
            String str = "";
            try {
                    str = getHash(file, "MD5");
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return str;
    }

    public static String getFileSHA1(File file) {
            String str = "";
            try {
                    str = getHash(file, "SHA1");
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return str;
    }

    public static String getFileSHA256(File file) {
            String str = "";
            try {
                    str = getHash(file, "SHA-256");
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return str;
    }

    public static String getFileSHA384(File file) {
            String str = "";
            try {
                    str = getHash(file, "SHA-384");
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return str;
    }

    public static String getFileSHA512(File file) {
            String str = "";
            try {
                    str = getHash(file, "SHA-512");
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return str;
    }

    private static String getHash(File file, String hashType)
                    throws Exception {
            InputStream fis = new FileInputStream(file);
            byte buffer[] = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance(hashType);
            for (int numRead = 0; (numRead = fis.read(buffer)) > 0;) {
                    md5.update(buffer, 0, numRead);
            }

            fis.close();
            return toHexString(md5.digest());
    }

    private static String toHexString(byte b[]) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
            	sb.append(Integer.toHexString(b[i] & 0xFF));
            }
            return sb.toString();
    }
    

}