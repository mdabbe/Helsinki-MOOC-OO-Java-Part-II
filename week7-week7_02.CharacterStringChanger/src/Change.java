public class Change {
    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }

    public String change(String characterString) {
        String from = "" + fromCharacter;
        String to = "" + toCharacter;
        characterString = characterString.replaceAll(from, to);
        return characterString;
//        for (int i = 0; i < characterString.length(); i++) {
//            if (characterString.charAt(i) == fromCharacter) {
//                characterString = characterString.replace(characterString.charAt(i), toCharacter);
//            }
//        }

//        return characterString;
    }
}