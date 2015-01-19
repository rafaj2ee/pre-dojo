package br.com.amil.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.joda.time.DateTime;

public class Player implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8129484852898979788L;

	private TreeMap<DateTime, String[]> events = new TreeMap<DateTime, String[]>();
	
	private String name;
	private int kills = 0;
	private int deaths = 0;
	
	private int mostUsedWeaponkills = 0;
	private String mostUsedWeapon = "";
	
	private TreeMap<String, Integer> weapons  = new TreeMap<String, Integer>();
	
	private DateTime lastKill = null;
	
	private int lasMinuteKill = 0;
	
	private List<String> awards = new ArrayList<String>();

	public TreeMap<DateTime, String[]> getEvents() {
		return events;
	}

	public void setEvents(TreeMap<DateTime, String[]> events) {
		this.events = events;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getMostUsedWeaponkills() {
		return mostUsedWeaponkills;
	}

	public void setMostUsedWeaponkills(int mostUsedWeaponkills) {
		this.mostUsedWeaponkills = mostUsedWeaponkills;
	}

	public String getMostUsedWeapon() {
		return mostUsedWeapon;
	}

	public void setMostUsedWeapon(String mostUsedWeapon) {
		this.mostUsedWeapon = mostUsedWeapon;
	}

	public DateTime getLastKill() {
		return lastKill;
	}

	public void setLastKill(DateTime lastKill) {
		this.lastKill = lastKill;
	}

	public TreeMap<String, Integer> getWeapons() {
		return weapons;
	}

	public void setWeapons(TreeMap<String, Integer> weapons) {
		this.weapons = weapons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getLasMinuteKill() {
		return lasMinuteKill;
	}

	public void setLasMinuteKill(int lasMinuteKill) {
		this.lasMinuteKill = lasMinuteKill;
	}

	public List<String> getAwards() {
		return awards;
	}

	public void setAwards(List<String> awards) {
		this.awards = awards;
	}
	
	
}
