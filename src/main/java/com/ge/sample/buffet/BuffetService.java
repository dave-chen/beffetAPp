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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 212304931
 */
@Component
public class BuffetService {

    @Autowired
    private BuffetRepository repository;

    public int getTotalPlates(String customerId) {
        Customer result = this.repository.findByCustomerId(customerId);
        if (result == null) {
            return 0;
        }
        return result.getCount();
    }

    public List<Customer> getAllCustomers() {
        List<Customer> results = this.repository.findAll();
        if ((results == null) || (results.size() == 0)) {
            return new ArrayList<Customer>();
        }
        return results;
    }

    public void updateTotal(String customerId, int total) {
        
        Customer newEntry = new Customer(customerId, total);
        Customer existing = this.repository.findByCustomerId(customerId);
        if (existing != null)
        {
            newEntry.setId(existing.getId());
        }
        
        this.repository.save(newEntry);
    }
}