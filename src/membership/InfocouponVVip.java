/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

//등급의 쿠폰을 안내하는 Infocoupon 클래스
public class InfocouponVVip implements Command{
	private CouponVVip vvip1;
	public InfocouponVVip(CouponVVip vvip1) {
		this.vvip1 = vvip1;
	}
//command 인터페이스의 execute메서드
	public void execute() {
		vvip1.display();
	}
}
