package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import global.Constants.ERegistrationPanel;
import valueObject.VCLecture;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = ERegistrationPanel.serialVersionUID.getInt();
	private ActionListener actionHandler;
	
	private SelectionPanel selectionPanel;
	private MovePanel movePanel1;
	private BasketPanel basketPanel;
	private MovePanel movePanel2;
	private BasketPanel resultPanel;
	
	
	public RegistrationPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.actionHandler = new ActionHandler();

		this.selectionPanel = new SelectionPanel();
		this.add(this.selectionPanel);
		
		this.movePanel1 = new MovePanel(this.actionHandler);
		this.add(this.movePanel1);
		
		this.basketPanel = new BasketPanel();
		this.add(this.basketPanel);
		
		this.movePanel2 = new MovePanel(this.actionHandler);
		this.add(this.movePanel2);
		
		this.resultPanel = new BasketPanel();
		this.add(this.resultPanel);
	}


	public void initialize(String id) throws FileNotFoundException {
		this.selectionPanel.initialize(id);
		this.basketPanel.initialize(id + ERegistrationPanel.basketFileName.getString());
		this.resultPanel.initialize(id + ERegistrationPanel.resultFileName.getString());
	}
	
	public void finish(String id) {
		this.selectionPanel.finish(id);
		this.basketPanel.finish(id + ERegistrationPanel.basketFileName.getString());
		this.resultPanel.finish(id + ERegistrationPanel.resultFileName.getString());
	}
	
	private void removeSelectedBasketLectures() {//왼쪽 <
		this.basketPanel.removeSelectedLectures();
	}
	
	private void moveLecturesToBasket() {//>
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();//결과를
		this.basketPanel.addRows(selectedLectures);//basket에 줌
	}
	
	private void moveLecturesToResult() {//>>
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();//결과를
		this.resultPanel.addRows(selectedLectures);//basket에 줌
	}
	
	private void removeSelectedResultLectures() {//<<
		this.resultPanel.removeSelectedLectures();
	}
	
	private void moveResultToBasket() {//<
		Vector<VCLecture> selectedLectures = this.resultPanel.getSelectedLectures();
		this.basketPanel.addRows(selectedLectures);
	}
	
	private void moveBasketToResult() {//>
		Vector<VCLecture> selectedLectures = this.basketPanel.getSelectedLectures();
		this.resultPanel.addRows(selectedLectures);
	}
	
	public void removeAllLectures() {//전체 삭제 버튼 눌릴 경우
		this.basketPanel.removeAllLectures();
		this.resultPanel.removeAllLectures();
	}
	
	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {//이벤트는 패널이 발생시킨 게 아니라 버튼이 발생시긴 것
			if (event.getSource().equals(movePanel1.getskiptLeftButton())) {
				
			} else if (event.getSource().equals(movePanel1.getLeftButton())) {
				removeSelectedBasketLectures();
			} else if (event.getSource().equals(movePanel1.getRightButton())) {
				moveLecturesToBasket();
			} else if (event.getSource().equals(movePanel1.getskipRightButton())) {
				moveLecturesToResult();
			} else if (event.getSource().equals(movePanel2.getskiptLeftButton())) {
				removeSelectedResultLectures();
			} else if (event.getSource().equals(movePanel2.getLeftButton())) {
				moveResultToBasket();
			} else if (event.getSource().equals(movePanel2.getRightButton())) {
				moveBasketToResult();
			} else if (event.getSource().equals(movePanel2.getskipRightButton())) {
				
			}
		}
	}
}

