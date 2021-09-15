package view;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

class LecturePanel extends JPanel{
	private static final long serialVersionUID = ELecturePanel.serialVersionUID.getInt();
	//control
	private CLecture cLecture;
	private Vector<VCLecture> vCLectures;
	//lectureList
	private LectureList lectureList;

	public LecturePanel() {//���⼭ model���� ����
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.lectureList = new LectureList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.lectureList);
		this.add(scrollPane);
	}
	
	public void initialize(String ID) {
		// TODO Auto-generated method stub
	}

	public void refresh(String fileName) throws FileNotFoundException {
		//control ���⼭
		this.cLecture = new CLecture();
		this.vCLectures = cLecture.getData(fileName);//���� �޾ƿ�
	
		this.lectureList.addRows(this.vCLectures);//�߰����Ѷ�
	}
	
	public Vector<VCLecture> getSelectedLectures() {
		return this.lectureList.getSelectedLectures();
	}

	
	private class LectureList extends JTable {//��ƼĮ�� ����Ʈ
		private static final long serialVersionUID = 1L;
		private DefaultTableModel tableModel;
		
		public LectureList() {
			Vector<String> header = new Vector<String>();//String ����(array)
			for (int i = 1 ; i < ELecturePanel.values().length; i++) {//serialVersionUID���� �ϳ��� �����Ͷ�
				header.add(ELecturePanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
		}

		public void addRows(Vector<VCLecture> vCLectures) {
			this.tableModel.setRowCount(0);//���ϸ� ����Ʈ�� ��� ����	
			Vector<String> rowData;
			for (VCLecture vCLecture : vCLectures) {
				rowData = new Vector<String>();
				rowData.addElement(vCLecture.getId());
				rowData.addElement(vCLecture.getName());
				rowData.addElement(vCLecture.getProfessorName());
				rowData.addElement(vCLecture.getCredit());
				rowData.addElement(vCLecture.getTime());
				this.tableModel.addRow(rowData);
			}
			this.getSelectionModel().addSelectionInterval(0,0);//0��° row�� ����
		}
		
		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> selectedLectures = new Vector<VCLecture>();//selectedLectures : ��ư� �׸�
			for (int i = 0 ; i < this.getRowCount() ; i++) {
				if (this.isRowSelected(i)) {//�������� �Ƴ� �ȵƳ�
					selectedLectures.addElement(vCLectures.get(i));//i��° index -> selectedLectures�� ����
				}
			}
			return selectedLectures; 
		}
	}
}