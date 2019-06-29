package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame.AppFrame;
import model.DrawingModel;

public class ToolsController {
	
	private DrawingModel model;
	private AppFrame frame;
	private int selection = 0;
	
	public ToolsController(DrawingModel d, AppFrame f) {
		this.frame = f;
		this.model = d;
	}
	
	public void pointSelected(ActionEvent e) {
		if(selection != 1) selection = 1;
		else selection = 0;
		highlightSelectedButton();
	}
	public void lineSelected(ActionEvent e) {
		if(selection != 2) selection = 2;
		else selection = 0;
		highlightSelectedButton();
	}
	public void squareSelected(ActionEvent e) {
		if(selection != 3) selection = 3;
		else selection = 0;
		highlightSelectedButton();
	}
	public void rectangleSelected(ActionEvent e) {
		if(selection != 4) selection = 4;
		else selection = 0;
		highlightSelectedButton();
	}
	public void circleSelected(ActionEvent e) {
		if(selection != 5) selection = 5;
		else selection = 0;
		highlightSelectedButton();
	}
	public void hexagonSelected(ActionEvent e) {
		if(selection != 6) selection = 6;
		else selection = 0;
		highlightSelectedButton();
	}
	public void selectSelected(ActionEvent e) {
		if(selection != 7) selection = 7;
		else selection = 0;
		highlightSelectedButton();
	}
	
	public int getSelection() {
		return selection;
	}
	
	public void highlightSelectedButton() {
		frame.getToolsSelectionView().getBtnPoint().setBackground(null);
		frame.getToolsSelectionView().getBtnLine().setBackground(null);
		frame.getToolsSelectionView().getBtnSquare().setBackground(null);
		frame.getToolsSelectionView().getBtnRectangle().setBackground(null);
		frame.getToolsSelectionView().getBtnCircle().setBackground(null);
		frame.getToolsSelectionView().getBtnHexagon().setBackground(null);
		frame.getToolsSelectionView().getBtnSelect().setBackground(null);
		if(selection == 1) frame.getToolsSelectionView().getBtnPoint().setBackground(Color.GRAY);
		if(selection == 2) frame.getToolsSelectionView().getBtnLine().setBackground(Color.GRAY);
		if(selection == 3) frame.getToolsSelectionView().getBtnSquare().setBackground(Color.GRAY);
		if(selection == 4) frame.getToolsSelectionView().getBtnRectangle().setBackground(Color.GRAY);
		if(selection == 5) frame.getToolsSelectionView().getBtnCircle().setBackground(Color.GRAY);
		if(selection == 6) frame.getToolsSelectionView().getBtnHexagon().setBackground(Color.GRAY);
		if(selection == 7) frame.getToolsSelectionView().getBtnSelect().setBackground(Color.GRAY);
	}
	
	
	
	

}
