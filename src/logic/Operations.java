package logic;

import java.util.List;

import models.Team;

public interface Operations {

	public void addTeam(String name, String shortName);

	public void addMatchResult(int teamA, int teamB, int scoreOfTeamA, int scoreOfTeamB);

	public List<Team> getPointsTable();
	
	public void addStaticTeams();
	
	public List<String> getTeamNames();
	
}
