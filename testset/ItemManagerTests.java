package testset;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import interfaces.IItem;
import interfaces.IManager;
import itemset.Elixir;
import itemset.ItemManager;
import itemset.Potion;

public class ItemManagerTests
{

	IManager<IItem> test;
	@Before
	public void setUp() throws Exception
	{
		test = new ItemManager();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSet()
	{
		IItem obj = new Potion();
		test.set(obj);
		assertEquals("Potion", test.get(0).getName());
	}
	
	@Test
	public void testSize()
	{
		IItem obj = new Potion();
		test.set(obj);
		assertEquals(1, test.size());
	}

	@Test
	public void testHas()
	{
		IItem obj = new Potion();
		test.set(obj);
		assertTrue(test.has(obj));
	}
	
	@Test
	public void testRemove()
	{
		IItem obj = new Potion();
		test.set(obj);
		test.remove(0);
		assertFalse(test.has(obj));
	}
	
	@Test
	public void testReplace()
	{
		IItem obj = new Potion();
		IItem rep = new Elixir();
		test.set(obj);
		assertEquals(obj, test.replace(rep, 0));
	}
	
	@Test
	public void testIndexOf()
	{
		IItem obj = new Potion();
		test.set(obj);
		assertEquals(0, test.indexOf(obj));
	}
}
