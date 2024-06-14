package com.example.assignment;


import com.example.assignment.model.Bitcoin;
import com.example.assignment.repository.BitcoinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	BitcoinRepository bitcoinRepository;

	@Test
	public void testCreateBitcoin()
	{
		Bitcoin b = new Bitcoin();
		long id = 34;
		b.setId(id);
		b.setChartname("abc");
		b.setDisclaimer("This is test disclaimer");
		bitcoinRepository.save(b);
		Optional<Bitcoin> res = bitcoinRepository.findById(id);
		assertNotNull(res);
	}
	@Test
	public void testDeleteBitcoin()
	{
		long id = 34;
		bitcoinRepository.deleteById(id);
		boolean res = bitcoinRepository.existsById(id);
        assertFalse(res);
	}

}
