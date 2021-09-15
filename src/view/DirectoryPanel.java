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
	private static final long serialVersionUID = EDirectoryPanel.serialVersionUID.getInt();//���
	//instance variable - 
	private DirectoryList directoryList1;
	private DirectoryList directoryList2;
	private DirectoryList directoryList3;
	
	public DirectoryPanel(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollpane;//temporary
		
		scrollpane = new JScrollPane();			
		this.directoryList1 = new DirectoryList();
		this.directoryList1.addListSelectionListener(listSelectionHandler);//valueChanged ȣ���//�ڽİ� ����
		scrollpane.setViewportView(this.directoryList1);
		this.add(scrollpane);//��ũ�������� ����Ʈ �ΰ� ����
		
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
		this.refresh(null);//�� ���� ������ refresh>�� ������//refresh:�����͸� �ʱ�ȭ�ϴ� ��
		
		this.directoryList1.initialize(id);//���̵� �༭ �������� �������� ����Ʈ
		this.directoryList2.initialize(id);
		this.directoryList3.initialize(id);
	}
	
	public String refresh(Object source) {//������Ʈ�� ��� �Դ���
		String fileName = null;
		if (source == null) {
			this.directoryList1.refresh(EDataFileName.root.getString());
		} else if (source.equals(this.directoryList1)) {
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);//�� ���ϳ��� ������ �׷���(���÷��� �ض�)
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
		return fileName;//lecture�� �ѱ�
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
			
			this.cDirectory = new CDirectory();//�� �� ����� ��� �� �� ����
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
			this.listData.clear();//���� ���� ���ְ� ����
			for (VCDirectory vCDirectory: vCDirectories) {
				this.listData.add(vCDirectory.getText());
			}
			this.setSelectedIndex(0);//0��°�� selection��
			this.updateUI();//�׸��� ���� �׷���
		}
	}
}