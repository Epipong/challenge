package com.wedoogift.challenge.service;

import java.util.Calendar;

import com.wedoogift.challenge.pojo.Company;
import com.wedoogift.challenge.pojo.Distribution;
import com.wedoogift.challenge.pojo.User;

public class CompagnyService {
	public enum Type {
		GIFT, MEAL
	}
	
	/**
	 * Distribute the gift to the user with the company's balance.
	 * 
	 * @param user
	 * @param company
	 * @param balance
	 * @return
	 */
	public static Distribution distributeGift(User user, Company company, int balance, Type t) {
		Distribution d = new Distribution();
		if (company.getBalance() < balance) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		
		if (t == Type.GIFT) {
			end.add(Calendar.DAY_OF_YEAR, 365);
		} else if (t == Type.MEAL) {
			end.add(Calendar.YEAR, 1);
			end.set(Calendar.MONTH, 1);
			end.set(Calendar.DAY_OF_MONTH, 28);
		}
		
		d.setAmount(balance);
		d.setUserId(user.getId());
		d.setCompanyId(company.getId());
		d.setStartDate(start);
		d.setEndDate(end);
		
		user.setBalance(balance);
		company.setBalance(company.getBalance() - balance);
		return d;
	}
}
