package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import frame.AppFrame;
import log.ToCommand;
import model.DrawingModel;
import shapes.Command;
import view.LogInput;

public class LogFileLoader implements AssetLoader {

	
	private DrawingModel model;
	private AppFrame frame;
	
	public LogFileLoader(DrawingModel d, AppFrame f) {
		this.model = d;
		this.frame = f;
	}
	
	
	@Override
	public void loadFile(File file) {
		File f = file;
		if(f.getName().split("\\.")[1].equals("log")) {
			try {
				BufferedReader b = new BufferedReader(new FileReader(f));
				LogInput l = new LogInput();
				String line;
				String finalLog = "";
				String insertLog = "";
				while((line = b.readLine()) != null) {
					insertLog = insertLog + line + "\n";
					l.getTextPane().setText(insertLog);
					l.setInsert(false);
					l.setModal(true);
					l.setVisible(true);
					if(l.getInsert() == true) {
						finalLog = finalLog + line + "\n";
						String ex = line.split("_")[1];
						if(ex.equals("execute")) {
							ToCommand ic = new ToCommand(model, frame);
							try {
								Command c = ic.transform(line);
								c.execute();
								frame.getMenuController().addUndo(c, line);
							} catch(Exception exc) {
								System.out.println(exc);
							}
						}
						else if (ex.equals("unexecute")) {
							frame.getMenuController().executeUndo();
						}
						frame.getDrawingPanelView().repaint();
						l.setInsert(false);
					}
					frame.getLogView().getTextPane().setText(finalLog);
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void saveFile(File file) {
		try {
			FileWriter fw = new FileWriter(file+".log");
			fw.write(frame.getLogView().getTextPane().getText());
			fw.close();
            JOptionPane.showMessageDialog(null, "The file was saved.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error while writing.");
		}
	}

}









