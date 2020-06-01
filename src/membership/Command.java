/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;
//command라는 용어를 커맨트패턴에서 많이 사용하길래 사용하였지만 실질적인 기능은 '안내'를 하라고 명령하는 것입니다.
//이것이 실행되면 안내를 하라는 의미로 인지한다.
public interface Command{
	public abstract void execute(); //실행
}