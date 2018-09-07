package com.sungsu.boilerplate.domain.member;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
	@Id
	@GeneratedValue
	private int id;
}
