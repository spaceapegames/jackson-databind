package com.fasterxml.jackson.databind.util;

import org.junit.Assert;
import org.junit.Test;
import com.fasterxml.jackson.databind.BaseMapTest;

public class ArrayBuildersTest extends BaseMapTest
{
	@Test
	public void testInsertInListNoDup() {
		String [] arr = new String[]{"me", "you", "him"};
		String [] newarr = ArrayBuilders.insertInListNoDup(arr, "you");		
		Assert.assertArrayEquals(newarr, arr);
		
		newarr = ArrayBuilders.insertInListNoDup(arr, "me");
		Assert.assertArrayEquals(newarr, arr);
		
		newarr = ArrayBuilders.insertInListNoDup(arr, "him");
		Assert.assertArrayEquals(newarr, arr);
	}

	// Test for [Issue#157]
	public void testInsertInListNoDup()
	{
        String [] arr = new String[]{"me", "you", "him"};
        String [] newarr;
        
        newarr = ArrayBuilders.insertInListNoDup(arr, "you");
        Assert.assertArrayEquals(new String[]{"you", "me", "him"}, newarr);

        newarr = ArrayBuilders.insertInListNoDup(arr, "me");
        Assert.assertArrayEquals(new String[]{"me", "you","him"}, newarr);

        newarr = ArrayBuilders.insertInListNoDup(arr, "him");
        Assert.assertArrayEquals(new String[]{"him", "me", "you"}, newarr);

        newarr = ArrayBuilders.insertInListNoDup(arr, "foobar");
        Assert.assertArrayEquals(new String[]{"foobar", "me", "you", "him"}, newarr);
	}

}
