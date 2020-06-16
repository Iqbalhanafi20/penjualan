package helper;

import java.text.DecimalFormat;

public class helper {
	public static String formatCurrency(int i) {
		String price = new DecimalFormat("#,###.00").format(i);

		return price;
	}
}
