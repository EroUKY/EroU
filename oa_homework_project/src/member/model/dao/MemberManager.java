package member.model.dao;

import java.util.Scanner;

import member.model.dto.Member;
import member.view.MemberMenu;

public class MemberManager {
		public static int SIZE=10;
		Scanner sc = new Scanner(System.in);
		Member m[] = new Member[SIZE];
		Member m2[] = new Member[SIZE];
		Member m3[] = new Member[1];
		
		Member member = new Member();
		private int index=0;
		{
		m[0] =new Member("kimgi0","김기영","921122","wjsghs@naver.com",'남',27);
		m[1] =new Member("umji","김예원","980819","umji@naver.com",'여',21);
		m[2] =new Member("sinB","황은비","980603","sinB@naver.com",'여',21);
		m[3] =new Member("challyK","곽수현","920514","challyK@naver.com",'남',27);
		m[4] =new Member("sowon","김소정","951207","sowon@naver.com",'여',24);
		index = 5;
		m3[0] = null;
		}
		
		
		
		public void memberInput(){
			System.out.print("id입력");
			String id = sc.next();
			System.out.print("이름 입력");
			String name = sc.next();
			System.out.print("비밀번호 입력");
			String password = sc.next();
			System.out.print("e메일 입력");
			String email = sc.next();
			System.out.print("성별 입력");
			char gender = sc.next().charAt(0);
			System.out.print("나이 입력");
			int age = sc.nextInt();
			m[index] = new Member(id,name,password,email,gender,age);
			index++;
		}
		public int serchMemberId(String id){
			int result = -1;
			String mid=id;
			for(int i = 0;i<index;i++){
				if(mid.equals(m[i].getId())){
				result = i;
				break;
				}	
			}		
			return result;
		}
		public int seachMemberName(String name){
			String mname = name;
			int result = -1;
			for(int i = 0;i<index;i++){
				if(mname.equals(m[i].getName())){
				result = i;
				break;
				}	
			}		
			return result;
			}
		
		public int searchMemberEmail(String email){
			String memail = email;
			int result = -1;
			for(int i = 0;i<index;i++){
				if(memail.equals(m[i].getEmail())){
				result = i;
				break;
				}	
			}		
			return result;
		}
		
		public void printMember(int index){
			this.index = index;
			m[index].memberInfo();
		}
		public void deleteMember(){
			System.out.print("삭제할 id입력해주세요");
			String mid=sc.next();
			int save = 0;
			for(int i = 0;i<index;i++){
				if(mid.equals(m[i].getId())){
				m[i].memberInfo();
				save = i;
				break;
				}
			}
			System.out.print("정말 지우시겠습니까?y/n");
			char inC=sc.next().charAt(0);
			
			if(inC=='Y'||inC=='y'){
				m[save] = null;
				if(save!=index){
					for(int i=0;i<index;i++){
						if(m[i]==null&&m[i+1]!=null){
							m[i]=m[i+1];
							m[i+1]=null;
						}
					}
				}
			}
			index--;
		}
		public void printAllMember(){
			for(int i = 0;i<index;i++){
				if(m[i]!=null){
				m[i].memberInfo();
					}
				}
		}
		public void setPassword(int result){
			m[result].memberInfo();
			System.out.print("교체할 비밀번호 입력");
			String changePassword = sc.next();
			m[result].setPassword(changePassword);
		}
		public void setEmail(int result){
			
			m[result].memberInfo();
			System.out.print("교체할 E-mail 입력");
			String changeEmail = sc.next();
			m[result].setEmail(changeEmail);
		}
		public void setnewAge(int result){
			
			m[result].memberInfo();
			System.out.print("교체할 나이 입력");
			int changeAge = sc.nextInt();
			m[result].setAge(changeAge);
		}
		public void sortIDAsc(){
			
			for(int i = 0;i<index;i++){
				m2[i] = new Member(m[i].getId(),m[i].getName(),m[i].getPassword(),m[i].getEmail(),m[i].getGender(),m[i].getAge());
				}
			for(int i = 0 ;i<index;i++){
				for(int j = i; j<index;j++){
					if((m2[i].getId()).compareTo(m2[i].getId())<(m2[i].getId()).compareTo(m2[j].getId())){
						m3[0] = m2[j];
						m2[j] = m2[i];
						m2[i] = m3[0];
					}
				}
			}
			for(int i = 0;i<index;i++){
				m2[i].memberInfo();	
				}
		}
		
		public void sortIDDes(){
			for(int i = 0;i<index;i++){
				m2[i] = new Member(m[i].getId(),m[i].getName(),m[i].getPassword(),m[i].getEmail(),m[i].getGender(),m[i].getAge());
				}
			for(int i = 0 ;i<index;i++){
				for(int j = i; j<index;j++){
					if((m2[i].getId()).compareTo(m2[i].getId())>(m2[i].getId()).compareTo(m2[j].getId())){
						m3[0] = m2[j];
						m2[j] = m2[i];
						m2[i] = m3[0];
					}
				}
			}
			for(int i = 0;i<index;i++){
				m2[i].memberInfo();	
				}
		}
		
		public void sortAgeAsc(){
			for(int i = 0;i<index;i++){
				m2[i] = new Member(m[i].getId(),m[i].getName(),m[i].getPassword(),m[i].getEmail(),m[i].getGender(),m[i].getAge());
				}
			for(int i = 0 ;i<index;i++){
				for(int j = i; j<index;j++){
					if(m2[i].getAge()>m2[j].getAge()){
						m3[0] = m2[j];
						m2[j] = m2[i];
						m2[i] = m3[0];
					}
				}
			}
			for(int i = 0;i<index;i++){
				m2[i].memberInfo();	
				}
		}
		
		public void sortAgeDes(){
			for(int i = 0;i<index;i++){
				m2[i] = new Member(m[i].getId(),m[i].getName(),m[i].getPassword(),m[i].getEmail(),m[i].getGender(),m[i].getAge());
				}
			for(int i = 0 ;i<index;i++){
				for(int j = i; j<index;j++){
					if(m2[i].getAge()<m2[j].getAge()){
						m3[0] = m2[j];
						m2[j] = m2[i];
						m2[i] = m3[0];
					}
				}
			}
			for(int i = 0;i<index;i++){
				m2[i].memberInfo();	
				}
		}
		public void sortGenderDes(){
			for(int i = 0;i<index;i++){
				m2[i] = new Member(m[i].getId(),m[i].getName(),m[i].getPassword(),m[i].getEmail(),m[i].getGender(),m[i].getAge());
				}
			for(int i = 0 ;i<index;i++){
				for(int j = i; j<index;j++){
					if(m2[i].getGender()>m2[j].getGender()){
						m3[0] = m2[j];
						m2[j] = m2[i];
						m2[i] = m3[0];
					}
				}
			}
			for(int i = 0;i<index;i++){
				m2[i].memberInfo();	
				}
		}
		
}
