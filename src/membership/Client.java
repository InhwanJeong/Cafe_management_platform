/*
 * @author 20173218 ParkChaeEun
 * team 0201 - CafeManagementSystem
 */
package membership;

import java.util.Scanner;

public class Client { //고객의 요청, 등급에 따라 다른 클래스에서 다른 실행값을 출력
    public void runMembership(int level){
            // 로그인 정보 받아와서 로그인에 있는 토큰이랑 연결해서 level이랑 part에 넣은 다음에 정보 불러와서 출력해주기
                int part = 0; //그냥 초기값 설정 - 받아옴
		
		BenefitNormal normal = new BenefitNormal();
		BenefitVip vip = new BenefitVip();
		BenefitVVip vvip = new BenefitVVip();
	
		Command infobenefitn = new InfobenefitNormal(normal);	
		Command infobenefitv = new InfobenefitVip(vip);	
		Command infobenefitvv = new InfobenefitVVip(vvip);	
		
		CouponNormal normal1 =new CouponNormal();
		CouponVip vip1 = new CouponVip();
		CouponVVip vvip1 = new CouponVVip();
	
		Command infocouponn = new InfocouponNormal(normal1);
		Command infocouponv = new InfocouponVip(vip1);
		Command infocouponvv = new InfocouponVVip(vvip1);
		
		System.out.println("멤버십 기능에 들어오셨습니다.");
		System.out.println("1. 혜택기능과  2.쿠폰기능중 어떤 것을 선택하시겠습니까?(숫자로 입력하여 주십시오)");
		
		Scanner input = new Scanner(System.in); //input으로 값 받아서 part로 기능선택
		part = input.nextInt();
		
		switch(part) {
		case 1:
			if(level == 2) {
				Choose choose1 = new Choose(infobenefitn);
				choose1.select(); //infobenefitn 실행하는 기능
			}
			else if(level == 3) {
				Choose choose2 = new Choose(infobenefitv);
				choose2.select(); //infobenefitv 실행하는 기능
			}
			else if(level == 4) {
				Choose choose3 = new Choose(infobenefitvv);
				choose3.select(); //infobenefitvv 실행하는 기능
			}
			break;
			
		case 2:
			if(level == 1) {
				Choose choose4 = new Choose(infocouponn);
				choose4.select(); //infobenefitn 실행하는 기능			
			}
			else if(level == 2) {
				Choose choose5 = new Choose(infocouponv);
				choose5.select(); //infobenefitn 실행하는 기능			
			}
			else if(level == 3) {
				Choose choose6 = new Choose(infocouponvv);
				choose6.select(); //infobenefitn 실행하는 기능			
			}
			break;
			
		default:
			System.out.println("잘못된 입력입니다. 강제종료합니다.");
			System.exit(0);
				
		}
	}
}