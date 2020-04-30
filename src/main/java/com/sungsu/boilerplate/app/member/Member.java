package com.sungsu.boilerplate.app.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "member")
@Getter
public class Member {
	@Id
	@GeneratedValue
	private int id;
}
