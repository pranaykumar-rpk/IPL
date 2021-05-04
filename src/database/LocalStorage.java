package database;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import logic.Operations;
import models.Match;
import models.Team;

public class LocalStorage implements Operations{
	
	private static LocalStorage instance;
	private List<Team> teams = new ArrayList<>();

	public LocalStorage(List<Team> teams) {
		super();
		this.teams = teams;
	}
	
	public static LocalStorage getInstance() {
		if(instance == null)
			instance = new LocalStorage();
		return instance;
	}

	public LocalStorage() {
		super();
	}
	
	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	
	@Override
	public void addTeam(String name, String shortName) {
		teams.add(new Team(name,0,0,0,0,0.0,0,shortName.toUpperCase()));
	}


	@Override
	public List<Team> getPointsTable() {
		List<Team> listOfTeam = teams;
		Collections.sort(listOfTeam);
		return listOfTeam;
	}

	@Override
	public void addStaticTeams() {
		teams.clear();
		teams.add(new Team("Royal Challengers Bangolore",0,0,0,0,0.0,0,"RCB"));
		teams.add(new Team("Kolkata Kight Riders",0,0,0,0,0.0,0,"KKR"));
		teams.add(new Team("Chennai Super Kings",0,0,0,0,0.0,0,"CSK"));
		teams.add(new Team("Mumbai Indians",0,0,0,0,0.0,0,"MI"));
		teams.add(new Team("Sunrisers Hyderabad",0,0,0,0,0.0,0,"SRH"));
		teams.add(new Team("Punjab Kings",0,0,0,0,0.0,0,"PBKS"));
		teams.add(new Team("Rajasthan Royals",0,0,0,0,0.0,0,"RR"));
		teams.add(new Team("Delhi Capitals",0,0,0,0,0.0,0,"DC"));
	}

	@Override
	public List<String> getTeamNames(){
		List<String> teamNames = new ArrayList<>();
		for(int index=0;index<teams.size();index++) {
			teamNames.add(teams.get(index).getTeamName()+"("+teams.get(index).getShortName()+")");
		}
		return teamNames;
	}

	@Override
	public void addMatchResult(int teamA, int teamB, int scoreOfTeamA, int scoreOfTeamB) {
		String winningTeam;
		//Incrementing matches played
		teams.get(teamA).setMatchesPlayed(teams.get(teamA).getMatchesPlayed()+1);
		teams.get(teamB).setMatchesPlayed(teams.get(teamB).getMatchesPlayed()+1);
		if(scoreOfTeamA==scoreOfTeamB) {
			//increment ties in case of draw
			teams.get(teamA).setMatchesTied(teams.get(teamA).getMatchesTied()+1);
			teams.get(teamB).setMatchesTied(teams.get(teamB).getMatchesTied()+1);
		}else if(scoreOfTeamA>scoreOfTeamB) {
			//increment wins/losses
			teams.get(teamA).setMatchesWon(teams.get(teamA).getMatchesWon()+1);
			teams.get(teamB).setMatchesLost(teams.get(teamB).getMatchesLost()+1);
			teams.get(teamA).setPointsScored(teams.get(teamA).getPointsScored()+2);
			teams.get(teamA).setNetRunRate(teams.get(teamA).getNetRunRate()+getCalculatedRunRate(scoreOfTeamA,scoreOfTeamB));
			teams.get(teamB).setNetRunRate(teams.get(teamB).getNetRunRate()-getCalculatedRunRate(scoreOfTeamA,scoreOfTeamB));
		}else {
			//increment wins/losses
			teams.get(teamB).setMatchesWon(teams.get(teamB).getMatchesWon()+1);
			teams.get(teamA).setMatchesLost(teams.get(teamA).getMatchesLost()+1);
			teams.get(teamB).setPointsScored(teams.get(teamB).getPointsScored()+2);
			teams.get(teamB).setNetRunRate(teams.get(teamB).getNetRunRate()+getCalculatedRunRate(scoreOfTeamA,scoreOfTeamB));
			teams.get(teamA).setNetRunRate(teams.get(teamA).getNetRunRate()-getCalculatedRunRate(scoreOfTeamA,scoreOfTeamB));
		}
		//Match match = new Match(teams.get(teamA).getTeamName(),teams.get(teamB).getTeamName(),);
	}
	
	public double getCalculatedRunRate(int score1,int score2) {
		
		double difference = Math.abs((score1 - score2));
		System.out.println("Difference:"+difference);
		double rr = (double) (difference/120);
		DecimalFormat df = new DecimalFormat("#.000");
		return Double.parseDouble(df.format(rr)) ;
	
	}
}
