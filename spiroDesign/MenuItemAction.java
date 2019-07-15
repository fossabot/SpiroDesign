package spiroDesign;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * メニューが押された時のアクションを設定する
 */
public class MenuItemAction implements ActionListener {

  /**
   * SpiroViewを束縛する
   */
  protected SpiroView sview;

  /**
   * SpiroModelを束縛する
   */
	protected SpiroModel smodel;
    

  /**
   * 依存先のViewとModelを設定する
   * @param aView 依存先のView
   * @param aModel 依存先のModel
   */
  public MenuItemAction(SpiroView aView, SpiroModel aModel) {
    this.sview = aView;
    this.smodel = aModel;
  }

  /**
   * メニューがクリックされた際のアクション
   * @param anActionEvent 表示するコンポーネントのマウスイベント
   */
  public void actionPerformed(ActionEvent anActionEvent) {
      // どのメニューがクリックされたかを調べる
      JMenuItem item = (JMenuItem) anActionEvent.getSource();
      // メニュー文字列を取得
      String text = item.getText();

      if(text.equals("stop")) {
        this.smodel.spiroStop();
      }
      else if(text.equals("start")){
        this.smodel.spiroStart();      
      }
      else if(text.equals("clear")){
        this.smodel.spiroClear(); 
      }
      else if(text.equals("picker")) {
        this.sview.showPopupMenu();
        this.smodel.spiroColor(sview);
      }
      else if(text.equals("rainbow")) {
        this.sview.showPopupMenu();
        this.smodel.pinionGear().penColor(new Color(255, 0, 0));
        this.smodel.isRainbow = true;
      }
      else if(text.equals("thick")) {
        this.sview.showPopupMenu();
        if(this.smodel.pinionGear().penNib() <= 50) this.smodel.pinionGear().penNib(1);
      }
      else if(text.equals("thin")) {
        this.sview.showPopupMenu();
        if(this.smodel.pinionGear().penNib() >= 7) this.smodel.pinionGear().penNib(-1);
      }
      else if(text.equals("speed up")) {
        this.sview.showPopupMenu();
        this.smodel.spiroSpeedUp();
      }
      else if(text.equals("speed down")) {
        this.sview.showPopupMenu();
        this.smodel.spiroSpeedDown();
      }
  }
}