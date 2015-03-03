/* * * * * * * * * * * * * * * * * * * * * * * * *
 *** ** @Title:  CongMingMain.java
 *** ** @author: Will_Lau
 *** ** @date:   2014-11-29
 *** ** @since   Iron
 * * * * * * * * * * * * * * * * * * * * * * * * */

import java.util.Scanner;

public class CongMingMain 
{
	private static int MAX_HONG_QIU_SHU = 33;
	private static int MIN_CREATE_NUM = 9;
	private static int DEFAULT_BINARY_NUM = 0;

	public static void main(String[] args)
	{
		int numInt = 0;
		String defaultValues = "";
		Scanner inputNum = new Scanner(System.in);

		System.out.println("please input a interger num, such as 15!");
		numInt = inputNum.nextInt();

		System.out.println("please input a default string, such as 10101011!");
		defaultValues = inputNum.next();
		inputNum.close();
		DEFAULT_BINARY_NUM = Integer.parseInt(defaultValues, 2);//the string your input is a binary number!

		if (numInt > MIN_CREATE_NUM || numInt <= MAX_HONG_QIU_SHU)
		{
			congMingForLongNumber(numInt);
		}

	}

	private static void congMingForLongNumber(int numb)
	{
		int count = 0;
		long min, max;
		long[] outptInt = new long[3000];

		min = (long) Math.pow(2, numb - 1) + DEFAULT_BINARY_NUM;	// Interger.toBinaryString(31) = 11111;
		max = (long) Math.pow(2, numb);
		System.out.println((long) Math.pow(2, numb) + " ## " + Long.toBinaryString((long) Math.pow(2, numb)) 
				+ " ### " + DEFAULT_BINARY_NUM + " min#max " + min + " # " + max);//print
		outptInt[0] = min;// 100001011000101

		try
		{
			for (long i = min; i < max; i++)
			{
				int menb = 0;

				if (Long.bitCount(i) == 6)
				{
					for (int j = 0; j < outptInt.length; j++)
					{
						if (compareBinarySamePosition(i, outptInt[j]) == 4)
						{
							menb += 1;
							continue;
						}
						else 
						{
							break;
						}
					}
				}

				if (menb == 1)
				{
					System.out.println(Long.toBinaryString(i));
					outptInt[count] = i;
					count += 1;
					menb = 0;
				}

				continue;// If not
			}
			// System.out.println(basicStringNumberString);
			System.out.println("total number is: " + count);

		} catch (Exception e){
			System.out.println("Error,Output!" + e);
		}
	}

	private static long compareBinarySamePosition(long first, long second)
	{
		int realSame = 0;
		try {
			long longNum = 0;
			longNum = first ^ second;
			realSame = Long.bitCount(longNum);

		} catch (Exception e) {
			System.out.println("Error, exchange to bitCount" + e);
		}

		return realSame;
	}
}
