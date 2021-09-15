package view;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import global.Constants.EDataFileName;
import global.Constants.EDirectoryPanel;
import valueObject.VCDirectory;

class DirectoryPanel extends JPanel {
	private static final long serialVersionUID = EDirectoryPanel.serialVersionUID.getInt();//상수
	//instance variable - 
	private DirectoryList directoryList1;
	private DirectoryList directoryList2;
	private DirectoryList directoryList3;
	
	public DirectoryPanel(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollpane;//temporary
		
		scrollpane = new JScrollPane();			
		this.directoryList1 = new DirectoryList();
		this.directoryList1.addListSelectionListener(listSelectionHandler);//valueChanged 호출됨//자식간 연결
		scrollpane.setViewportView(this.directoryList1);
		this.add(scrollpane);//스크롤페인이 리스트 싸고 있음
		
		scrollpane = new JScrollPane();
		this.directoryList2 = new DirectoryList();
		this.directoryList2.addListSelectionListener(listSelectionHandler);
		scrollpane.setViewportView(this.directoryList2);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.directoryList3 = new DirectoryList();
		this.directoryList3.addListSelectionListener(listSelectionHandler);
		scrollpane.setViewportView(this.directoryList3);
		this.add(scrollpane);
	}
	
	public void initialize(String id) {
		this.refresh(null);//다 만든 다음에 refresh>뻑 없어짐//refresh:데이터를 초기화하는 것
		
		this.directoryList1.initialize(id);//아이디를 줘서 용인인지 서울인지 디폴트
		this.directoryList2.initialize(id);
		this.directoryList3.initialize(id);
	}
	
	public String refresh(Object source) {//오브젝트가 어디서 왔는지
		String fileName = null;
		if (source == null) {
			this.directoryList1.refresh(EDataFileName.root.getString());
		} else if (source.equals(this.directoryList1)) {
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);//이 파일네임 가지고 그려라(디스플레이 해라)
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList2)) {
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList3)) {
			fileName = this.directoryList3.getSelectedFile();
		}
		return fileName;//lecture로 넘김
	}
	
	private class DirectoryList extends JList<String> {
		private static final long serialVersionUID = 1L;
		
		private CDirectory cDirectory;
		private Vector<VCDirectory> vCDirectories;
		private Vector<String> listData;
		
		public DirectoryList() {
			this.listData = new Vector<String>();
			this.setListData(this.listData);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			this.cDirectory = new CDirectory();//한 번 만들면 계속 쓸 수 있음
		}
				
		public void initialize(String id) {
		}

		public String getSelectedFile() {
			String fileName = this.vCDirectories.get(this.getSelectedIndex()).getFileName();
			return fileName;
		}

		public void refresh(String fileName) {
			if (fileName == null) 
				return;
			
			this.vCDirectories = cDirectory.getData(fileName);
			this.listData.clear();//기존 꺼를 없애고 붙임
			for (VCDirectory vCDirectory: vCDirectories) {
				this.listData.add(vCDirectory.getText());
			}
			this.setSelectedIndex(0);//0번째로 selection함
			this.updateUI();//그림을 새로 그려라
		}
	}
}