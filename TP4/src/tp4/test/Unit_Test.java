package tp4.test;

import tp4.model.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;


public class Unit_Test {

	@Test
	public void test_client() {
		 Client clientDo = new Client("Dodorina", "PayPal", "0605663565", "Beau", null);
	}
	
	@Test
	public void test_passager() {
		Passager p1 = new Passager("Dorian", "0605663565");
	}
	
	@Test
	public void test_vol() {
		Vol v1 = new Vol("V001",null, null);
	}
	
	@Test
	public void test_reservation() {
		Client clientDo = new Client("Dodorina", "PayPal", "0605663565", "Beau", null);
		Passager p1 = new Passager("Dorian", "0605663565");
		Passager p2 = new Passager("Max", "0605213506");
		Vol v1 = new Vol("V001",null, null);
		v1.ouvrir();
		ArrayList<Passager> lp = new ArrayList<Passager>();
		lp.add(p1);
		Reservation r1 = new Reservation("R001", v1, lp, clientDo);
	}
}
