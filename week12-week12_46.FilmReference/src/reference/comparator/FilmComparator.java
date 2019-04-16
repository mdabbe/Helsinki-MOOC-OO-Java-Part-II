package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
       this.ratings = ratings;
    }
    @Override
    public int compare(Film o1, Film o2) {
        double o1Ratings = 0, o2Ratings = 0;
        for (Rating rating : ratings.get(o1)) {o1Ratings += rating.getValue();}
        for (Rating rating : ratings.get(o2)) {o2Ratings += rating.getValue();}
        o1Ratings /= ratings.get(o1).size();
        o2Ratings /= ratings.get(o2).size();
        return (int) (o2Ratings - o1Ratings);
    }

}
