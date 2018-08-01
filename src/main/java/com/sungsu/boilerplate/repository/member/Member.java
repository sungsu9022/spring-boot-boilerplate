package com.sungsu.boilerplate.repository.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}
}
