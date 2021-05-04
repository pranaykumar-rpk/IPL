package models;

public class Match {
	
	private String team1Name;
	private String team2name;
	private String winningTeam;
	private int team1Score;
	private int team2Score;
	public Match(String team1Name, String team2name, String winningTeam, int team1Score, int team2Score) {
		super();
		this.team1Name = team1Name;
		this.team2name = team2name;
		this.winningTeam = winningTeam;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}
	
	public String getTeam1Name() {
		return team1Name;
	}
	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}
	public String getTeam2name() {
		return team2name;
	}
	public void setTeam2name(String team2name) {
		this.team2name = team2name;
	}
	public String getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
	public int getTeam1Score() {
		return team1Score;
	}
	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}
	public int getTeam2Score() {
		return team2Score;
	}
	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}
	
	
}
