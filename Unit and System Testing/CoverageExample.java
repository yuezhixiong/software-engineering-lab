
public class CoverageExample {
	/**
	 * A simple function that should return exactly the provided integer input.
	 *
	 * The function below is expected to take in a value and return exactly the
	 * same value. The manner in which the return value is calculated is
	 * affected by three boolean values, but regardless of the boolean values
	 * input, the function should already return the originally provided integer
	 * value.
	 *
	 * The implementation below has a bug, but the bug only manifests itself
	 * under a specific set of inputs. The intent here is to demonstrate that
	 * not all test coverage types are sufficient to find all bugs.
	 *
	 * @param x
	 *            the value to be returned. *@param cond1 the boolean that
	 *            causes x to be incremented when true.
	 * @param cond2
	 *            the boolean that causes x to be decremented when true.
	 * @param cond3
	 *            the boolean that causes x to be multiplied by 1 when true.
	 * @return the original value of x.
	 */
	public static int identity(int x, boolean cond1, boolean cond2, boolean cond3) {
		if (cond1) { // Statement 1 (S1), Branchpoint 1 (B1)
			x++; // Statement 2 (S2)
		}
		if (cond2) { // Statement 3 (S3), Branchpoint 2 (B2)
			x--;
			// Statement 4 (S4)
		}
		if (cond3) { // Statement 5 (S5), Branchpoint 3 (B3)
			x *= 1; // Statement 6 (S6)
		}
		return x; // Statement 7 (S7)
	}
}
