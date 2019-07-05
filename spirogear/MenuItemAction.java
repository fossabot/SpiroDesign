import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MenuItemAction implements ActionListener {

  protected SpiroView sview;

	protected SpiroModel smodel;
    

  // 表示先のテキストエリアを取得するコンストラクタ
  public MenuItemAction(SpiroView aView, SpiroModel aModel) {
    this.sview = aView;
    this.smodel = aModel;
  }

  // メニューがクリックされた際のアクション
  public void actionPerformed(ActionEvent anActionEvent) {
    if(this.sview.isMenuPopuping = true){
      // どのメニューがクリックされたかを調べる
      JMenuItem item = (JMenuItem) anActionEvent.getSource();
      // メニュー文字列を取得
      String text = item.getText();

      if(text.equals("start")){
        this.sview.isMove = true;
        this.smodel.spiroStart();
        
      }
      else if(text.equals("stop")) {
        this.sview.isMove = false;
        this.smodel.spiroStop();
      }
      else if(text.equals("picker")) {
        System.out.println("ok");
        this.sview.showPopupMenu();
        this.smodel.spiroColor(sview);
      }
      else if(text.equals("rainbow")) {
        this.sview.showPopupMenu();
        this.smodel.isRainbow = true;
      }
      else if(text.equals("thick")) {
        this.sview.showPopupMenu();
        if(this.sview.lineSize <= 100) this.sview.lineSize += 10;
      }
      else if(text.equals("thin")) {
        this.sview.showPopupMenu();
        if(this.sview.lineSize >= 10) this.sview.lineSize -= 10;
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
}