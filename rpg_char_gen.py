from os import system, name
from random import randrange

def clear():
    if name == 'nt':
        _ = system('cls')
    else:
        _ = system('clear')

class Player:
    name = ""
    race = ""
    skill = ""
    gender = ""
    lvl = 1
    hp = 10
    atk = 0
    dfs = 0
    agi = 0
    wis = 0
    luck = 0
    cha = 0

    def __init__(self):
        clear()
        self.name = input("What is your name?: ")
        clear()
        gender = input("Are you (M)ale or (F)emale?: ")
        if (gender == 'M' or gender == 'm'):
            self.gender = "Male"
        elif (gender == 'F' or gender =='f'):
            self.gender = "Female"
        clear()
        print("1. Human")
        print("2. Elf")
        print("3. Dwarf")
        race = input("What is your race?: ")
        race = int(race)
        if (race == 1):
            self.race = "Human"
        elif (race == 2):
            self.race = "Elf"
        elif (race == 3):
            self.race = "Dwarf"
        clear()
        print("1. Warrior")
        print("2. Wizard")
        print("3. Rogue")
        skill = input("What is your discipline?: ")
        skill = int(skill)
        if (skill == 1):
            self.skill = "Warrior"
        elif (skill == 2):
            self.skill = "Wizard"
        elif(skill == 3):
            self.skill = "Rogue"
        self.statGen()

    def statGen(self):
        self.atk = randrange(1, 6)
        if (self.skill == "Warrior"):
            self.atk += 1
        elif (self.skill == "Wizard"):
            self.atk -= 1
        if (self.race == "Dwarf"):
            self.atk += 1
        self.dfs = randrange(1, 6)
        if (self.race == "Dwarf"):
            self.dfs += 1
        self.agi = randrange(1, 6)
        if (self.skill == "Rogue"):
            self.agi += 1
        self.wis = randrange(1, 6)
        if (self.skill == "Wizard"):
            self.wis += 1
        elif (self.skill == "Warrior"):
            self.wis -= 1
        if (self.race == "Elf"):
            self.wis += 1
        elif (self.race == "Dwarf"):
            self.wis -= 1
        self.cha = randrange(1,6)
        if (self.gender == "Female"):
            self.cha += 1 
        if (self.race == "Dwarf"):
            self.cha -= 1
        self.luck = randrange(1,6)
        if (self.gender == "Female"):
            self.luck += 1
    
    def charSheet(self):
        clear()
        print ("%s"%self.name)
        print ("%s %s %s"%(self.gender,self.race,self.skill))
        print ("ATK: %d"%self.atk)
        print ("DEF: %d"%self.dfs)
        print ("AGI: %d"%self.agi)
        print ("WIS: %d"%self.wis)
        print ("CHR: %d"%self.cha)
        print ("LUCK: %d"%self.luck)

def main():
    create = True
    char = True
    while (create == True):
        char = True
        p = Player()
        while (char == True):
            p.charSheet()
            opt = input("Are you pleased with your character? (Y/N): ")
            if (opt == 'N' or opt == 'n'):
                opt = input("(R)eroll Stats or Start (F)resh?: ")
                if (opt == 'R' or opt == 'r'):
                    p.statGen()
                elif (opt == 'F' or opt == 'f'):
                    char = False
            elif (opt == 'Y' or opt == 'y'):
                create = False
                char = False
        
                clear()
                input("Press enter to continue")
    
main()