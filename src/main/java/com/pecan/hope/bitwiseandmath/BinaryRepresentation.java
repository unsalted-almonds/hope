package com.pecan.hope.bitwiseandmath;

/**
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, return
 * the binary representation that is passed in as a string. If the fractional
 * part of the number can not be represented accurately in binary with at most
 * 32 characters, return ERROR. Example For n = "3.72", return "ERROR".
 * 
 * For n = "3.5", return "11.1".
 * 
 * @author Shilin
 *
 */
public class BinaryRepresentation {

	/**
	 * @param n:
	 *            Given a decimal number that is passed in as a string
	 * @return: A string
	 */
	public String binaryRepresentation(String n) {
		// write your code here

		String[] token = n.split("\\.");

		Integer integer = Integer.parseInt(token[0]);
		String integerStr = integerDecToBin(integer);

		if (token.length == 1 || Long.parseLong(token[1]) == 0) {
			return integerStr;
		}

		Double fraction = Double.parseDouble("0." + token[1]);
		String fractionStr = fractionDecToBin(fraction);

		if (fractionStr.equals("ERROR")) {
			return "ERROR";
		}

		return integerStr + "." + fractionStr;

	}

	private String integerDecToBin(Integer dec) {
		StringBuffer sb = new StringBuffer();
		while (dec != 0) {
			sb.insert(0, dec % 2);
			dec /= 2;
		}

		return (sb.length() == 0) ? "0" : sb.toString();
	}

	private String fractionDecToBin(Double dec) {
		StringBuffer sb = new StringBuffer();
		Integer count = 32;
		while (Double.compare(dec, 0) != 0 && count-- > 0) {
			dec *= 2;
			if (dec >= 1) {
				sb.append(1);
				dec--;
			} else {
				sb.append(0);
			}
		}

		if (count <= 0 && Double.compare(dec, 0) != 0) {
			return "ERROR";
		}

		return sb.toString();

	}
}
