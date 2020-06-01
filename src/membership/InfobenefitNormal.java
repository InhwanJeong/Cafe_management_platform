/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

public class InfobenefitNormal implements Command{
	private BenefitNormal nor;
	public InfobenefitNormal(BenefitNormal nor) {
		this.nor = nor;
	}
//command 인터페이스의 execute메서드
	public void execute() {
		nor.display();
	}
}
