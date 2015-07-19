
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
