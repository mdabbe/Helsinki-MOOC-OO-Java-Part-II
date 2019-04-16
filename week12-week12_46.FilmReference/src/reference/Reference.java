package reference;

import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person p) {
        if (register.getPersonalRatings(p).isEmpty()) {
            Map<Film, List<Rating>> filmRatings = register.filmRatings();
            List<Film> films = new ArrayList<Film>(filmRatings.keySet());
            Collections.sort(films, new FilmComparator(filmRatings));
            return films.get(0);
        } else {
            List<Person> viewerWithSimilarTasteSorted = reviewersSortedBySimilarity(p);
            return getRecommendedFilm(p, viewerWithSimilarTasteSorted);
        }
    }

    private List<Person> reviewersSortedBySimilarity(Person p) {
        Map<Person, Integer> viewers = reviewerSimilarity(register.getPersonalRatings(p));
        List<Person> similarReviewers = new ArrayList<Person>(viewers.keySet());
        Collections.sort(similarReviewers, new PersonComparator(viewers));
        return similarReviewers;
    }

    private Map<Person, Integer> reviewerSimilarity(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> reviewerSimilarity = new HashMap<Person, Integer>();
        for (Person p : register.reviewers()) {
            int similarity = 0;
            for (Film film : filmRatings.keySet()) {
                similarity += filmRatings.get(film).getValue() * register.getRating(p, film).getValue();
            }
            if (similarity > 0) {
                reviewerSimilarity.put(p, similarity);
            }
        }
        return reviewerSimilarity;
    }

    private Film getRecommendedFilm(Person p, List<Person> reviewersSortedBySimilarity) {
        Map<Film, Rating> viewersSeenFilms = register.getPersonalRatings(p);
        for (Person reviewer : reviewersSortedBySimilarity) {
            if (reviewer == p) {
                continue;
            }
            for (Film film : register.getPersonalRatings(reviewer).keySet()) {
                if (viewersSeenFilms.containsKey(film)) {
                    continue;
                }
                if (register.getPersonalRatings(reviewer).get(film).getValue() > 1) {
                    return film;
                }
            }
        }
        return null;
    }








}
