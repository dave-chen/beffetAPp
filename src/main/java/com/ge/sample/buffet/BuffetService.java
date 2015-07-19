

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
