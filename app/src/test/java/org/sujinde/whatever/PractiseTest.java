package org.sujinde.whatever;

import android.util.Log;

import com.orhanobut.logger.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.sujinde.utils.Logg;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class PractiseTest {

	@Inject
	Practise practise;

	@Test
	public void testRxJava() throws Exception {
//		Practise practise = new Practise();
//		System.out.println(practise.rxJava());
		practise.rxJava();
	}
}