package projPack1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *	JUnit Tests for Project 1.
 *
 * @author Corey Walcott & Wilson Armstrong
 * @version fluid, like V3.0 (2/7/21)
 *
 */

public class TestStopWatch {

	/******************************************************************
	 * The following tests are for the methods that create stopwatches.
	 */
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}

	@Test
	public void testConstructor3Parameters()
	{
		StopWatch s = new StopWatch(2,3,4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorString()
	{
		StopWatch s = new StopWatch("9:00:00:000");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorNegMin()
	{
		StopWatch s1 = new StopWatch(-2,3,4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorNegSec()
	{
		StopWatch s1 = new StopWatch(2,-3,4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorNegMillis()
	{
		StopWatch s2 = new StopWatch(2,3,-4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersSeconds() {
		StopWatch s = new StopWatch(12,67,14);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersMillis() {
		StopWatch s = new StopWatch(12,59,1003);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2Parameters() {
		StopWatch s = new StopWatch(67,14);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2Seconds() {
		StopWatch s = new StopWatch(40,2014);
	}

	@Test
	public void testNormalConstructor() {
		StopWatch s = new StopWatch(5,10,300);
		assertEquals("5:10:300",s.toString());
	}

	@Test
	public void testAbnormalConstructor(){
		StopWatch s = new StopWatch("20:10:8");

		assertEquals("20:10:008",s.toString());
	}

	@Test
	public void testAbnormalConstructor2(){
		StopWatch s = new StopWatch("20:8");

		assertEquals("0:20:008",s.toString());
	}

	@Test
	public void testAbnormalConstructor3(){
		StopWatch s = new StopWatch("8");

		assertEquals("0:00:008",s.toString());
	}

	@Test
	public void testDoubleConstructor(){
		StopWatch s = new StopWatch(10, 900);

		assertEquals("0:10:900",s.toString());
	}

	@Test
	public void testDoubleConstructor2(){
		StopWatch s = new StopWatch(3, 40);

		assertEquals("0:03:040",s.toString());
	}

	@Test
	public void testDoubleConstructor3(){
		StopWatch s = new StopWatch(50, 5);

		assertEquals("0:50:005",s.toString());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegSingleInput2() {
		new StopWatch(-2);

	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:-23");

	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");

	}

	@Test (expected = IllegalArgumentException.class)
	public void testAlphaInput() {
		new StopWatch("a");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAlphaInput2Params() {
		new StopWatch("a:a");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAlphaInput3Params() {
		new StopWatch("a:a:a");
	}

	@Test
	public void testStopWatchParamTest(){
		StopWatch s1 = new StopWatch(8, 3, 100);
		StopWatch s2 = new StopWatch(s1);

		assertEquals(s1, s2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void StopWatchParamTest2(){
		StopWatch s1 = null;
		StopWatch s2 = new StopWatch(s1);

	}

	@Test (expected = IllegalArgumentException.class)
	public void StopWatchParamTest3(){
		String string = null;
		StopWatch s1 = new StopWatch(string);

	}

	@Test
	public void testSingleParam1(){
		StopWatch s1 = new StopWatch(420000);
		assertEquals(7, s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public  void testSingleParam2(){
		StopWatch s2 = new StopWatch(450458);
		assertEquals("7:30:458",s2.toString());
	}

	@Test
	public void testSingleParam3(){
		StopWatch s3 = new StopWatch(699990);

		assertEquals(11, s3.getMinutes());
		assertEquals(39, s3.getSeconds());
		assertEquals(990, s3.getMilliseconds());
	}

	/******************************************************************
	 * The following tests are for the equals method.
	 */

	@Test
	public void testEqualsTest() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		assertEquals(s1, s2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEqualsFirstNull() {
		StopWatch s1 = null;
		StopWatch s2 = new StopWatch(5,59,300);

		assertFalse(StopWatch.equals(s1, s2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEqualsSecondNull() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = null;

		assertFalse(StopWatch.equals(s1, s2));
	}

	@Test
	public void testEqualTrue(){

		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s4 = new StopWatch(5,59,300);

		assertTrue (s1.equals(s4));
		assertTrue (s4.equals(s1));

	}

	@Test
	public void testEqualFalse () {

		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,1,200);
		StopWatch s3 = new StopWatch(5,50,200);

		assertFalse(s1.equals(s2));
		assertFalse(s1.equals(s3));

	}

	@Test
	public void testEqualsTwoObjectPass () {

		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);

		assertFalse(StopWatch.equals(s1,s2));
	}

	@Test
	public void testEqualsTwoObjectPass2 () {

		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		assertTrue(StopWatch.equals(s1,s2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void StopWatchEqualsNullTest(){
		StopWatch s1 = null;
		StopWatch s2 = null;

		assertTrue(StopWatch.equals(s1,s2));
	}

	@Test
	public void StopWatchEqualsPassedNull(){
		StopWatch s2 = new StopWatch();
		Object s1 = new Object();

		assertFalse(s2.equals(s1));

	}

	/******************************************************************
	 * The following tests are for the compare method.
	 */

	@Test (expected = IllegalArgumentException.class)
	public void StopWatchCompareToPassedNull(){
		StopWatch s1 = new StopWatch();
		StopWatch s2 = null;
		s1.compareTo(s2);
	}

	@Test
	public void testStopWatchCompareToSame(){
		StopWatch s1 = new StopWatch(9,10,10);
		StopWatch s2 = new StopWatch(9,10,10);
		assertEquals(0, s1.compareTo(s2));
	}

	@Test
	public void testStopWatchCompareToPassedMinutes(){
		StopWatch s1 = new StopWatch(10,10,10);
		StopWatch s2 = new StopWatch(9,11,10);
		assertEquals(1, s1.compareTo(s2));
	}

	@Test
	public void testStopWatchCompareToPassedMinutes2(){
		StopWatch s1 = new StopWatch(9,0,0);
		StopWatch s2 = new StopWatch(10,0,0);
		assertEquals(-1, s1.compareTo(s2));
	}

	@Test
	public void testStopWatchCompareToPassedSeconds(){
		StopWatch s1 = new StopWatch(9,10,10);
		StopWatch s2 = new StopWatch(9,9,10);
		assertEquals(1, s1.compareTo(s2));
	}

	@Test
	public void testStopWatchCompareToPassedSeconds2(){
		StopWatch s1 = new StopWatch(9,9,10);
		StopWatch s2 = new StopWatch(9,10,11);
		assertEquals(-1, s1.compareTo(s2));
	}

	@Test
	public void testStopWatchCompareToPassedMillis(){
		StopWatch s1 = new StopWatch(9,10,10);
		StopWatch s2 = new StopWatch(9,10,9);
		assertEquals(1, s1.compareTo(s2));
	}

	@Test
	public void testStopWatchCompareToPassedMillis2(){
		StopWatch s1 = new StopWatch(9,10,9);
		StopWatch s2 = new StopWatch(9,10,10);
		assertEquals(-1, s1.compareTo(s2));
	}

	/******************************************************************
	 * The following tests are for the addition and subtraction methods.
	 */

	@Test
	public void testAddStopWatchWhole(){
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,2,300);
		s1.add(s2);
		assertEquals("8:01:600",s1.toString());

	}

	@Test
	public void testAddStopWatchMinutes(){
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,0,0);
		s1.add(s2);
		assertEquals ("7:59:300", s1.toString());

	}

	@Test
	public void testAddStopWatchSeconds(){
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(0,2,0);
		s1.add(s2);
		assertEquals ("6:01:300", s1.toString());

	}

	@Test
	public void testAddStopWatchMillis(){
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,2,300);
		s1.add(s2);
		assertEquals ("8:01:600", s1.toString());

	}

	@Test
	public void testAddSuspendStopWatchObject(){
		StopWatch s1 = new StopWatch();
		StopWatch s2 = new StopWatch(0,0,1);
		StopWatch.setSuspend(true);
		s1.add(s2);
		StopWatch.setSuspend(false);
		assertEquals(0, s1.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void StopWatchAddPassedNull(){
		StopWatch s1 = new StopWatch();
		StopWatch s2 = null;
		s1.add(s2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddNegMillis() {
		StopWatch s1 = new StopWatch(5,59,300);
		s1.add(-200);
	}

	@Test
	public void testAddMilliseconds () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		s1.add(2000);
		assertEquals ("6:01:300", s1.toString());
	}

	@Test
	public void testSubMilliseconds () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		s1.sub(2000);
		assertEquals ("5:57:300", s1.toString());
	}

	@Test
	public void testSubLotsOfMilliseconds () {
		StopWatch s1 = new StopWatch(5,59,300);
		s1.sub(245300);
		assertEquals ("1:54:000", s1.toString());
	}

	@Test
	public void testSubStopWatch () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(3,59,300);
		s1.sub(s2);
		assertEquals ("2:00:000", s1.toString());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubNegMillis () {
		StopWatch s1 = new StopWatch(5,59,300);
		s1.sub(-400);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubMilliseconds2 () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		s1.sub(-2000);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubNullObject () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = null;
		s1.sub(s2);
	}

	@Test
	public void testSubRolloverMillis () {
		StopWatch s1 = new StopWatch(5,59,300);
		s1.sub(400);
		assertEquals(58, s1.getSeconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubStopWatchNegativeMinutes () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(3,59,300);
		s2.sub(s1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubStopWatchNegativeSeconds () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,58,300);
		s2.sub(s1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubStopWatchNegativeMillis () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,400);
		StopWatch s2 = new StopWatch(3,59,300);
		s2.sub(s1);
	}

	/******************************************************************
	 * The following tests are for the increment and decrement methods.
	 */

	@Test
	public void testAddIncrementTestMinutes(){
		StopWatch s1 = new StopWatch(8,1,600);

		for (int i = 0; i < 600000; i++)
			s1.inc();

		assertEquals ("18:01:600", s1.toString());
	}

	@Test
	public void testAddIncrementTestSeconds(){
		StopWatch s1 = new StopWatch(8,1,600);

		for (int i = 0; i < 15000; i++)
			s1.inc();

		assertEquals ("8:16:600", s1.toString());
	}

	@Test
	public void testAddIncrementTestMillis(){
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(8,1,600);

		for (int i = 0; i < 500; i++)
			s1.inc();

		assertEquals ("8:02:100", s1.toString());
	}

	@Test
	public void testDecMilliseconds () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		for(int i = 0; i < 300; i++){
			s1.dec();
		}
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testDecMilliseconds2 () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		for(int i = 0; i < 14000; i++){
			s1.dec();
		}
		assertEquals("5:45:300", s1.toString());
	}

	@Test
	public void testDecMilliseconds3 () {
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch(5,59,300);
		for(int i = 0; i < 200000; i++){
			s1.dec();
		}
		assertEquals("2:39:300", s1.toString());
	}

	/******************************************************************
	 * The following tests are for the conversion methods.
	 */

	/******************************************************************
	 * The following tests are for the suspend methods.
	 */

	@Test
	public void testSuspended(){
		StopWatch s1 = new StopWatch();
		StopWatch.setSuspend(true);
		assertTrue(StopWatch.isSuspended());
		StopWatch.setSuspend(false);
	}

	@Test
	public void testMutate () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		StopWatch.setSuspend(true);
		s1.add(1000);
		assertTrue (s1.equals(s2));
		StopWatch.setSuspend(false);
	}

	@Test	(expected = IllegalArgumentException.class)
	public void testAddSuspendNullObject(){
		StopWatch s1 = new StopWatch();
		StopWatch s2 = null;
		StopWatch.setSuspend(true);
		s1.add(s2);
		StopWatch.setSuspend(false);
	}

	/******************************************************************
	 * The following tests are for the save and load methods.
	 */

	@Test (expected = IllegalArgumentException.class)
	public void testNullSave(){
		StopWatch s1 = new StopWatch();
		s1.save(null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveIOException(){
		StopWatch s1 = new StopWatch();
		s1.save("");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNullLoad(){
		StopWatch s1 = new StopWatch();
		s1.load(null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNameNotFoundLoad(){
		StopWatch s1 = new StopWatch();
		s1.load("NOTHING HERE");
	}

	@Test
	public void testLoadSave () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		s1.save("file1");
		s1 = new StopWatch();  // resets to zero

		s1.load("file1");
		assertTrue (s1.equals(s2));
	}

	/******************************************************************
	 * The following tests are for the toString method.
	 */

	@Test
	public void testDefaultConstructorToString() {
		StopWatch s = new StopWatch();
		assertEquals("0:00:000", s.toString());
	}

	@Test
	public void testToStringSingleSec(){
		StopWatch s = new StopWatch(0,0,9);
		assertEquals("0:00:009", s.toString());

	}

	@Test
	public void testToStringSingleSecDoubleMilli(){
		StopWatch s = new StopWatch(5,6,39);
		assertEquals("5:06:039", s.toString());

	}

	@Test
	public void testToStringDoubleSeconds(){
		StopWatch s = new StopWatch(5, 55, 999);
		assertEquals("5:55:999", s.toString());
	}

	@Test
	public void testToStringDoubleSecondsSingleMilli(){
		StopWatch s = new StopWatch(5, 50, 1);
		assertEquals("5:50:001", s.toString());
	}

	@Test
	public void testToStringDoubleSecondsDoubleMilli(){
		StopWatch s = new StopWatch(5, 50, 10);
		assertEquals("5:50:010", s.toString());
	}

	/******************************************************************
	 * The following tests are for the set and get methods.
	 */

	@Test
	public void testSetMinutes(){
		StopWatch s1 = new StopWatch();
		s1.setMinutes(10);
		assertEquals(10, s1.getMinutes());
	}

	@Test
	public void testSetSeconds(){
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch();
		s1.setSeconds(10);
		assertEquals(10, s1.getSeconds());
	}

	@Test
	public void testSetMilliseconds(){
		StopWatch s1 = new StopWatch();
		s1.setMilliseconds(100);
		assertEquals(100, s1.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetNegMinutes(){
		StopWatch s1 = new StopWatch();
		s1.setMinutes(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetNegSeconds(){
		StopWatch.setSuspend(false);
		StopWatch s1 = new StopWatch();
		s1.setSeconds(-10);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetNegMilliseconds(){
		StopWatch s1 = new StopWatch();
		s1.setMilliseconds(-100);
	}

	@Test
	public void testSetMinutesWhileSuspend(){
		StopWatch s1 = new StopWatch();
		StopWatch.setSuspend(true);
		s1.setMinutes(1);
		assertEquals(0, s1.getMinutes());
	}

	@Test
	public void testSetSecondsWhileSuspended(){
		StopWatch s1 = new StopWatch();
		StopWatch.setSuspend(true);
		s1.setSeconds(10);
		assertEquals(0, s1.getSeconds());
	}

	@Test
	public void testSetMillisecondsWhileSuspended(){
		StopWatch s1 = new StopWatch();
		StopWatch.setSuspend(true);
		s1.setMilliseconds(100);
		assertEquals(0, s1.getMilliseconds());
	}


}

