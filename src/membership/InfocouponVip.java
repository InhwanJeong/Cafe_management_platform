/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

//등급의 쿠폰을 안내하는 Infocoupon 클래스
public class InfocouponVip implements Command{
	private CouponVip vip1;
	public InfocouponVip(CouponVip vip1) {
		this.vip1 = vip1;
	}
//command 인터페이스의 execute메서드
	public void execute() {
		vip1.display();
	}
}