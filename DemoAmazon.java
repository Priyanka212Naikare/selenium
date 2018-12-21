package day7;

public class DemoAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonProject ap = new AmazonProject();

		ap.invokeBrowser("chrome");

		ap.searchProduct("Rado Watch", "Watches");

		ap.printNthProduct(9);

		ap.printAllProductsViaScrollDownUsingJS();

	}

}
