/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;
//choose는 커맨드패턴에서 button과 같은 의미로, 선택되었을 때 필요한 기능을 인지한다.
public class Choose {
	private Command co; //command -> co
						//생성자에서 특정 기능을 선택받았을 때 거기에 필요한 기능을 인지한다.
	public Choose(Command co) { setcommand(co);}
	private void setcommand(Command co2) { this.co = co2;}
						
	public void select() {//선택되면 주어진 command의 execute메서드를 호출한다.
		co.execute();
	}
}
