/**
 * Logback: the reliable, generics, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package log.introduction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld4 {

    public static void main(String[] args) {
        Logger x = LoggerFactory.getLogger("wombat");
        Logger y = LoggerFactory.getLogger("wombat");
        if(x == y){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
