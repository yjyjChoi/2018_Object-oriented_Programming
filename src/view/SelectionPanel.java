package view;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import global.Constants.ESelectionPanel;
import valueObject.VCLecture;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = ESelectionPanel.serialVersionUID.getInt();
	
	private DirectoryPanel directoryPanel;
	private LecturePanel lecturePanel;
	
	public SelectionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ListSelectionListener listSelectionHandler = new ListSelectionHandler();
		
		this.directoryPanel = new DirectoryPanel(listSelectionHandler);
		this.add(this.directoryPanel);
		
		this.lecturePanel = new LecturePanel();
		this.add(this.lecturePanel);
	}
	
	public void initialize(String id) {
		this.directoryPanel.initialize(id);
		this.lecturePanel.initialize(id);
	}
	
	public void finish(String id) {
		// TODO Auto-generated method stub
		
	}
	
	public Vector<VCLecture> getSelectedLectures() {
		return this.lecturePanel.getSelectedLectures();
	}
	
	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String fileName = directoryPanel.refresh(e.getSource());//뭔가 바뀌면 디렉토리패널한테 바꾸라고 말함
			try {
				lecturePanel.refresh(fileName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}
