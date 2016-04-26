package txtEditor;

import static org.junit.Assert.fail;

import javax.swing.JTextArea;

import org.junit.Test;

import events.NoFileToReadException;
import events.ReadFile; 

public class ReadFileMockTest {
	/**
	 * TODO 4: Przetestuj metode ReadFile.fileInArea(JTextArea, String). Sprawdz,
	 * czy zwraca ona wyjatek zaleznie od danych wejsciowych. Mozesz uzyc mockow lub danych przygotowanych.
	 */

	@Test(expected=NoFileToReadException.class)
    public void readFileTestSucces() throws NoFileToReadException {
		ReadFile readFile = new ReadFile();
		String path = "wrongFileName.txt";
		
		readFile.fileInArea(new JTextArea(), path);
    }
	
	@Test
    public void readFileTestFailed() {
		ReadFile readFile = new ReadFile();
		String path = "exisitngTestFile";	
		JTextArea area = new JTextArea();
		
		try {
			readFile.fileInArea(area, path);
		} catch (NoFileToReadException e) {
			fail();
		}
    }


	/*
	 * TODO 5: Przetestuj metode actionPerformed w klasie ReadFile.
	 * Chcemy sprawic, by PathPanel.sayFileOpened() nie zostalo wywolane.
	 * Utworz mock obiektu ActionEvent i wywolaj metode actionPerformed.
	 * Zamockuj tez odpowiednio TextField.getText(), tak by if w metodzie actionPerformed zwrocil true.
	 * Nie zapomnij o mocku dla metody areaInFile tak, by metoda zwrocila wyjatek.
	 */
}
