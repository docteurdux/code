/*
  Copyright (c) 2002, 2015, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.core;

import com.mysql.cj.core.conf.PropertyDefinitions;

/**
 * Represents various constants used in the driver.
 */
public class Constants {
    /**
     * Avoids allocation of empty byte[] when representing 0-length strings.
     */
    public final static byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /**
     * I18N'd representation of the abbreviation for "ms"
     */
    public final static String MILLIS_I18N = Messages.getString("Milliseconds");

    public final static byte[] SLASH_STAR_SPACE_AS_BYTES = new byte[] { (byte) '/', (byte) '*', (byte) ' ' };

    public final static byte[] SPACE_STAR_SLASH_SPACE_AS_BYTES = new byte[] { (byte) ' ', (byte) '*', (byte) '/', (byte) ' ' };

    public static final String JVM_VENDOR = System.getProperty(PropertyDefinitions.SYSP_java_vendor);
    public static final String JVM_VERSION = System.getProperty(PropertyDefinitions.SYSP_java_version);

    public static final String OS_NAME = System.getProperty(PropertyDefinitions.SYSP_os_name);
    public static final String OS_ARCH = System.getProperty(PropertyDefinitions.SYSP_os_arch);
    public static final String OS_VERSION = System.getProperty(PropertyDefinitions.SYSP_os_version);
    public static final String PLATFORM_ENCODING = System.getProperty(PropertyDefinitions.SYSP_file_encoding);

    public static final String CJ_NAME = "MySQL Connector Java";
    public static final String CJ_FULL_NAME = "mysql-connector-java-6.0.6";
    public static final String CJ_REVISION = "3dab84f4d9bede3cdd14d57b99e9e98a02a5b97d";
    public static final String CJ_VERSION = "6.0.6";
    public static final String CJ_MAJOR_VERSION = "6";
    public static final String CJ_MINOR_VERSION = "0";
    public static final String CJ_LICENSE = "GPL";

    /**
     * Prevents instantiation
     */
    private Constants() {
    }
}
