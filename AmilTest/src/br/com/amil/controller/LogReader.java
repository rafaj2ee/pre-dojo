package br.com.amil.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import org.joda.time.DateTime;

import br.com.amil.entity.Player;
import br.com.amil.util.FileUtils;

public class LogReader {
	public static final String 	LINE_NEXT 		= "\n";
	public static final String 	WORLD 		= "<WORLD>";
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyHH:mm:ss");
	
	public static void main(String args[]) throws Exception {
		if(args.length==0) {
			throw new Exception("Arquivo Vazio");
		}
		String logString = FileUtils.readFileAsString(args[0]);
		TreeMap<String, Player> result = new TreeMap<String,Player>();
		String splittedLog[] = logString.split(LINE_NEXT);
		for(String logLine : splittedLog) {
			String splittedLine[] = logLine.split(" ");
			//System.out.println(splittedLine[3]);

			if(splittedLine[3].equals("New")) {
				continue;
			}
			if(splittedLine[3].equals("Match")) {
				continue;
			}
			//System.out.println(splittedLine[3]+" "+splittedLine[3].length()+" "+splittedLine[3].equals(WORLD));
			if(result.get(splittedLine[3])!=null) {
				
				Player player = result.get(splittedLine[3]);
				DateTime dateTime = populateEvent(splittedLine, player);
				
				TreeMap<String, Integer> weapons = player.getWeapons();
				player.setKills(player.getKills()+1);
				
				if(weapons.get(splittedLine[7])!=null) {
					weapons.put(splittedLine[7], (Integer) weapons.get(splittedLine[7]) +1);
				} else {
					weapons.put(splittedLine[7], new Integer(1));
				}
				if(player.getLasMinuteKill()>0) {
					DateTime timeToCompare = player.getLastKill().plusSeconds(60);
					if(timeToCompare.isBefore(dateTime)) {
						if(player.getLasMinuteKill()==4) {
							player.setLasMinuteKill(0);
							player.getAwards().add("Killing Streak "+player.getAwards().size());	
						} else {
							player.setLasMinuteKill(player.getLasMinuteKill()+1);							
						}

					} else {
						player.setLasMinuteKill(1);
						player.setLastKill(dateTime);
					}
				} else {
					player.setLastKill(dateTime);	
				}
				
				
				result.put(splittedLine[3], player);
				if(result.get(splittedLine[5])==null) {
					Player deathPlayer = new Player();
					deathPlayer.setName(splittedLine[5]);
					deathPlayer.setDeaths(1);
					populateEvent(splittedLine, deathPlayer);
					result.put(splittedLine[5], deathPlayer);
				} else {
					Player deathPlayer = result.get(splittedLine[5]);
					deathPlayer.setDeaths(deathPlayer.getDeaths()+1);
					populateEvent(splittedLine, deathPlayer);
					result.put(splittedLine[5], deathPlayer);
				}
			} else {
				Player player = new Player();
				player.setName(splittedLine[3]);
				player.setKills(+1);
				populateEvent(splittedLine, player);
				player.getWeapons().put(splittedLine[7], new Integer(1));
				result.put(splittedLine[3], player);

				
			}
			//System.out.println(logLine);
		}
		int kills = 0;
		String bestKiller = "";
		int weaponKill = 0;
		String weaponUsed = "";
		//Player bestPlayer = null;
		for(String key: result.keySet()) {
			if(!key.equals(WORLD)) {
				Player player = result.get(key);
				if(player.getKills()>kills) {
					kills = player.getKills();
					bestKiller = player.getName();
					for(String weaponKey:player.getWeapons().keySet()) {
						Integer weaponTemp = player.getWeapons().get(weaponKey);
						if(weaponTemp>weaponKill) {
							weaponKill = weaponTemp;
							player.setMostUsedWeapon(weaponKey);
							player.setMostUsedWeaponkills(weaponTemp);
							weaponUsed = weaponKey;
						}
					}
				}
				if(player.getDeaths()==0) {
					player.getAwards().add("Didn't Died");					
				}

				
			}						
		}
		System.out.println("Best player " + bestKiller + " killed " + kills + " most used weapon " + weaponUsed);
		for(String key: result.keySet()) {
			if(!key.equalsIgnoreCase(WORLD)) {
				Player player = result.get(key);					
				for(String awardKey:player.getAwards()) {
					System.out.println("Award for " + player.getName() + " by " + awardKey);
				}
			}
		}
	}

	private static DateTime populateEvent(String[] splittedLine, Player player)
			throws ParseException {
		Date date = sdf.parse(splittedLine[0]+splittedLine[1]);
		DateTime dateTime = new DateTime(date);
		player.getEvents().put(dateTime, splittedLine);
		return dateTime;
	}
}
