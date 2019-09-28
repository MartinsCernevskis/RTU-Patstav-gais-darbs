package PatstavigaisDarbs_RTU_Java;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Random;

public class PatstavigaisDarbs_RTU_Java {

	static Scanner ievade = new Scanner(System.in);

	static String lietotajaVards;
	static String lietotajaUzvards;
	static String[] produktuSaraksts = { "1 Pusdienu komplekts BURGER", "2 Pusdienu komplekts ASIA",
			"3 Pusdienu komplekts LATVIA", "4 Pusdienu komplekts P�RSTEIGUMS" };
	static String kontakttalrunis;
	static String epatsaAdrese;
	static String piegadesAdrese;
	static int produktaDaudzums;
	static String produkts;
	static int lietotajaStatus;
	static String pasutijumaID;
	static String adminName;
	static String adminPass;
	static int jaunsPasutijums;

	private static void getUser() {

		System.out.println(
				"Labdien.\nL�dzu nor�diet darb�bu.\nAdministrators - nospiediet 1\nVeikt pas�t�jumu - nospiediet 2");
		lietotajaStatus = ievade.nextInt();
		ievade.nextLine();

		if (lietotajaStatus == 1) {
			getAdmin();
		} else
			getName();
	}

	private static void getAdmin() {

//		Scanner ievade = new Scanner(new File("C:\\Users\\User\\Martins\\RTU Java\\dati.txt"));

		System.out.println("LIETOT�JV�RDS: ");
		adminName = ievade.nextLine();

		System.out.println("PAROLE: ");
		adminPass = ievade.nextLine();

//		if (adminName.equals(admin) && adminPass.equals(1234)) {
//			System.out.print("Piesleg�an�s veiksm�ga");
//		} else {
//		System.out.print("Nepareizs lietotajv�rds vai parole");
//		getAdmin();
//			}

		System.out.println("1 Mekl�t pas�t�jumu p�c pas�t�juma ID\nIevadiet pas�t�juma ID: ");
		System.out.println("2 apskat�t visus pas�t�jumus ");
		pasutijumaID = ievade.nextLine();
		getUser();


	}

	private static void getName() {
		System.out.println("L�dzu nor�diet savu v�rdu");
		lietotajaVards = ievade.nextLine();
		getSurename();
		ievade.nextLine();
	}

	private static void getNameChange() {
		System.out.println("L�dzu nor�diet savu v�rdu");
		lietotajaVards = ievade.nextLine();
		getFinal();
	}

	private static void getSurename() {
		System.out.println("L�dzu nor�diet savu uzv�rdu");
		lietotajaUzvards = ievade.nextLine();
		System.out.println("Sveicin�ti, " + lietotajaVards + " " + lietotajaUzvards + ".\n");
		getProduct();
	}

	private static void getSurenameChange() {
		System.out.println("L�dzu nor�diet savu uzv�rdu");
		lietotajaUzvards = ievade.nextLine();
		System.out.println("Paldies, J�sus uzv�rds nomain�ts uz: " + lietotajaUzvards + ".\n");
		getFinal();
	}

	private static void getProduct() {

		int y = 1;

		do {
			try {
				System.out.println("L�dzu izv�laties produktu");
				for (int i = 0; i < produktuSaraksts.length; i++) {
					System.out.println(produktuSaraksts[i]);
				}
				int produkts = ievade.nextInt();
				ievade.nextLine();

				System.out.println("\nJ�su izv�l�tais produkts:  "
						+ produktuSaraksts[produkts - 1].substring(2, produktuSaraksts[produkts - 1].length()));
				getDaudzums();
				y = 2;

			} catch (Exception e) {
				System.out.println("Neatbilsto�s produkta kods. L�dzu atk�rtoti ievadiet v�lam� produkta kodu");
			}

		} while (y == 1);

	}

	private static void getProductChange() {

		int y = 1;

		do {
			try {
				System.out.println("L�dzu izv�laties produktu");
				for (int i = 0; i < produktuSaraksts.length; i++) {
					System.out.println(produktuSaraksts[i]);
				}
				int produkts = ievade.nextInt();
				ievade.nextLine();
				System.out.println("\nJ�su izv�l�tais produkts:  "
						+ produktuSaraksts[produkts - 1].substring(1, produktuSaraksts[produkts - 1].length()));
				getFinal();
				y = 2;

			} catch (Exception e) {
				System.out.println("Neatbilsto�s produkt numurs. L�dzu atk�rtoti ievadiet v�lam� produkta numuru");
			}

		} while (y == 1);

	}

	private static void getDaudzums() {
		System.out.println("\nL�dzu izv�laties nepiecie�amo daudzumu");
		produktaDaudzums = ievade.nextInt();
		ievade.nextLine();
		System.out.println("Daudzums: " + produktaDaudzums + "gb.\n");
		getPiegade();
	}

	private static void getDaudzumsChange() {
		System.out.println("\nL�dzu izv�laties nepiecie�amo daudzumu");
		produktaDaudzums = ievade.nextInt();
		ievade.nextLine();
		System.out.println("Daudzums: " + produktaDaudzums + "gb.\n");
		getFinal();
	}

	private static void getPiegade() {
		System.out.print("Vai Jums b�s nepiecie�ama pieg�de?\nJ� - Nospiediet 1\nN� - Nospiediet 2");
		int piegade = ievade.nextInt();
		ievade.nextLine();
		if (piegade == 1) {
			System.out.println("\nL�dzu nor�diet pieg�des adresi:");
			piegadesAdrese = ievade.nextLine();
			System.out.println("\nJ�su pieg�des adrese ir: " + piegadesAdrese);
		} else {
			System.out.println("Pieg�de nav nepiecie�ama");
		}
		getTel();
	}

