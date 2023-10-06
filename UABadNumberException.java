public class UABadNumberException extends Exception {

	public UABadNumberException(String message) {
		super(message);
	}

	public static void run(int x, int y) throws UABadNumberException {
		int sum = x + y;
		if (x >= y * 2) {
			throw new UABadNumberException(sum + "");
		}
	}

	public static void main(String[] args) {
		try {
			run(5, 2);
		} catch (UABadNumberException e) {
			e.printStackTrace();
		}
	}

}