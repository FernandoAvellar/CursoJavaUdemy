package utility;

public class CurrencyConverter {
	
	public static final double IOF = 1.06; // 6% de IOF nas conversões
	
	public static double usdToReal(double dolarAmount, double dolarQuotation) {
		return dolarAmount * dolarQuotation * IOF;
	}

}
