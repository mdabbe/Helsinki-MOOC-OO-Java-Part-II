import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();

    public VehicleRegister() {
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.get(plate) != null) return false;
        this.owners.put(plate,owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        for (RegistrationPlate p : owners.keySet()) {
            if (p.equals(plate)) {
                return owners.get(p);
            }
        }
        return null;
    }
    public boolean delete(RegistrationPlate plate) {
        if (owners.get(plate) == null) return false;
        owners.remove(plate);
        return true;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> ownersUnique = new ArrayList<String>();
        for (String owner : owners.values()) {
            if (!ownersUnique.contains(owner)) {
                ownersUnique.add(owner);
            }
        }
        for (String owner : ownersUnique) {
            System.out.println(owner);
        }
    }

}
