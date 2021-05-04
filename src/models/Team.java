package models;

public class Team implements Comparable<Team> {
	private String teamName;
	private int matchesPlayed;
	private int matchesWon;
	private int matchesLost;
	private int matchesTied;
	private int pointsScored;
	private double netRunRate;
	private String shortName;

	
	public Team(String teamName, int matchesPlayed, int matchesWon, int matchesLost, int matchesTied,
			double netRunRate,int pointsScored,String shortName) {
		super();
		this.teamName = teamName;
		this.matchesPlayed = matchesPlayed;
		this.matchesWon = matchesWon;
		this.matchesLost = matchesLost;
		this.matchesTied = matchesTied;
		this.pointsScored = pointsScored;
		this.netRunRate = netRunRate;
		this.shortName = shortName;
	}

	
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getMatchesWon() {
		return matchesWon;
	}

	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}

	public int getMatchesLost() {
		return matchesLost;
	}

	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}

	public int getMatchesTied() {
		return matchesTied;
	}

	public void setMatchesTied(int matchesTied) {
		this.matchesTied = matchesTied;
	}

	public int getPointsScored() {
		return pointsScored;
	}

	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}

	public double getNetRunRate() {
		return netRunRate;
	}

	public void setNetRunRate(double netRunRate) {
		this.netRunRate = netRunRate;
	}

	@Override
	public int compareTo(Team team) {
		if(team.getPointsScored()==this.getPointsScored()) {
			return team.getNetRunRate()>this.getNetRunRate()?1:-1;
		}
		return team.getPointsScored()>this.getPointsScored()?1:-1;
	}
	
	
}
