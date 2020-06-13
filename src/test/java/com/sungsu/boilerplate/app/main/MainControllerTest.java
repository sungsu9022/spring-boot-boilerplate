package com.sungsu.boilerplate.app.main;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

class MainControllerTest {

	@Test
	public void test() {
		Collection<Object> collection;
		HashFunction hashFunction = Hashing.adler32();
	}
}