/*
 * Copyright (c) 2015 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.ge.sample.buffet;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * @author 212304931
 */
@ApiModel(description = "The buffet response object.")
public class Response {
    private int totalPlates;
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalPlates() {
        return this.totalPlates;
    }

    public void setTotalPlates(int totalPlates) {
        this.totalPlates = totalPlates;
    }
}