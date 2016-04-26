package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import handlingExceptions.ExceptionFrame;
import main.MainFrame;
import panels.PathPanel;

public class WriteFile implements ActionListener {

	private JTextArea area;
	private static final Logger log4j = LogManager.getLogger(WriteFile.class.getName());

	public void actionPerformed(ActionEvent e) {

		area = MainFrame.mainPanel.textAreaPanel.textArea;
		String path = MainFrame.mainPanel.namePanel.textField.getText();

		if (!path.equals("") && new File(path).isFile()) {
			areaInFile(area, path);
			PathPanel.sayFileSaved();
		} else {
			JFileChooser fileopen = new JFileChooser();
			int ret = fileopen.showDialog(null, "Save in file");
			if (ret == JFileChooser.APPROVE_OPTION) {

				path = fileopen.getSelectedFile().getAbsolutePath();
				areaInFile(area, path);

				MainFrame.mainPanel.namePanel.textField.setText(path);
				PathPanel.sayFileSaved();
			}
		}
	}

	private void areaInFile(JTextArea area, String path){
		/*
		 * TODO 1: Obsluz pojawiajacy sie tutaj wyjatek. Wyswietl blad:
		 * a) wersja trudniejsza: utworz popup/wypisz blad jako label w oknie
		 * b) wersja latwiejsza: wyswietl blad w konsoli
		 */
			FileWriter writer;
			BufferedWriter bw;
			
				try {
					writer = new FileWriter(path);
					bw = new BufferedWriter(writer);
					area.write(bw);
					bw.close();
				} catch (IOException e) {
					ExceptionFrame exceptionFrameReadFile = new ExceptionFrame("File cannot be saved!");
					log4j.warn("Cannot write to the file!");
				}	
	}
}
