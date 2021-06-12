package fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


class FizzbuzzTest {
	Fizzbuzz obj = new Fizzbuzz();
	

	@Test
	void Fizzbuzz_test() {
		assertEquals(9, obj.fizzbuzz(9));
	}

}
