package com.design.snl;

import java.util.Random;

public class RollDice {
	public static int roll() {
		return new Random().nextInt(6)+1;
	}
}