	private static void getPiegadeChange() {
		System.out.print("Vai Jums b�s nepiecie�ama pieg�de?\nJ� - Nospiediet 1\nN� - Nospiediet 2");
		int piegade = ievade.nextInt();
		ievade.nextLine();
		if (piegade == 1) {
			System.out.println("\nL�dzu nor�diet pieg�des adresi:");

			piegadesAdrese = ievade.nextLine();
			ievade.nextLine();
			System.out.println("\nJ�su pieg�des adrese ir: " + piegadesAdrese);
		} else {
			System.out.println("Pieg�de nav nepiecie�ama");
		}
		getFinal();
	}

	private static void getTel() {
		System.out.println("L�dzu ievadiet savu kontaktt�lruni");
		kontakttalrunis = ievade.next();
		ievade.nextLine();
		getEpasts();
	}

	private static void getEpasts() {
		System.out.println("L�dzu nor�diet savu epasta adresi");
		epatsaAdrese = ievade.nextLine();
		System.out.println("J�su epasts: " + epatsaAdrese);
		getFinal();
	}

	private static void getEpastsChange() {
		System.out.println("L�dzu nor�diet savu epasta adresi");
		epatsaAdrese = ievade.nextLine();
		System.out.println("J�su epasts: " + epatsaAdrese);
		getFinal();
	}

	private static void getFinal() {

		Random random = new Random();
		long randomInt = random.nextInt(999999);

		System.out.println("\nPaldies, J�su pas�t�jums ir re�istr�ts");
		System.out.println("\nL�dzu p�rbaudiet un apstipriniet pas�t�jumu.");

		System.out.println("Pas�tijums Nr.: " + randomInt);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println("Pas�t�jums veikts: " + df.format(dateobj));

		System.out.println();
		System.out.println("V�rds: " + lietotajaVards);
		System.out.println("Uzv�rds: " + lietotajaUzvards);
		System.out.println("Produkta nosaukums: " + produkts); // neatgrie� nor�d�to produkta nosaukumu??????
		System.out.println("Daudzums: " + produktaDaudzums + " gb.");
		System.out.println("Pieg�des adrese: " + piegadesAdrese);
		System.out.println("Kontaktt�lrunis: " + kontakttalrunis);
		System.out.println("Kontaktt�lrunis: " + epatsaAdrese);
		System.out.println(" ");
		System.out.println(
				"\nApstiprin�t - Nospiediet 1\nIzmain�t pas�t�juma datus - Nospiediet 2\nAtcelt pas�t�jumu - Nospiediet 3");

		byte pasutijumsFinal = ievade.nextByte();
		ievade.nextLine();

		if (pasutijumsFinal == 1) {
			{
				System.out.println(
						"Paldies. J�su pas�t�jums ir pie�emts.\nVai v�laties veikt jaunu pas�t�jumu?\n1 Jauns pas�t�jums\n2 Beigt");
				int jaunsPasutijums = ievade.nextInt();
				ievade.nextInt();
				if (jaunsPasutijums == 1) {
					getProduct();
				}else if (jaunsPasutijums == 2) {
					System.out.println("Paldies par J�su pas�t�jumu");
				}
			}
		} else if (pasutijumsFinal == 3) {
			System.out.println("J�su pas�t�jums ir atcelts.");
			
		}

		else if (pasutijumsFinal == 2) {
			System.out.println(
					"Kuru pas�t�juma sada�u v�laties labot?\n1:V�rds\n2:Uzv�rds\n3:Izv�l�t� prece\n4:Izv�l�t�s preces daudzums\n5:Pieg�des\n6:T�lru�a numurs\n7:Epasts");
			int labojums = ievade.nextInt();
			ievade.nextLine();

			if (labojums == 1) {
				getNameChange();
			} else if (labojums == 2) {
				getSurenameChange();
			} else if (labojums == 3) {
				getProductChange();
			} else if (labojums == 4) {
				getDaudzumsChange();
			} else if (labojums == 5) {
				getPiegadeChange();
			} else if (labojums == 6) {
				getTel();
			} else if (labojums == 7) {
				getEpastsChange();
			}

			else if (labojums < 1) {
				getFinal2();
			} else if (labojums > 6) {
				getFinal2();
			}
		}
	}

	private static void getFinal2() {

		System.out.println("\nNeat�auta darb�ba, l�dzu m�giniet v�lreiz");
		System.out.println("\nAtgriezties pie pas�t�juma apstiprin��anas: Nospiediet 0");
		System.out.println(" ");
		System.out.println(
				"Kuru pas�t�juma sada�u v�laties labot?\n1:V�rds\n2:Uzv�rds\n3:Izv�l�t� prece\n4:Izv�l�t�s preces daudzums\n5:Pieg�de\n6:T�lru�a numurs");

		int labojums = ievade.nextInt();
		ievade.nextLine();

		if (labojums == 1) {
			getNameChange();
		} else if (labojums == 2) {
			getSurenameChange();
		} else if (labojums == 3) {
			getProductChange();
		} else if (labojums == 4) {
			getDaudzumsChange();
		} else if (labojums == 5) {
			getPiegadeChange();
		} else if (labojums == 6) {
			getTel();
		} else if (labojums < 0) {
			getFinal2();
		} else if (labojums > 6) {
			getFinal2();
		} else if (labojums == 0) {
			getFinal();
		} else if (labojums < 0) {
			getFinal2();
		}
	}

	public static void main(String[] args) {
		getUser();
		ievade.nextLine();
	}
}
