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

	public LecturePanel() {//여기서 model까지 만듦
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
		//control 여기서
		this.cLecture = new CLecture();
		this.vCLectures = cLecture.getData(fileName);//렉쳐 받아옴
	
		this.lectureList.addRows(this.vCLectures);//추가시켜라
	}
	
	public Vector<VCLecture> getSelectedLectures() {
		return this.lectureList.getSelectedLectures();
	}

	
	private class LectureList extends JTable {//멀티칼럼 리스트
		private static final long serialVersionUID = 1L;
		private DefaultTableModel tableModel;
		
		public LectureList() {
			Vector<String> header = new Vector<String>();//String 벡터(array)
			for (int i = 1 ; i < ELecturePanel.values().length; i++) {//serialVersionUID빼고 하나씩 가져와라
				header.add(ELecturePanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
		}

		public void addRows(Vector<VCLecture> vCLectures) {
			this.tableModel.setRowCount(0);//안하면 리스트가 계속 쌓임	
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
			this.getSelectionModel().addSelectionInterval(0,0);//0번째 row를 세팅
		}
		
		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> selectedLectures = new Vector<VCLecture>();//selectedLectures : 담아갈 그릇
			for (int i = 0 ; i < this.getRowCount() ; i++) {
				if (this.isRowSelected(i)) {//셀렉션이 됐나 안됐나
					selectedLectures.addElement(vCLectures.get(i));//i번째 index -> selectedLectures에 담음
				}
			}
			return selectedLectures; 
		}
	}
}