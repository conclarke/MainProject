package group2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import order.Product;

public class RetailSystemDriver {

	/*
	 * private String name, email, contactNumber, address, password,
	 * password2,accessLevel;
	 */

	private PersonDB personDB;
	private StockControl stockControl;
	private static boolean hasAccessLevelSet;
	private static boolean priviledged;
	Product product;
	public static final Pattern VALID_CONTACT_NUMBER_REGEX = Pattern
			.compile("^[0].[0-9]{9,10}$",
					Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_ACCESS_LEVEL_REGEX = Pattern
			.compile("^[1-2]$",
					Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile(
					"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
					Pattern.CASE_INSENSITIVE);

	/**
	 * Check that the access level matches the relevant regular expression.
	 */
	public static boolean validateAccessLevel(
			String alStr) {
		Matcher matcher = VALID_ACCESS_LEVEL_REGEX
				.matcher(alStr);
		return matcher.find();
	}

	/**
	 * Check that the email matches the relevant regular expression.
	 */
	public static boolean validateEmail(
			String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX
				.matcher(emailStr);
		return matcher.find();
	}

	/**
	 * Check that the contact number matches the relevant regular expression.
	 * 
	 * <pre>
	 * Phone numbers must match the following format:
	 * - Contain only numeric characters (0 to 9)
	 * - Begin with a zero (0)
	 * - Be 9 or 10 numbers long
	 * </pre>
	 */
	public static boolean validateContactNumber(
			String phoneStr) {
		Matcher matcher = VALID_CONTACT_NUMBER_REGEX
				.matcher(phoneStr);
		return matcher.find();
	}

	public static boolean isPriviledged() {
		return priviledged;
	}

	public static void setPriviledged(boolean priv) {
		if (!hasAccessLevelSet) {
			priviledged = priv;
			hasAccessLevelSet = true;
		}
	}

	/**
	 * Main driver for the system. The operation of the entire system is set up
	 * here.
	 */
	public RetailSystemDriver() {
		personDB = new PersonDB();

		personDB.automaticallyCreateStaff();
		personDB.automaticallyCreateSupplier();
		personDB.automaticallyCreateCustomer();
		automaticallyCreateProducts();
		stockControl = new StockControl();

		new Login(personDB, stockControl);
	}

	/**
	 * Add Products automatically generated
	 */
	private void automaticallyCreateProducts() {
		product = new Product(
				"Asus EeeePC 1015px",
				"Atom N570 / 1.66 GHz - Windows 7 Starter - 1 GB RAM - 250 GB HDD - 10.1 inches wide 1024 x 600 - Intel GMA 3150 - black Series",
				"Laptop", 200, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 22);
		product = new Product(
				"Apple MacBook Pro",
				"2.0GHz Intel Core i7 - 4 GB RAM - 1,280x800-pixel 15inches display - 500 GB SSD - OSX 10.9.3 Mawericks",
				"Laptop", 1000, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 5);
		product = new Product(
				"HP Chromebook 11",
				"1.7 GHz Samsung Exynos 5250 - 2GB RAM - 11.6 inches 1366 x 768 display - ARM Mali-T604 Graphics - 16GB SSD - Google Chrome OS",
				"Laptop", 350, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 8);

		product = new Product(
				"Apple iPad mini",
				"Battery Life:6 hours 8 minutes Bluetooth Version:4.0 Camera Resolution:1.2MP Front; 5MP Rear Cellular Technology :CDMA 1X EDGE EV-DO EV-DO Rev A GSM HSDPA HSPA HSPA+ LTE UMTS CPU:Apple A7 Dimensions:7.87 x 5.3 x 0.29 (HWD) inches Operating System:Apple iOS Ports:Apple Lightning Screen Pixels Per Inch:326 Screen Resolution:2048 x 1536 pixels Screen Size:7.9 inches Screen Type:Retina Service Provider:AT&T Sprint T-Mobile Verizon Wireless Storage Capacity (as Tested):16 GB Storage Type:SSD Touch Screen:Yes Video Camera Resolution:720p Front; 1080p Rear Weight:11.68 oz Wi-Fi (802.11x) Compatibility:2.4GHz/5GHz",
				"Tablet", 400, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 7);
		product = new Product(
				"Amazon Kindle Fire HDX",
				"Battery Life:44 minutes 7 hours Bluetooth Version:4.0 Camera Resolution:8-megapixel Rear-Facing; 720p Front-Facing Cellular Technology :EDGE GPRS HSDPA HSPA+ LTE CPU:Qualcomm Snapdragon 800 Quad-Core Dimensions:9.1 x 6.2 x 0.31 inches GPS:Yes Graphics Card:ARM Adreno 330 Operating System:Google Android 4.2.2 Ports:micro USB Processor Speed:2.2 GHz RAM:2 GB Screen Pixels Per Inch:339 ppi Screen Resolution:2560 x 1600 pixels Screen Size:8.9 inches Screen Type:IPS LCD Service Provider:AT&T Storage Capacity (as Tested):16 GB Storage Type:SSD Video Camera Resolution:1080p Rear; 720p Front Weight:13.5 oz Wi-Fi (802.11x) Compatibility:2.4GHz/5GHz",
				"Tablet", 330, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 12);
		product = new Product(
				"Samsung Galaxy Note ",
				"Additional Storage:MicroSD Battery Life:31 minutes 7 hours Battery Size:8220 mAh Bluetooth Version:4.0 Camera Resolution:8-megapixel Rear-Facing; 2-megapixel Front CPU:Samsung Exynos 5420 Dimensions:9.57 x 6.75 x 0.31 inches GPS:Yes Operating System:Google Android 4.3 Ports:MHL micro USB Processor Speed:1.9 GHz RAM:3 GB Screen Pixels Per Inch:298 ppi Screen Resolution:2560 x 1600 pixels Screen Size:10.1 inches Screen Type:IPS LCD Storage Capacity (as Tested):16 GB Storage Type:SSD Video Camera Resolution:1080p; 720p Weight:19.75 oz Wi-Fi (802.11x) Compatibility:2.4GHz/5GHz",
				"Tablet", 450, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 10);

		product = new Product(
				"Velocity Micro Vector Z25",
				"Graphics Card:Nvidia GeForce GTX 650 Handbrake Multimedia Tests:3:26 min:sec Heaven - Max quality - Native - AA/AF=4X/4X:18 Heaven - Mid quality - 1,366 x 768 - AA/AF=Off/Off:43 Operating System:Microsoft Windows 8 PCMark7:5554 Photoshop CS6 Multimedia Tests:5.62 min:sec Primary Optical Drive:Dual-Layer DVD+/-RW Processor Name:Intel Core i5-3470 Processor Speed:3.2 GHz RAM:8 GB Storage Capacity (as Tested):1000 GB",
				"Desktop", 700, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 7);
		product = new Product(
				"V3 Gaming Devastator",
				"Operating System:Microsoft Windows 8 PCMark7:7013 Photoshop CS6 Multimedia Tests:2:40 min:sec Primary Optical Drive:Dual-Layer DVD+/-RW Processor Family:Intel Core i5 Processor Name:Intel Core i5-4670K Processor Speed:3.4 GHz RAM:16 GB Storage Capacity (as Tested):1256 GB Storage Type:HDD SSD Tech Support:3 year limited parts/lifetime labor. Type:Gaming",
				"Desktop", 900, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 9);
		product = new Product(
				"Acer Predator AG3-605-UR20",
				"Operating System:Microsoft Windows 8 PCMark7:4088 Photoshop CS6 Multimedia Tests:2:58 min:sec Primary Optical Drive:Blu-Ray Disc Processor Family:Intel Core i7 Processor Name:Intel Core i7-4770 Processor Speed:3.4 GHz RAM:32 GB Storage Capacity (as Tested):3024 GB Storage Type:HDD SSD Tech Support:1-year limited warranty",
				"Desktop", 600, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 6);

		product = new Product(
				"LG G Flex",
				"802.11x/Band(s):802.11 b/g/n/ac Available Integrated Storage:24 GB Bands:1700 1800 1900 700 850 900 Bluetooth Version:4 Camera Resolution:13 MP Rear; 2.1 MP Front-Facing CPU:Qualcomm Snapdragon 800 Quad-Core Dimensions:6.32 x 3.21 x 0.31 inches Form Factor:Candy Bar GPS:Yes High-Speed Data:GPRS HSPA+ 21 LTE UMTS microSD Slot :No NFC:Yes Operating System as Tested:Android 4.2.2 Phone Capability / Network:GPRS GSM LTE UMTS Physical Keyboard:No Processor Speed:2.26 GHz Screen Pixels Per Inch:245 ppi Screen Resolution:1280 x 720 pixels Screen Size:6 inches Screen Type:P-OLED Service Provider:AT&T Total Integrated Storage:32 GB Video Camera Resolution:1080p Weight:6.24 oz",
				"Smartphone", 400, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 5);
		product = new Product(
				"Google Nexus 5",
				"802.11x/Band(s):802.11 a/b/g/n/ac Available Integrated Storage:26.42 GB Bands:1800 1900 850 900 Battery Life (As Tested):14 hours 43 minutes Bluetooth Version:4.0 Camera Resolution:8 MP rear; 1.3 MP front Capacities Available:16GB; 32GB Colors Available:Black; White CPU:Qualcomm Snapdragon 800 Quad-Core Dimensions:5.43 x 2.72 x 0.34 (HWD) inches Form Factor:Candy Bar GPS:Yes High-Speed Data:LTE microSD Slot :No NFC:Yes Operating System as Tested:Android OS Phone Capability / Network:CDMA GSM LTE Physical Keyboard:No Processor Speed:2.26 GHz Screen Pixels Per Inch:445 ppi Screen Resolution:1920 x 1080 pixels Screen Size:4.95 inches Screen Type:IPS LCD Service Provider:AT&T Sprint T-Mobile Unlocked Total Integrated Storage:32 GB Weight:4.59 oz",
				"Smartphone", 300, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 2);
		product = new Product(
				"Apple iPhone 5S",
				"802.11x/Band(s):4.0 Bands:1700 1900 2100 850 900 UMTS Battery Life (As Tested):9 hours Bluetooth Version:Yes Camera Resolution:8 MP Rear; 1.2 MP Front Capacities Available:32GB 64GB Space Gray Colors Available:Gold Silver CPU:Apple A7 Dimensions:4.87 x 2.31 x 0.3 inches Form Factor:Candy bar GPS:No High-Speed Data:16GB EVDO Rev A HSPA+ 42 LTE microSD Slot :GSM NFC:16 GB Operating System as Tested:iOS Phone Capability / Network:800 CDMA LTE UMTS Processor Speed:1.3GHz Screen Pixels Per Inch:326 Screen Resolution:1136 x 640 pixels Screen Size:4 inches Screen Type:LCD Service Provider:Verizon Wireless Total Integrated Storage:No Video Camera Resolution:802.11 a/b/g/n",
				"Smartphone", 220, personDB
						.getRandomSupplier());
		stockControl.addNewProductToStockList(
				product, 6);
	}

	public static void main(String args[]) {
		new RetailSystemDriver();
	}
}
