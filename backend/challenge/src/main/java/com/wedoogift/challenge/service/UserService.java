package com.wedoogift.challenge.service;

import java.util.Calendar;
import java.util.List;

import com.wedoogift.challenge.pojo.Distribution;
import com.wedoogift.challenge.pojo.User;

public class UserService {
	public static int calculateBalanceUserFromDistributions(User user, List<Distribution> distributions) {
		int balance = 0;
		Calendar today = Calendar.getInstance();
		
		for (Distribution d : distributions) {
			if (d.getUserId().equals(user.getId())
					&& today.before(d.getEndDate())) {
				balance += d.getAmount();
			}
		}
		user.setBalance(balance);
		return balance;
	}
}
