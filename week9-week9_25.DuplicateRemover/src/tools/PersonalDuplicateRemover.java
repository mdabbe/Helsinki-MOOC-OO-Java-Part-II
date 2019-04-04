package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private int numberOfDetectedDuplicates;
    private Set<String> characterStrings;

    public PersonalDuplicateRemover() {
        this.numberOfDetectedDuplicates = 0;
        this.characterStrings = new HashSet<String>();
    }

    @Override
    public void add(String characterString) {
        if (characterStrings.contains(characterString)) {
            numberOfDetectedDuplicates++;
        } else {
            characterStrings.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return numberOfDetectedDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
            return characterStrings;
    }

    @Override
    public void empty() {
        this.numberOfDetectedDuplicates = 0;
        this.characterStrings.clear();
    }
}
