package member.view;

import java.util.Scanner;

import member.model.dao.MemberManager;


public class MemberMenu {
		Scanner sc = new Scanner(System.in);
		MemberManager manager = new MemberManager();
		
		
		public MemberMenu(){}
		
		public void mainMenu(){
			while(true){
			System.out.println("***** 회원 관리 프로그램 *****");
			System.out.println("1.새 회원등록");
			System.out.println("2.회원 조회");
			System.out.println("3.회원 정보 수정 ");
			System.out.println("4.회원 정보 정렬");
			System.out.println("5.회원 삭제");
			System.out.println("6.모두 출력");
			System.out.println("9.끝내기");
			System.out.print("메뉴 입력");
			int input = sc.nextInt();
			
			switch(input){
			case 1 : manager.memberInput();break;
			case 2 : searchMenu(); break;
			case 3 : modifyMenu(); break;
			case 4 :sortMenu(); break;
			case 5 :manager.deleteMember(); break;
			case 6 :manager.printAllMember(); break;
			}
			if(input==9){
				System.out.print("정말 끝내시겠습니까?y/n");
				char end = sc.next().charAt(0);
				if(end=='y'||end=='Y'){break;}
				}
			else
				continue;
			}
			
		}
		public void searchMenu(){
			int index = -1;
			System.out.println("*****회원 정보 검색 메뉴*****");
			System.out.println("1.아이디로 검색");
			System.out.println("2.이름으로 검색");
			System.out.println("3.이메일로 검색");
			System.out.println("9.이전 메뉴로 돌아가기");
			System.out.print("번호 입력 : ");
			int input = sc.nextInt();
			
			if(input==9){
				System.out.println("메인으로 돌아갑니다");
				mainMenu();
			}
			switch(input){
			case 1 : System.out.print("검색할 id입력");String inId=sc.next(); index= manager.serchMemberId(inId);break;
			case 2 :System.out.print("검색할 이름입력");String input3 = sc.next(); index=manager.seachMemberName(input3);break; 
			case 3 :System.out.print("검색할 이메일입력"); String input4 = sc.next(); index=manager.searchMemberEmail(input4);break;
			}
			if(index==-1){
				System.out.println("회원정보가 존재하지않습니다");
			}
			else
				manager.printMember(index);
		}
		
		public void modifyMenu(){
			int index=-1;
			System.out.println("***** 회원 정보 수정 메뉴 *****");
			System.out.println("1.암호 변경");
			System.out.println("2.이메일 변경");
			System.out.println("3.나이 변경");
			System.out.println("9.이전 메뉴로 돌아가기");
			System.out.print("번호 입력 : ");
			int input = sc.nextInt();
			
			if(input==9){
				System.out.println("메인으로 돌아갑니다");
				mainMenu();
			}
			switch(input){
			case 1:System.out.print("검색할 id입력");String inId=sc.next(); index= manager.serchMemberId(inId);manager.setPassword(index); break;
			case 2:System.out.print("검색할 id입력");String inId2=sc.next(); index= manager.serchMemberId(inId2);manager.setEmail(index); break;
			case 3:System.out.print("검색할 id입력");String inId3=sc.next(); index= manager.serchMemberId(inId3);manager.setnewAge(index); break;
			}
			
		}
		
		public void sortMenu(){
			System.out.println("***** 회원 정보 정렬 메뉴 *****");
			System.out.println("1.아이디순 오름차순");
			System.out.println("2.아이디순 내림차순");
			System.out.println("3.나이순 오름차순");
			System.out.println("4.나이순 내림차순");
			System.out.println("5.성별순 오름차순");
			System.out.println("9.이전 메뉴로 돌아가기");
			System.out.print("번호 입력 : ");
			int input = sc.nextInt();
			System.out.println();
			if(input==9){
				System.out.println("메인으로 돌아갑니다");
				mainMenu();
			}
			switch(input){
			case 1 :manager.sortIDAsc();break;
			case 2 : manager.sortAgeDes(); break;
			case 3 : manager.sortAgeAsc();break;
			case 4 : manager.sortAgeDes(); break;
			case 5 : manager.sortGenderDes(); break;
			}
			
		}
		
}
