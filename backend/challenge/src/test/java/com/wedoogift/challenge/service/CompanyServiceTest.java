package com.wedoogift.challenge.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.wedoogift.challenge.pojo.Company;
import com.wedoogift.challenge.pojo.Distribution;
import com.wedoogift.challenge.pojo.User;
import com.wedoogift.challenge.service.CompagnyService.Type;

class CompanyServiceTest {

	@Test
	void distributionGiftTest() {
		User user = new User();
		user.setId(1);
		user.setBalance(0);
		
		Company company = new Company();
		company.setId(1);
		company.setBalance(1000);
		company.setName("Tesla");
		
		Distribution d = CompagnyService.distributeGift(user, company, 100, Type.GIFT);
		long start = d.getStartDate().getTimeInMillis();
		long end = d.getEndDate().getTimeInMillis();
		long lifespan = TimeUnit.MILLISECONDS.toDays(end - start);

		assertThat(user.getBalance()).isEqualTo(100);
		assertThat(user.getId()).isEqualTo(1);
		assertThat(company.getBalance()).isEqualTo(900);
		assertThat(lifespan).isEqualTo(365);
	}
	
	@Test
	void distributionGiftFailedTest() {
		User user = new User();
		user.setId(1);
		user.setBalance(0);
		
		Company company = new Company();
		company.setId(1);
		company.setBalance(100);
		company.setName("Tesla");
		
		Distribution d = CompagnyService.distributeGift(user, company, 1000, Type.GIFT);

		assertThat(user.getBalance()).isEqualTo(0);
		assertThat(company.getBalance()).isEqualTo(100);
		assertThat(d).isEqualTo(null);
	}

	@Test
	void distributionMealTest() {
		User user = new User();
		user.setId(1);
		user.setBalance(0);
		
		Company company = new Company();
		company.setId(1);
		company.setBalance(1000);
		company.setName("Apple");
		
		Distribution d = CompagnyService.distributeGift(user, company, 50, Type.MEAL);
		Calendar end = d.getEndDate();

		assertThat(user.getBalance()).isEqualTo(50);
		assertThat(company.getBalance()).isEqualTo(950);
		assertThat(end.get(Calendar.MONTH)).isEqualTo(1);
		assertThat(end.get(Calendar.DAY_OF_MONTH)).isEqualTo(28);
	}

	@Test
	void distributionMealFailedTest() {
		User user = new User();
		user.setId(1);
		user.setBalance(0);
		
		Company company = new Company();
		company.setId(1);
		company.setBalance(100);
		company.setName("Apple");
		
		Distribution d = CompagnyService.distributeGift(user, company, 1000, Type.MEAL);

		assertThat(user.getBalance()).isEqualTo(0);
		assertThat(company.getBalance()).isEqualTo(100);
		assertThat(d).isEqualTo(null);
	}

	@Test
	void calculateBalanceUserTest() {
		User user = new User();
		user.setId(1);
		Calendar expired = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		expired.set(Calendar.YEAR, 2020);
		end.add(Calendar.YEAR, 1);
		
		ArrayList<Distribution> list = new ArrayList<>();
		list.add(new Distribution() {{
			setAmount(200);
			setEndDate(expired);
			setUserId(1);
		}});
		list.add(new Distribution() {{
			setAmount(400);
			setEndDate(end);
			setUserId(1);
		}});
		list.add(new Distribution() {{
			setAmount(100);
			setEndDate(end);
			setUserId(1);
		}});
		
		int balance = UserService.calculateBalanceUserFromDistributions(user, list);
		assertThat(user.getBalance()).isEqualTo(balance);
		assertThat(balance).isEqualTo(500);
	}
}
