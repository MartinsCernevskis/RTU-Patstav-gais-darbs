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
			"3 Pusdienu komplekts LATVIA", "4 Pusdienu komplekts PÂRSTEIGUMS" };
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
				"Labdien.\nLûdzu norâdiet darbîbu.\nAdministrators - nospiediet 1\nVeikt pasûtîjumu - nospiediet 2");
		lietotajaStatus = ievade.nextInt();
		ievade.nextLine();

		if (lietotajaStatus == 1) {
			getAdmin();
		} else
			getName();
	}

	private static void getAdmin() {

//		Scanner ievade = new Scanner(new File("C:\\Users\\User\\Martins\\RTU Java\\dati.txt"));

		System.out.println("LIETOTÂJVÂRDS: ");
		adminName = ievade.nextLine();

		System.out.println("PAROLE: ");
		adminPass = ievade.nextLine();

//		if (adminName.equals(admin) && adminPass.equals(1234)) {
//			System.out.print("Pieslegðanâs veiksmîga");
//		} else {
//		System.out.print("Nepareizs lietotajvârds vai parole");
//		getAdmin();
//			}

		System.out.println("1 Meklçt pasûtîjumu pçc pasûtîjuma ID\nIevadiet pasûtîjuma ID: ");
		System.out.println("2 apskatît visus pasûtîjumus ");
		pasutijumaID = ievade.nextLine();
		getUser();


	}

	private static void getName() {
		System.out.println("Lûdzu norâdiet savu vârdu");
		lietotajaVards = ievade.nextLine();
		getSurename();
		ievade.nextLine();
	}

	private static void getNameChange() {
		System.out.println("Lûdzu norâdiet savu vârdu");
		lietotajaVards = ievade.nextLine();
		getFinal();
	}

	private static void getSurename() {
		System.out.println("Lûdzu norâdiet savu uzvârdu");
		lietotajaUzvards = ievade.nextLine();
		System.out.println("Sveicinâti, " + lietotajaVards + " " + lietotajaUzvards + ".\n");
		getProduct();
	}

	private static void getSurenameChange() {
		System.out.println("Lûdzu norâdiet savu uzvârdu");
		lietotajaUzvards = ievade.nextLine();
		System.out.println("Paldies, Jûsus uzvârds nomainîts uz: " + lietotajaUzvards + ".\n");
		getFinal();
	}

	private static void getProduct() {

		int y = 1;

		do {
			try {
				System.out.println("Lûdzu izvçlaties produktu");
				for (int i = 0; i < produktuSaraksts.length; i++) {
					System.out.println(produktuSaraksts[i]);
				}
				int produkts = ievade.nextInt();
				ievade.nextLine();

				System.out.println("\nJûsu izvçlçtais produkts:  "
						+ produktuSaraksts[produkts - 1].substring(2, produktuSaraksts[produkts - 1].length()));
				getDaudzums();
				y = 2;

			} catch (Exception e) {
				System.out.println("Neatbilstoðs produkta kods. Lûdzu atkârtoti ievadiet vçlamâ produkta kodu");
			}

		} while (y == 1);

	}

	private static void getProductChange() {

		int y = 1;

		do {
			try {
				System.out.println("Lûdzu izvçlaties produktu");
				for (int i = 0; i < produktuSaraksts.length; i++) {
					System.out.println(produktuSaraksts[i]);
				}
				int produkts = ievade.nextInt();
				ievade.nextLine();
				System.out.println("\nJûsu izvçlçtais produkts:  "
						+ produktuSaraksts[produkts - 1].substring(1, produktuSaraksts[produkts - 1].length()));
				getFinal();
				y = 2;

			} catch (Exception e) {
				System.out.println("Neatbilstoðs produkt numurs. Lûdzu atkârtoti ievadiet vçlamâ produkta numuru");
			}

		} while (y == 1);

	}

	private static void getDaudzums() {
		System.out.println("\nLûdzu izvçlaties nepiecieðamo daudzumu");
		produktaDaudzums = ievade.nextInt();
		ievade.nextLine();
		System.out.println("Daudzums: " + produktaDaudzums + "gb.\n");
		getPiegade();
	}

	private static void getDaudzumsChange() {
		System.out.println("\nLûdzu izvçlaties nepiecieðamo daudzumu");
		produktaDaudzums = ievade.nextInt();
		ievade.nextLine();
		System.out.println("Daudzums: " + produktaDaudzums + "gb.\n");
		getFinal();
	}

	private static void getPiegade() {
		System.out.print("Vai Jums bûs nepiecieðama piegâde?\nJâ - Nospiediet 1\nNç - Nospiediet 2");
		int piegade = ievade.nextInt();
		ievade.nextLine();
		if (piegade == 1) {
			System.out.println("\nLûdzu norâdiet piegâdes adresi:");
			piegadesAdrese = ievade.nextLine();
			System.out.println("\nJûsu piegâdes adrese ir: " + piegadesAdrese);
		} else {
			System.out.println("Piegâde nav nepiecieðama");
		}
		getTel();
	}

	private static void getPiegadeChange() {
		System.out.print("Vai Jums bûs nepiecieðama piegâde?\nJâ - Nospiediet 1\nNç - Nospiediet 2");
		int piegade = ievade.nextInt();
		ievade.nextLine();
		if (piegade == 1) {
			System.out.println("\nLûdzu norâdiet piegâdes adresi:");

			piegadesAdrese = ievade.nextLine();
			ievade.nextLine();
			System.out.println("\nJûsu piegâdes adrese ir: " + piegadesAdrese);
		} else {
			System.out.println("Piegâde nav nepiecieðama");
		}
		getFinal();
	}

	private static void getTel() {
		System.out.println("Lûdzu ievadiet savu kontakttâlruni");
		kontakttalrunis = ievade.next();
		ievade.nextLine();
		getEpasts();
	}

	private static void getEpasts() {
		System.out.println("Lûdzu norâdiet savu epasta adresi");
		epatsaAdrese = ievade.nextLine();
		System.out.println("Jûsu epasts: " + epatsaAdrese);
		getFinal();
	}

	private static void getEpastsChange() {
		System.out.println("Lûdzu norâdiet savu epasta adresi");
		epatsaAdrese = ievade.nextLine();
		System.out.println("Jûsu epasts: " + epatsaAdrese);
		getFinal();
	}

	private static void getFinal() {

		Random random = new Random();
		long randomInt = random.nextInt(999999);

		System.out.println("\nPaldies, Jûsu pasûtîjums ir reìistrçts");
		System.out.println("\nLûdzu pârbaudiet un apstipriniet pasûtîjumu.");

		System.out.println("Pasûtijums Nr.: " + randomInt);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println("Pasûtîjums veikts: " + df.format(dateobj));

		System.out.println();
		System.out.println("Vârds: " + lietotajaVards);
		System.out.println("Uzvârds: " + lietotajaUzvards);
		System.out.println("Produkta nosaukums: " + produkts); // neatgrieþ norâdîto produkta nosaukumu??????
		System.out.println("Daudzums: " + produktaDaudzums + " gb.");
		System.out.println("Piegâdes adrese: " + piegadesAdrese);
		System.out.println("Kontakttâlrunis: " + kontakttalrunis);
		System.out.println("Kontakttâlrunis: " + epatsaAdrese);
		System.out.println(" ");
		System.out.println(
				"\nApstiprinât - Nospiediet 1\nIzmainît pasûtîjuma datus - Nospiediet 2\nAtcelt pasûtîjumu - Nospiediet 3");

		byte pasutijumsFinal = ievade.nextByte();
		ievade.nextLine();

		if (pasutijumsFinal == 1) {
			{
				System.out.println(
						"Paldies. Jûsu pasûtîjums ir pieòemts.\nVai vçlaties veikt jaunu pasûtîjumu?\n1 Jauns pasûtîjums\n2 Beigt");
				int jaunsPasutijums = ievade.nextInt();
				ievade.nextInt();
				if (jaunsPasutijums == 1) {
					getProduct();
				}else if (jaunsPasutijums == 2) {
					System.out.println("Paldies par Jûsu pasûtîjumu");
				}
			}
		} else if (pasutijumsFinal == 3) {
			System.out.println("Jûsu pasûtîjums ir atcelts.");
			
		}

		else if (pasutijumsFinal == 2) {
			System.out.println(
					"Kuru pasûtîjuma sadaïu vçlaties labot?\n1:Vârds\n2:Uzvârds\n3:Izvçlçtâ prece\n4:Izvçlçtâs preces daudzums\n5:Piegâdes\n6:Tâlruòa numurs\n7:Epasts");
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

		System.out.println("\nNeatïauta darbîba, lûdzu mçginiet vçlreiz");
		System.out.println("\nAtgriezties pie pasûtîjuma apstiprinâðanas: Nospiediet 0");
		System.out.println(" ");
		System.out.println(
				"Kuru pasûtîjuma sadaïu vçlaties labot?\n1:Vârds\n2:Uzvârds\n3:Izvçlçtâ prece\n4:Izvçlçtâs preces daudzums\n5:Piegâde\n6:Tâlruòa numurs");

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
