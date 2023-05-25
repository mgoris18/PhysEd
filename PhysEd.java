//Michell Gorise

public class PhysEd {

    private String name;
    private int strength;
    private int speed;
    private int intelligence;

    public PhysEd(String name, int speed, int strength, int intelligence) {

        for (int i=0;i<name.length();i++){
            if (!Character.isLetter(name.charAt(i))){
                throw new IllegalArgumentException("ERROR! Name must be consist letters only.");
            }
        }
    
    
    if (speed < -10 || speed > 100)
        throw new IllegalArgumentException("ERROR! Speed must be between -10 to 100");


    if (strength < -10 || strength > 100)
        throw new IllegalArgumentException("ERROR! Strength must be between -10 to 100");


    if (intelligence < -10 || intelligence > 100)
        throw new IllegalArgumentException("ERROR! Speed must be between -10 to 100");


this.name = name;
this.speed = speed;
this.strength = strength;
this.intelligence = intelligence;
}


//method for checking same scores.
public boolean equalScores(PhysEd other){
return speed == other.speed && strength == other.strength &&
        intelligence == other.intelligence;
}


public String getName() {
return name;
}

public int getSpeed() {
return speed;
}

public int getStrength() {
return strength;
}

public int getIntelligence() {
return intelligence;
}
}