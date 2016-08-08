package dzone.splurth.periodicTable;

public class SimpleSymbolProcessor {

	public static boolean process (String elementName, String symbol) {
		System.out.println();
		System.out.println("Processing symbol " + symbol + " for element name " + elementName + "::");
		boolean accept = false;
		int[][] pt = new int[26][26];
		for (int i=0; i<26; i++) {
			for (int j=0; j<26; j++) {
				pt[i][j] = 0;
			}
		}
		
		int distinctSymbols = 0;
		int firstSymbolValue = 2526;
		if (elementName != null && elementName.matches("[A-Z][a-z]+")) {
			char[] elementNameChars = elementName.toLowerCase().toCharArray();
			for (int i = 0; i < elementNameChars.length; i++) {
				for (int j = (i + 1); j < elementNameChars.length; j++) {
					int ival = elementNameChars[i]-97;
					int jval = elementNameChars[j]-97;
					if (firstSymbolValue > (ival * 100 + jval)) {
						firstSymbolValue = (ival * 100 + jval);
					}
					if (pt[ival][jval] == 0) {
						distinctSymbols++;
						pt[ival][jval] = 1;
					}					
				}
			}
			System.out.println("Distinct Symbol Code Count :: " + distinctSymbols);
			System.out.println("First Alphabetical Symbol Code :: " + (new StringBuilder(2).append((char)(firstSymbolValue/100 + 65)).append((char)(firstSymbolValue%100 + 97)).toString()));
		}
		
		if (symbol != null && symbol.length() == 2 && symbol.matches("[A-Z][a-z]")) {
			if (pt[symbol.toLowerCase().charAt(0) - 97][symbol.toLowerCase().charAt(1) - 97] == 1) {
				accept = true;
			}
		}
		System.out.println("Validation status :: " + (accept?"ACCEPTED":"DENIED"));
		return accept;
	}
	
	public static void main(String[] args) {
		
		SimpleSymbolProcessor.process("Gozerium", "");
		SimpleSymbolProcessor.process("Slimyrine", "");
		SimpleSymbolProcessor.process("Zuulon", "");
		
		SimpleSymbolProcessor.process("Spenglerium", "Ee");
		SimpleSymbolProcessor.process("Zeddemorium", "Zr");
		SimpleSymbolProcessor.process("Venkmine", "Kn");
		SimpleSymbolProcessor.process("Stantzon", "Zt");
		SimpleSymbolProcessor.process("Melintzum", "Nn");
		SimpleSymbolProcessor.process("Tullium", "Ty");
		
	}

}
