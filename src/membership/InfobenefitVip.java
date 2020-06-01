/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

public class InfobenefitVip implements Command{
	private BenefitVip vip;
	public InfobenefitVip(BenefitVip vip) {
		this.vip = vip;
	}
//command 인터페이스의 execute메서드
	public void execute() {
		vip.display();
	}
}
