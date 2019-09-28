package PatstavigaisDarbs_RTU_Java;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

	static Scanner ievade = new Scanner(System.in);

	static String 	lietotajaVards;
	static String 	lietotajaUzvards;
	static String 	produkts;
	static int 		produktaDaudzums;
	static int 		piegades;
	static String 	piegadesAdrese;
	static String 	kontakttalrunis;
	static String 	epatsaAdrese;
	
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/pasutijumidb";
		String user = "root";
		String password = "password";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		System.out.println("Connection made");

		System.out.println("Lûdzu norâdiet savu vârdu");
		lietotajaVards = ievade.nextLine();
		
		System.out.println("Lûdzu norâdiet savu uzvârdu");
		lietotajaUzvards = ievade.nextLine();
		
		System.out.println("Lûdzu izvçlieties produktu.\n1: BURGER\n2: PICA\n3: PASTA\n4: BEER");
		produkts = ievade.nextLine();
		
		System.out.println("\nLûdzu izvçlaties nepiecieðamo daudzumu");
		produktaDaudzums = ievade.nextInt();

		System.out.print("Vai Jums bûs nepiecieðama piegâde?\nJâ - Nospiediet 1\nNç - Nospiediet 2");
		int delivery = ievade.nextInt();
		ievade.nextLine();
		if (delivery == 1);
		{
			piegades = 1;
		}
		if (delivery == 2);
		{
			piegades = 2;
		}

		System.out.println("\nLûdzu norâdiet piegâdes adresi:");
		piegadesAdrese = ievade.nextLine();

		System.out.println("Lûdzu ievadiet savu kontakttâlruni");
		kontakttalrunis = ievade.nextLine();
		
		System.out.println("Lûdzu norâdiet savu epasta adresi");
		epatsaAdrese = ievade.nextLine();

		int pasutijumaid = 0;
		String vards = lietotajaVards;
		String uzvards = lietotajaUzvards;
		String produkta_nosaukums = produkts;
		int daudzums = produktaDaudzums;
		int piegade = piegades;
		String piegades_adrese = piegadesAdrese;
		String telefons = kontakttalrunis;
		String epasts = epatsaAdrese;

		String query = "insert into pasutijumi value (?,?,?,?,?,?,?,?,?);";
		PreparedStatement st = con.prepareStatement(query);

		st.setInt(1, pasutijumaid);
		st.setString(2, vards);
		st.setString(3, uzvards);
		st.setString(4, produkta_nosaukums);
		st.setInt(5, daudzums);
		st.setInt(6, piegade);
		st.setString(7, piegades_adrese);
		st.setString(8, telefons);
		st.setString(9, epasts);

		con.close();
		System.out.println("Connection closed!"); // Parbaude - savienojums aizverts

	}
}