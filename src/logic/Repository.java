package logic;
import java.util.List;

import database.LocalStorage;
import models.Team;

public class Repository implements Operations {
	
	static Repository instance;
	
	LocalStorage storage;
	
	
	public Repository(){
		storage = LocalStorage.getInstance();
	}
	
	static Repository getInstance() {
		if(instance==null) 
			instance = new Repository();
		return instance;
	}
	
	@Override
	public void addTeam(String name, String shortName) {
		storage.addTeam(name,shortName);
	}

	

	@Override
	public List<Team> getPointsTable() {
		return storage.getPointsTable();
	}

	@Override
	public void addStaticTeams() {
		storage.addStaticTeams();
	}

	@Override
	public List<String> getTeamNames() {
		return storage.getTeamNames();
	}

	@Override
	public void addMatchResult(int teamA, int teamB, int scoreOfTeamA, int scoreOfTeamB) {
		storage.addMatchResult(teamA, teamB, scoreOfTeamA, scoreOfTeamB);
		
	}
	
	

}
