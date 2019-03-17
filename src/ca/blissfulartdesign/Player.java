package ca.blissfulartdesign;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private Random rand = new Random();

    private String name;
    private String race;
    private String skill;
    private String gender;
    private int lvl = 1;
    private int hp = 10;
    private int atk;
    private int def;
    private int agi;
    private int wis;
    private int luck;
    private int chr;

    private void setName(String name) {
        this.name = name;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setRace(String race) {
        this.race = race;
    }

    private void setSkill(String skill) {
        this.skill = skill;
    }

    private void setAtk(int atk) {
        this.atk = atk;
    }

    private void setDef(int def) {
        this.def = def;
    }

    private void setAgi(int agi) { this.agi = agi; }

    private void setWis(int wis) {
        this.wis = wis;
    }

    private void setLuck(int luck) {
        this.luck = luck;
    }

    private void setChr(int chr) {
        this.chr = chr;
    }

    private String getSkill() {
        return skill;
    }

    private String getRace() {
        return race;
    }

    private String getGender() {
        return gender;
    }

    public void statGen() {
        //generate player stats
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    int atk = rand.nextInt(6);
                    atk += 1;
                    String atkSkill = this.getSkill();
                    if (atkSkill == "Warrior") {
                        atk += 1;
                    } else if (atkSkill == "Wizard") {
                        atk -= 1;
                    }
                    String atkRace = this.getRace();
                    if (atkRace == "Dwarf") {
                        atk += 1;
                    }
                    this.setAtk(atk);
                    break;
                case 1:
                    int def = rand.nextInt(6);
                    def += 1;
                    String defRace = this.getRace();
                    if (defRace == "Dwarf") {
                        def += 1;
                    }
                    this.setDef(def);
                    break;
                case 2:
                    int wis = rand.nextInt(6);
                    wis += 1;
                    String wisSkill = this.getSkill();
                    if (wisSkill == "Warrior") {
                        wis -= 1;
                    } else if (wisSkill == "Wizard") {
                        wis += 1;
                    }
                    String wisRace = this.getRace();
                    if (wisRace == "Elf") {
                        wis += 1;
                    } else if (wisRace == "Dwarf") {
                        wis -= 1;
                    }
                    this.setWis(wis);
                    break;
                case 3:
                    int luck = rand.nextInt(6);
                    luck += 1;
                    String luckGender = this.gender;
                    if (luckGender == "Female") {
                        luck += 1;
                    }
                    this.setLuck(luck);
                    break;
                case 4:
                    int chr = rand.nextInt(6);
                    chr += 1;
                    String chrGender = this.getGender();
                    if (chrGender == "Female") {
                        chr += 1;
                    }
                    String chrRace = this.getRace();
                    if (chrRace == "Dwarf") {
                        chr -= 1;
                    }
                    this.setChr(chr);
                    break;
                case 5:
                    int agi = rand.nextInt(6);
                    agi += 1;
                    String agiSkill = this.getSkill();
                    if (agiSkill == "Rogue") {
                        agi += 1;
                    }
                    this.setAgi(agi);
                    break;
            }
        }
    }

    public Player() {
        Scanner input = new Scanner(System.in);
        int opt = 0;

        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("What is your name?");
        String name = input.nextLine();
        this.setName(name);
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("Are you (M)ale or (F)emale?");
        char gender = input.next().charAt(0);
        if(gender == 'M' || gender == 'm') {
            this.setGender("Male");
        } else if (gender == 'F' || gender == 'f') {
            this.setGender("Female");
        }
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("What is your race?");
        System.out.println("1. Human");
        System.out.println("2. Elf");
        System.out.println("3. Dwarf");
        opt = input.nextInt();
        if(opt == 1) {
            this.setRace("Human");
        } else if(opt == 2) {
            this.setRace("Elf");
        } else if(opt == 3) {
            this.setRace("Dwarf");
        }
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("What is your discipline?");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.println("3. Rogue");
        opt = input.nextInt();
        if(opt == 1) {
            this.setSkill("Warrior");
        } else if(opt == 2) {
            this.setSkill("Wizard");
        } else if(opt == 3) {
            this.setSkill("Rogue");
        }
        this.statGen();
    }


    public String charSheet() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        StringBuilder charSheet = new StringBuilder();

        charSheet.append(name).append("\n").append(gender).append(" ").append(race).append(" ").append(skill).append("\n").append("Level ").append(lvl).append("\n").append("HP: ").append(hp).append("\n").append("ATK: ").append(atk).append("\n").append("DEF: ").append(def).append("\n").append("AGI: ").append(agi).append("\n").append("WIS: ").append(wis).append("\n").append("LUCK: ").append(luck).append("\n").append("CHR: ").append(chr).append("\n");
        return charSheet.toString();
    }
}