package com.elon.jdbc.day02.stmt.member.view;

import java.util.List;
import java.util.Scanner;

import com.elon.jdbc.day02.stmt.member.controller.MemberController;
import com.elon.jdbc.day02.stmt.member.model.vo.Member;

public class MemberView {
	private MemberController mController;

	public MemberView() {
		mController = new MemberController();
	}

	// Run에서 시작한 메소드
	public void startProgram() {
		Member member;
		int result;
		String id;
		finish: while (true) {
			int choice = this.printMenu();
			switch (choice) {
			case 1:
				member = addMember();
				result = mController.registerMember(member);
				if (result > 0) {
					printMessage("회원 가입완료");
				} else {
					printMessage("회원 가입이 완료되지 않았습니다.");
				}
				break;
			case 2:
				List<Member> mList = mController.showMemberList();
				printAllMember(mList);
				break;
			case 3:
				id = inputMemberId();
				member = mController.findOneById(id);
				if (member != null) {
					printOne(member);
				} else {
					printMessage("회원 정보가 존재하지 않습니다.");
				}
				break;
			case 4:
				id = inputMemberId();
				member = modifyMember(id);
				result = mController.updateMember(member);
				if (result > 0) {
					printMessage("회원 정보 수정 완료");
				} else {
					printMessage("회원 정보가 수정되지 않았습니다.");
				}
				break;
			case 5:
				id = inputMemberId();
				result = mController.deleteMember(id);
				if (result > 0) {
					printMessage("회원 정보 삭제 완료");
				} else {
					printMessage("회원 정보가 삭제되지 않았습니다.");
				}
				break;
			case 0:
				printMessage("프로그램을 종료합니다.");
				break finish;
			default:
				this.printMessage("1~5 사이의 숫자를 입력해주세요");

			}
		}

	}

	// 아이디 검색시 아이디 입력받기
	private String inputMemberId() {
		System.out.print("아이디 입력: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		return id;
	}

	// 학생 정보 추가시 학생 정보 입력받기
	private Member addMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 정보 입력 ======");
		System.out.print("아이디: ");
		String memberId = sc.next();
		System.out.print("비밀번호: ");
		String memberPwd = sc.next();
		System.out.print("이름: ");
		String memberName = sc.next();
		System.out.print("성별: ");
		char gender = sc.next().charAt(0);
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("전화번호: ");
		String phone = sc.next();
		System.out.print("주소: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미: ");
		String hobby = sc.next();
		Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby);
		return member;
	}

	// 학생 정보 수정시 수정정보 입력받기
	private Member modifyMember(String memberId) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======" + memberId + "님의 회원 정보 수정 ======");
		System.out.print("비밀번호: ");
		String memberPwd = sc.next();
		System.out.print("이름: ");
		String memberName = sc.next();
		System.out.print("성별: ");
		char gender = sc.next().charAt(0);
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("전화번호: ");
		String phone = sc.next();
		System.out.print("주소: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미: ");
		String hobby = sc.next();
		Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby);
		return member;
	}

	// 학생 1개 정보 출력
	private void printOne(Member member) {
		System.out.println("======" + member.getMemberName() + "님의 회원 정보 ======");
		System.out.println("아이디: " + member.getMemberId());
		System.out.println("비밀번호: " + member.getMemberPwd());
		System.out.println("성별: " + member.getGender());
		System.out.println("나이: " + member.getAge());
		System.out.println("이메일: " + member.getEmail());
		System.out.println("연락처: " + member.getPhone());
		System.out.println("주소: " + member.getAddress());
		System.out.println("취미: " + member.getHobby());
		System.out.println("기념일: " + member.getErollDate());
		System.out.println("====================");
	}

	// 학생 전체 정보 출력
	private void printAllMember(List<Member> mList) {
		System.out.println("====== 회원 전체 정보 출력 ======");
		for (Member member : mList) {
			System.out.println("아이디: " + member.getMemberId());
			System.out.println("비밀번호: " + member.getMemberPwd());
			System.out.println("이름: " + member.getMemberName());
			System.out.println("성별: " + member.getGender());
			System.out.println("나이: " + member.getAge());
			System.out.println("이메일: " + member.getEmail());
			System.out.println("연락처: " + member.getPhone());
			System.out.println("주소: " + member.getAddress());
			System.out.println("취미: " + member.getHobby());
			System.out.println("기념일: " + member.getErollDate());
			System.out.println("====================");
		}

	}

	// 메시지 출력
	private void printMessage(String message) {
		System.out.println(message);

	}

	// 메뉴 출력
	private int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 관리 프로그램 ======");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 검색(아이디)");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int menu = sc.nextInt();
		return menu;
	}

}
