package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest
{
	@Test
	public void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		assertEquals("getBalance", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		double amount1;
		double amount2;
		double amount3;
		
		issuingStore = 1337;
		balance = 100.00;
		
		amount1 = -100.00;
		amount2 = 50.00;
		amount3 = 150.00;
		
		String result2 = "Remaining Balance: " + String.format("%6.2f", Math.abs(50.00));
		String result3 = "Amount Due: " + String.format("%6.2f",Math.abs(-100.00));
		
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct()", "Invalid Transaction", card.deduct(amount1));
		assertEquals("deduct()", result2, card.deduct(amount2));
		assertEquals("deduct()", result3, card.deduct(amount3));
	}
	
	@Test
	public void throwException()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}

	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_high()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(100000,100.00);});
	}
}