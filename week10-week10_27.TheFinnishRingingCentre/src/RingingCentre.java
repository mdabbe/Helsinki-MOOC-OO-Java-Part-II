import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    private Map<Bird, List<String>> observationPlaces;

    public RingingCentre() {
        this.observationPlaces = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (observationPlaces.containsKey(bird)) {
            observationPlaces.get(bird).add(place);
        } else {
            observationPlaces.put(bird, new ArrayList<String>());
            observationPlaces.get(bird).add(place);
        }
    }

    public void observations(Bird bird) {
        int numberOfTimesObserved;
        if (observationPlaces.get(bird) != null) {
            numberOfTimesObserved = observationPlaces.get(bird).size();
        } else {
            numberOfTimesObserved = 0;
        }
        System.out.println(bird + " observations: " + numberOfTimesObserved);
        if (numberOfTimesObserved != 0) {
            for (String place : observationPlaces.get(bird)) {
                System.out.println(place);
            }
        }
    }
}
