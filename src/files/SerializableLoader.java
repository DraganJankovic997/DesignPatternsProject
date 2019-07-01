package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Shape;

public class SerializableLoader implements AssetLoader {

	private DrawingModel model;
	private AppFrame frame;
	
	public SerializableLoader(DrawingModel d, AppFrame f) {
		this.model = d;
		this.frame = f;
	}
	
	@Override
	public void loadFile(File file) {
		try {
			FileInputStream files = new FileInputStream(file); 
	        ObjectInputStream in = new ObjectInputStream(files); 
			@SuppressWarnings("unchecked")
			ArrayList<Shape> shapes=(ArrayList<Shape>)in.readObject();
			for(Shape s : shapes) model.addShape(s);
			in.close(); 
	        files.close(); 
		} catch (Exception ex) {
			System.out.println("SerializableLoader fail");
		}

	}

	@Override
	public void saveFile(File file) {
		try {
			 FileOutputStream files = new FileOutputStream(file+".ser"); 
	         ObjectOutputStream out = new ObjectOutputStream(files); 
	           
	         out.writeObject(model.getShapes()); 
	         
	         out.close(); 
	         files.close(); 
	           
	         System.out.println("Object has been serialized");
			}catch(Exception e) {
				 System.out.println("Objects are not serialized");
			}
	}

}
