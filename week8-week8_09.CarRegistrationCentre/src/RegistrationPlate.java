import java.util.Objects;

public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationPlate compared = (RegistrationPlate) o;
        return this.regCode.equals(compared.regCode) && this.country.equals(compared.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regCode, country);
    }
}
