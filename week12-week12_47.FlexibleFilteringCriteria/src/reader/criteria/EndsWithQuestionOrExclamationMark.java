package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {



    @Override
    public boolean complies(String line) {
        if (line.isEmpty()) return false;
        char f = line.charAt(line.length()-1);
        return f == '!' || f == '?';
    }
}
