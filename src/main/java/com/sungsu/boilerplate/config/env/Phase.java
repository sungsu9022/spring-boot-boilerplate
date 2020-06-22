package com.sungsu.boilerplate.config.env;

import lombok.Getter;

@Getter
enum Phase {
	LOCAL, DEV, REAL;

	static Phase from(String phase) {
		return Phase.valueOf(phase.toUpperCase());
	}
}
