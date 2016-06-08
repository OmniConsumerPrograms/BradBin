package testset;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import interfaces.IItem;
import interfaces.IPrefix;
import itemset.High;
import itemset.Potion;

public class ItemTests
{

	IItem test;
	@Before
	public void setUp() throws Exception
	{
		test = new Potion();
		test = new High(test);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testGetID()
	{
		assertEquals(3, test.getID());
	}
	
	@Test
	public void testGetEventID()
	{
		assertEquals(101, test.getEventID());
	}
	
	@Test
	public void testGetName()
	{
		assertEquals("High Potion", test.getName());
	}
	
	@Test
	public void testGetType()
	{
		assertEquals("Item", test.getType());
	}
	
	@Test
	public void testGetEffectType()
	{
		assertEquals("More of Yeah that hit the spot", test.getEffectType());
	}
	
	@Test
	public void testGetPrefixID()
	{
		assertEquals(2, ((IPrefix) test).getPrefixID());
	}
	
	@Test
	public void testGetEffect()
	{
		assertEquals(50.0, test.getEffect(), 0);
	}
	
	@Test
	public void testGetPFLimit()
	{
		assertEquals(0, test.getPFLimit());
	}
}
