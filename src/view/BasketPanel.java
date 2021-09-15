package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EBasketPanel;
import valueObject.VCLecture;

public class BasketPanel extends JPanel{
	private static final long serialVersionUID = EBasketPanel.serialVersionUID.getInt();
	//control
	private CLecture cLecture;
	//model
	private Vector<VCLecture> vCLectures;
	private BasketList basketList;

	public BasketPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.cLecture = new CLecture();
		this.vCLectures = new Vector<VCLecture>();//Lecture array 전달해줄 그릇
		this.basketList = new BasketList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.basketList);
		this.add(scrollPane);
	}

	public void initialize(String fileName) throws FileNotFoundException {//여기서 읽어와서 vCLectures에 채워넣음
		this.basketList.showLectures(fileName);
	}

	public void finish(String fileName) {//파일을 여기서 저장.피니시에 파일 이름 들어옴
		try {
			this.cLecture.setData(fileName, this.vCLectures);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addRows(Vector<VCLecture> vCRemovedLectures) {
		this.basketList.addRows(vCRemovedLectures);
	}
	
	public void removeSelectedLectures() {
		this.basketList.removeSelectedLectures();
	}

	public Vector<VCLecture> getSelectedLectures() {
		return this.basketList.getSelectedLectures();
	}	
	
	public void removeAllLectures() {//전체 삭제 버튼 눌릴 경우
		this.basketList.removeAllLectures();
	}
	
	
	private class BasketList extends JTable {
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		
		public BasketList() {
			Vector<String> header = new Vector<String>();//String 벡터(array)
			for (int i = 1 ; i < EBasketPanel.values().length; i++) {//하나씩 가져와라
				header.add(EBasketPanel.values()[i].getString());
			}
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
		}

		public void showLectures(String fileName) throws FileNotFoundException {
			this.tableModel.setRowCount(0);
			if (fileName == null) {
				return;
			}
			vCLectures = cLecture.getData(fileName);
			Vector<String> rowData = null;
			for (VCLecture vCLecture: vCLectures) {
				rowData = new Vector<String>();
				rowData.addElement(vCLecture.getName());
				rowData.addElement(vCLecture.getProfessorName());
				this.tableModel.addRow(rowData);
			}
			this.updateUI();
		}
		

		public void addRows(Vector<VCLecture> vCRemovedLectures) {
			Vector<String> rowData;//테이블에 집어넣을 데이터를 담을 그릇//테이블 한 줄은 String Vector
			for (VCLecture vCLecture : vCRemovedLectures) {
				rowData = new Vector<String>();
				rowData.addElement(vCLecture.getName());
				this.tableModel.addRow(rowData);
				vCLectures.add(vCLecture);
			}
			this.getSelectionModel().addSelectionInterval(0,0);	
		}

		public Vector<VCLecture> getSelectedLectures() {//removeSelectedLectures()랑 똑같이 생김
			Vector<VCLecture> vCRemovedLectures = new Vector<VCLecture>();//삭제된 걸 담을 그릇
			for (int i = this.tableModel.getRowCount() -1; i>=0; i--) {//0에서부터 시작
				if (this.isRowSelected(i)) {
					this.tableModel.removeRow(i);//리스트에서 빼고
					vCRemovedLectures.add(vCLectures.get(i));
					vCLectures.remove(i);//vCLectures에서 빼고
				}
			}
			//this.getSelectionModel().addSelectionInterval(0,0);	
			return vCRemovedLectures;
		}

		public void removeSelectedLectures() {
			for (int i = this.tableModel.getRowCount() -1; i>=0; i--) {//0에서부터 시작
				if (this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCLectures.remove(i);
				}
			}
			//this.getSelectionModel().addSelectionInterval(0,0);	
		}
		
		public void removeAllLectures() {
			for (int i = this.tableModel.getRowCount() -1; i>=0; i--) {//0에서부터 시작
				this.tableModel.removeRow(i);
				vCLectures.remove(i);
			}
		}
	}
}
