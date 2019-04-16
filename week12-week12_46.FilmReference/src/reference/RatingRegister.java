package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> personalRatings;

    public RatingRegister() {
        filmRatings = new HashMap<Film, List<Rating>>();
        personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!personalRatings.containsKey(person)) {
            personalRatings.put(person, new HashMap<Film, Rating>());
        }
        addRating(film, rating);
        personalRatings.get(person).put(film, rating);

    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (personalRatings.containsKey(person)) {
            return personalRatings.get(person);
        }
        return new HashMap<Film, Rating>();
    }

    public Rating getRating(Person person, Film film) {
        if (personalRatings.containsKey(person)) {
            return personalRatings.get(person).getOrDefault(film, Rating.NOT_WATCHED);
        }
        return Rating.NOT_WATCHED;
    }

    public void addRating(Film film, Rating rating) {
        if (!filmRatings.containsKey(film)) {
            filmRatings.put(film, new ArrayList<Rating>());
        }
        filmRatings.get(film).add(rating);

    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public List<Person> reviewers() {
        return new ArrayList<Person>(personalRatings.keySet());
    }


}
