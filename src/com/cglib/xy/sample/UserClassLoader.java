/*
 * Delta CONFIDENTIAL
 *
 * (C) Copyright Delta Electronics, Inc. 2015 All Rights Reserved
 *
 * NOTICE:  All information contained herein is, and remains the
 * property of Delta Electronics. The intellectual and technical
 * concepts contained herein are proprietary to Delta Electronics
 * and are protected by trade secret, patent law or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Delta Electronics.
 */
package com.cglib.xy.sample;

import java.net.URL;
import java.net.URLClassLoader;

public class UserClassLoader extends URLClassLoader {

	public UserClassLoader(URL[] urls, ClassLoader parentClassLoader) {
		super(urls, parentClassLoader);
	}
}
