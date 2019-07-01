package controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Stack;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class MenuController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5652494721656903879L;
	private DrawingModel model;
	private AppFrame frame;
	
	
	private Stack<Command> undoStack = new Stack<Command>();
	private Stack<Command> redoStack = new Stack<Command>();
	
	private Stack<String> undoLog = new Stack<String>();
	private Stack<String> redoLog = new Stack<String>();
	
	private Logger globalLogger = Logger.getLogger("global");
	
	
	public MenuController(DrawingModel d, AppFrame f) {
		this.model = d;
		this.frame = f;
		updateUndoRedoButtons();
	}
	
	public Logger getGlobalLogger() {
		return this.globalLogger;
	}
	
	public void updateUndoRedoButtons() {
		if(this.undoStack.size() == 0) frame.getMenuView().getBtnUndo().setEnabled(false);
		else frame.getMenuView().getBtnUndo().setEnabled(true);
		
		if(this.redoStack.size() == 0) frame.getMenuView().getBtnRedo().setEnabled(false);
		else frame.getMenuView().getBtnRedo().setEnabled(true);
	}
	
	public void addUndo(Command cmd,String text) {
		undoStack.push(cmd);
		redoStack.clear();
		undoLog.push(text);
		redoLog.clear();
		updateUndoRedoButtons();
	}
	
	public void executeUndo() {
		Command cm = undoStack.pop();
		cm.unexecute();
		redoStack.push(cm);
		globalLogger.info(undoLog.peek().replace("_execute_", "_unexecute_"));
		redoLog.push(undoLog.pop());
		updateUndoRedoButtons();
		frame.getDrawingPanelView().repaint();
	}
	
	public void executeRedo() {
		Command cm = redoStack.pop();
		cm.execute();
		undoStack.push(cm);
		globalLogger.info(redoLog.peek().replace("_unexecute_", "_execute_"));
		undoLog.push(redoLog.pop());
		updateUndoRedoButtons();
		frame.getDrawingPanelView().repaint();
	}
	
	public void LogCommand(Command cmd,boolean state,Shape firstShape,Shape secondShape) {
		String newLog = toLog(cmd, state, firstShape, secondShape);
		globalLogger.info(newLog);
	}
	
	public String toLog(Command cmd, boolean state, Shape firstShape, Shape secondShape) {
		StringBuilder stringBuilder = new StringBuilder();
		String s;
		if(state == true) s = "execute";
		else s = "unexecute";
		String scmd;
		if(secondShape == null) {
			scmd = firstShape.toString();
		} else {
			scmd = firstShape.toString() + "_to_" + secondShape.toString();
		}
		stringBuilder.append(cmd.getClass().getSimpleName());
		stringBuilder.append("_");
		stringBuilder.append(s);
		stringBuilder.append("_");
		stringBuilder.append(scmd);
		return stringBuilder.toString();
	}
	
	public void openFile(ActionEvent e) {
		
	}

	public void saveFile(ActionEvent e) {
		
	}
	
	public void newFile(ActionEvent e) {
		
	}
	
	
	
	
	public void clearUndo() {
		undoStack.clear();
	}

	public Stack<Command> getUndoStack() {
		return undoStack;
	}

	public void setUndoStack(Stack<Command> undoStack) {
		this.undoStack = undoStack;
	}

	public Stack<Command> getRedoStack() {
		return redoStack;
	}

	public void setRedoStack(Stack<Command> redoStack) {
		this.redoStack = redoStack;
	}

	public Stack<String> getUndoLog() {
		return undoLog;
	}

	public void setUndoLog(Stack<String> undoLog) {
		this.undoLog = undoLog;
	}

	public Stack<String> getRedoLog() {
		return redoLog;
	}

	public void setRedoLog(Stack<String> redoLog) {
		this.redoLog = redoLog;
	}
	
	
	
}
