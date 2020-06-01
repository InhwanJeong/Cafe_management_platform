/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

//등급의 쿠폰을 안내하는 Infocoupon 클래스
public class InfocouponNormal implements Command{
	private CouponNormal nor1;
	public InfocouponNormal(CouponNormal nor1) {
		this.nor1 = nor1;
	}
//command 인터페이스의 execute메서드
	public void execute() {
		nor1.display();
	}
}
