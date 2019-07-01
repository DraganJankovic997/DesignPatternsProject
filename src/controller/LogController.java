package controller;

import java.io.Serializable;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import frame.AppFrame;
import model.DrawingModel;

public class LogController extends Handler {

	private AppFrame frame;
	
	public LogController(DrawingModel d, AppFrame f) {
		this.frame = f;
	}
	
	



	@Override
	public void publish(LogRecord record) {
		String mess = record.getMessage();
		System.out.println(mess);
		String oldLog = frame.getLogView().getTextPane().getText();
		frame.getLogView().getTextPane().setText(oldLog + mess +"\n");
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void close() throws SecurityException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
