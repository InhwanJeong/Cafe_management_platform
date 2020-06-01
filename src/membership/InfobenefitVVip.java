/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

public class InfobenefitVVip implements Command{
	private BenefitVVip vvip;
	public InfobenefitVVip(BenefitVVip vvip) {
		this.vvip = vvip;
	}
//command 인터페이스의 execute메서드
	public void execute() {
		vvip.display();
	}
}