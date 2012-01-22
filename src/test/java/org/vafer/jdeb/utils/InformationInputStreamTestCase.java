/*
 * Copyright 2012 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vafer.jdeb.utils;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import junit.framework.TestCase;

public class InformationInputStreamTestCase extends TestCase {

    private InputStream getStream(String file) {
        return getClass().getClassLoader().getResourceAsStream("org/vafer/jdeb/utils/" + file);

    }
    public void testUTF8() throws Exception {
        InformationInputStream informationStream = new InformationInputStream(getStream("utf8-lf.txt"));
        Utils.copy(informationStream, new ByteArrayOutputStream());
        // System.out.println("" + informationStream);
        assertTrue(informationStream.isShell());
        assertTrue(!informationStream.hasBom());
    }
    public void testUTF8BOM() throws Exception {
        InformationInputStream informationStream = new InformationInputStream(getStream("utf8-lf-bom.txt"));
        Utils.copy(informationStream, new ByteArrayOutputStream());
        // System.out.println("" + informationStream);
        assertTrue(informationStream.isShell());
        assertTrue(informationStream.hasBom());
    }
    public void testUTF16BE() throws Exception {
        InformationInputStream informationStream = new InformationInputStream(getStream("utf16be-lf.txt"));
        Utils.copy(informationStream, new ByteArrayOutputStream());
        // System.out.println("" + informationStream);
        assertTrue(informationStream.isShell());
        assertTrue(!informationStream.hasBom());
    }
    public void testUTF16BEBOM() throws Exception {
        InformationInputStream informationStream = new InformationInputStream(getStream("utf16be-lf-bom.txt"));
        Utils.copy(informationStream, new ByteArrayOutputStream());
        // System.out.println("" + informationStream);
        assertTrue(informationStream.isShell());
        assertTrue(informationStream.hasBom());
    }
    public void testUTF16LE() throws Exception {
        InformationInputStream informationStream = new InformationInputStream(getStream("utf16le-lf.txt"));
        Utils.copy(informationStream, new ByteArrayOutputStream());
        // System.out.println("" + informationStream);
        assertTrue(informationStream.isShell());
        assertTrue(!informationStream.hasBom());
    }
    public void testUTF16LEBOM() throws Exception {
        InformationInputStream informationStream = new InformationInputStream(getStream("utf16le-lf-bom.txt"));
        Utils.copy(informationStream, new ByteArrayOutputStream());
        // System.out.println("" + informationStream);
        assertTrue(informationStream.isShell());
        assertTrue(informationStream.hasBom());
    }
}