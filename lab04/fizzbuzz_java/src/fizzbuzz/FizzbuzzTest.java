package fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


class FizzbuzzTest {
	Fizzbuzz obj = new Fizzbuzz();


	@Test
	void Fizzbuzz_test() {
		assertEquals("9", obj.fizzbuzz(9));
	}
	@Test
	void Fizzbuzz_test1() {
		assertEquals("fizz", obj.fizzbuzz(5));
	}
	@Test
	void Fizzbuzz_test2() {
		assertEquals("buzz", obj.fizzbuzz(7));
	}

	@Test
	void Fizzbuzz_test3() {
		assertEquals("fizzbuzz", obj.fizzbuzz(35));
	}


}
