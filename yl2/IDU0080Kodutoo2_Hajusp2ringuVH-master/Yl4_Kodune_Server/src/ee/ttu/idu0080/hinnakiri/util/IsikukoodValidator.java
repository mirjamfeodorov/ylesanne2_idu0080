package ee.ttu.idu0080.hinnakiri.util;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import java.util.regex.Pattern;

public class IsikukoodValidator {


	  /** Each Estonian personal code must match this pattern */
	  private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d{11}$");

	  /**
		 * Checks if is valid.
		 * 
		 * @param number
		 *			the number
		 * 
		 * @return true, if is valid
		 */
	  public static boolean isValid(final String number) {
		return StringUtils.isNotBlank(number)
			   && NUMBER_PATTERN.matcher(number).matches()
			   && calculateChecksum(number) == NumberUtils.toInt(number.substring(10));
	  }


	  /**
		 * Calculates checksum number for a given personal code. By the general rule
		 * calculated checksum must be the same as the last digit of the given
		 * personal code
		 * 
		 * @param number
		 *			personal code as string
		 * 
		 * @return registration number checksum
		 */
	  private static int calculateChecksum(String number) {
		int remainder = calculateWeightRemainder(number, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1});
		if (remainder < 10) 
		  return remainder;
		if (remainder == 10) 
		  remainder = calculateWeightRemainder(number, new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2, 3});
		return remainder < 10 ? remainder : 0;
	  }

	  /**
		 * Calculate weight remainder.
		 * 
		 * @param number
		 *			the number
		 * @param weights
		 *			the weights
		 * 
		 * @return the int
		 */
	  private static int calculateWeightRemainder(final String number, final int[] weights) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {//sum up all weights
		  sum += NumberUtils.toInt(number.substring(i, i + 1)) * weights[i];
		}
		return sum % 11;//return division remainder
	  }

	}
