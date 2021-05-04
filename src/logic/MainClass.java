package logic;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.Team;

public class MainClass {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		int choice ; 
		showMenusList();
		try {
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				handlePointsTable();
				showMenu();
				break;
			}
			case 2:{
				addTeam();
				showMenu();
				break;
			}
			case 3:{
				handleAddMatchData();
				showMenu();
				break;
			}
			case 4:{
				addStaticTeam();
				showMenu();
				break;
			}
			default :{
			System.out.println("Please enter only options shown above");	
			}
		}
		}catch(InputMismatchException e) {
			System.out.println("No charcters and sepecial characters are allowed");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void handleAddMatchData() {
		List<String> teams = Repository.getInstance().getTeamNames();
		System.out.println("Select match between teams");
		for(int index=0;index<teams.size();index++) {
			System.out.println(index+1+"."+teams.get(index));
		}
		int firstTeam;
		int secondTeam;
		System.out.println("Enter 1st team");
		firstTeam = sc.nextInt();
		System.out.println("Enter 2nd team");
		secondTeam = sc.nextInt();
		System.out.println("Enter runs scored by First team");
		int scoreOfTeamA = sc.nextInt(); 
		System.out.println("Enter runs scored by Second team");
		int scoreOfTeamB = sc.nextInt();
		Repository.getInstance().addMatchResult(firstTeam-1,secondTeam-1,scoreOfTeamA,scoreOfTeamB);
	}

	private static void addStaticTeam() {
		Repository.getInstance().addStaticTeams();
		System.out.println("Added teams Succesfully");
	}

	private static void handlePointsTable() {
		System.out.println("Showing Points table");
		List<Team> teams = Repository.getInstance().getPointsTable();
		
		System.out.println("S.No	Team	M	W	L	T	NRR	Pts");
		
		for(int index = 0; index <teams.size();index++) {
			System.out.println((index+1)+ "	"+getTeamData(teams.get(index)));
		}
		System.out.println("\n \n \n");
	}

	private static void showMenusList() {
		System.out.println("Enter your choice");
		System.out.println("1.Show Points Table");
		System.out.println("2.Add Team");
		System.out.println("3.Add Match result");
		System.out.println("4.Add Static Teams");

	}

	private static void addTeam() {
		System.out.println("Enter Team Name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter Short Name");
		String shortName = sc.nextLine();
		Repository.getInstance().addTeam(name,shortName);
		
	}
	
	public static String getTeamData(Team team) {
		return team.getShortName()+"	"+team.getMatchesPlayed()+"	"+team.getMatchesWon()+"	"+team.getMatchesLost()+
				"	"+team.getMatchesTied()+"	"+team.getNetRunRate()+"	"+team.getPointsScored();
	}

}
